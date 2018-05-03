from esipy import App
from esipy import EsiClient
from time import sleep
import math
import pprint
import gzip
import json
import csv

# Constants
jsonfilename                  = "resources/eve_skills.json.gz"
alpha_skill_list              = "resources/alpha_skill_list.txt"
SKILL_CATEGORY_ID             = 16
SKILL_TIME_CONSTANT_ATTR_ID   = 275
PRIMARY_ATTRIBUTE_ID          = 180
SECONDARY_ATTRIBUTE_ID        = 181
CAN_TRAIN_ON_TRIAL_ATTR_ID    = 1047
REQUIRED_SKILL_ATTR_IDS       = [182, 183, 184, 1285, 1289, 1290]
REQUIRED_SKILL_LEVEL_ATTR_IDS = [277, 278, 279, 1286, 1287, 1288]
ATTRIBUTE_NAMES = {
  164 : "Charisma",
  165 : "Intelligence",
  166 : "Memory",
  167 : "Perception",
  168 : "Willpower",
}

# Our finalized data structure
skill_list = []
pp = pprint.PrettyPrinter(indent=4)

# Setup app and client
app = App.create(url="https://esi.tech.ccp.is/latest/swagger.json?datasource=tranquility")
client = EsiClient(
  retry_requests = True,
  header={'User-Agent': 'kylaconstantine13@gmail.com'},
  raw_body_only=False,
)

# 'skill_points_required' : {
#   1 : 250 * rank,
#   2 : 1415 if rank == 1 else int(rank * 1414.3 + 0.5),
#   3 : 8000 * rank,
#   # (2.5 * level - 2.5)
#   4 : int(math.ceil((2.5 * 4 - 2.5)**2 * 250 * rank)),
#   5 : 256000 * rank,
# },

# Get market prices into a dict
market_operation = app.op['markets_prices']()
market_response = client.request(market_operation)
market_info = market_response.data
market_prices = {price.get('type_id'):price.get("average_price") for price in market_info}

# Get Alpha skills into a dict
alpha_skills = {}
with open(alpha_skill_list, 'r') as fin:
  next(fin)
  reader = csv.reader(fin, delimiter='\t')
  for group, skill, cap, points in reader:
    alpha_skills[skill] = cap

# Get skill groups
skill_groups_operation = app.op['universe_categories_category_id'](
  category_id = SKILL_CATEGORY_ID,
)
skill_group_response = client.request(skill_groups_operation)

# Get info for each group
groups = skill_group_response.data.groups
for group_id in groups:
  group_operation = app.op['universe_groups_group_id'](
    group_id = group_id
  )
  group_response = client.request(group_operation)
  group_info = group_response.data
  group_data = {
    'id'     : group_id,
    'name'   : group_info.get('name', "Unknown Skill Group"),
    'skills' : [],
  }

  print("Got Skill Group: %s" % group_data.get('name'))

  # Get the skill type info within each group
  types = group_info.types
  for counter, type_id in enumerate(types):
    type_operation = app.op['universe_types_type_id'](
      type_id = type_id
    )
    type_response = client.request(type_operation)
    type_info = type_response.data

    # Want to keep the following data:
    # description, icon_id, market_group_id, name, type_id
    # attributes, effects
    attributes = {attr.get('attribute_id'):attr.get('value') for attr in type_info.get('dogma_attributes')}
    type_data = {
      'id'                  : type_info.get('type_id', None),
      'array_index'         : counter,
      'name'                : type_info.get('name', "Unknown Skill"),
      'description'         : type_info.get('description', "An unknown skill."),
      'rank'                : int(attributes.get(SKILL_TIME_CONSTANT_ATTR_ID, 1)),
      'group'               : group_info.get('name', "Unknown Skill Group"),
      'is_public'           : type_info.get('published', False),
      'primary_attribute'   : ATTRIBUTE_NAMES.get(int(attributes.get(PRIMARY_ATTRIBUTE_ID, 0)), None),
      'secondary_attribute' : ATTRIBUTE_NAMES.get(int(attributes.get(SECONDARY_ATTRIBUTE_ID, 0)), None),
      'can_train_on_trial'  : (False if attributes.get(CAN_TRAIN_ON_TRIAL_ATTR_ID, 0) else True),
      'can_train_on_alpha'  : type_info.get('name', None) in alpha_skills,
      'alpha_level_cap'     : alpha_skills.get(type_info.get('name', None), 0),
      'prerequisites'       : [],
    }
    if type_data['id'] and market_prices.get(type_data['id'], 0):
      type_data['cost'] = round(market_prices.get(type_data['id'], 0))

    print("Got Skill: %s" % type_data.get("name"))

    for i, attr_id in enumerate(REQUIRED_SKILL_ATTR_IDS):
      level_id = REQUIRED_SKILL_LEVEL_ATTR_IDS[i]
      if not attributes.get(attr_id) or not attributes.get(level_id):
        continue
      req_type_operation = app.op['universe_types_type_id'](
        type_id = int(attributes.get(attr_id))
      )
      req_type_response = client.request(req_type_operation)
      type_data['prerequisites'].append({
        'id'    : int(attributes.get(attr_id, 0)),
        'name'  : req_type_response.data.get('name', "Unknown Skill"),
        'level' : int(attributes.get(level_id, 0)),
      })

    group_data['skills'].append(type_data)
    sleep(0.1)

  skill_list.append(group_data)

json_str = json.dumps(skill_list) + "\n"
json_bytes = json_str.encode('utf-8')

with gzip.GzipFile(jsonfilename, 'w') as fout:
  fout.write(json_bytes)
# pp.pprint(skill_list)
# print(skill_list)
