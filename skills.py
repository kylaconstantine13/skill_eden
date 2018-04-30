from esipy import App
from esipy import EsiClient
from time import sleep
import pprint

# Constants
SKILL_CATEGORY_ID = 16
# TRAINING_MULTIPLIER_ATTRIBUTE_ID = 275
# PRIMARY_ATTRIBUTE_ID = 180
# SECONDARY_ATTRIBUTE_ID = 181
# PRIMARY_SKILL_REQUIRED = 182
# SECONDARY_SKILL_REQUIRED = 183

# Our finalized data structure
skill_list = []

# Setup app and client
app = App.create(url="https://esi.tech.ccp.is/latest/swagger.json?datasource=tranquility")
client = EsiClient(
  retry_requests = True,
  header={'User-Agent': 'kylaconstantine13@gmail.com'},
  raw_body_only=False,
)

# Get skill groups
skill_groups_operation = app.op['universe_categories_category_id'](
  category_id = SKILL_CATEGORY_ID,
)
skill_group_response = client.request(skill_groups_operation)

pp = pprint.PrettyPrinter(indent=4)

# Get info for each group
groups = skill_group_response.data.groups
for group_id in groups[0:1]:
  group_operation = app.op['universe_groups_group_id'](
    group_id = group_id
  )
  group_response = client.request(group_operation)
  group_info = group_response.data
  group_data = {
    'category_id' : group_info.get('category_id', None),
    'name'        : group_info.get('name', None),
    'skills'      : [],
  }

  # Get the skill type info within each group
  types = group_info.types
  for type_id in types[0:1]:
    type_operation = app.op['universe_types_type_id'](
      type_id = type_id
    )
    type_response = client.request(type_operation)
    type_info = type_response.data

    # Want to keep the following data:
    # description, icon_id, market_group_id, name, type_id
    # attributes, effects
    type_data = {
      'type_id'          : type_info.get('type_id', None),
      'name'             : type_info.get('name', None),
      'description'      : type_info.get('description', None),
      'market_group_id'  : type_info.get('market_group_id', None),
      'icon_id'          : type_info.get('icon_id', None),
      'attributes'       : [],
      'effects'          : [],
    }

    # Get attribute info
    attributes = type_info.dogma_attributes
    for attribute in attributes:
      attribute_operation = app.op['dogma_attributes_attribute_id'](
        attribute_id = attribute.attribute_id
      )
      attribute_response = client.request(attribute_operation)
      attribute_info = attribute_response.data
      attribute_data = {
        'attribute_id' : attribute_info.get('attribute_id', None),
        'display_name' : attribute_info.get('display_name', None),
        'name'         : attribute_info.get('name', None),
        'description'  : attribute_info.get('description', None),
        'value'        : attribute.get('value', 0),
      }
      if attribute_data['name'] == "Primary attribute" or attribute_data['name'] == "Secondary attribute":
        attribute_operation = app.op['dogma_attributes_attribute_id'](
          attribute_id = attribute_data['value']
        )
        attribute_response = client.request(attribute_operation)
        attribute_info = attribute_response.data
        attribute_data['value'] = attribute_info.name

      type_data['attributes'].append(attribute_data)
      sleep(0.1)

    # Get effect info
    effects = type_info.dogma_effects
    for effect in effects:
      effect_operation = app.op['dogma_effects_effect_id'](
        effect_id = effect.effect_id
      )
      effect_response = client.request(effect_operation)
      effect_info = effect_response.data
      effect_data = {
        'effect_id'    : effect_info.get('effect_id', None),
        'display_name' : effect_info.get('display_name', None),
        'name'         : attribute_info.get('name', None),
        'description'  : effect_info.get('description', None),
        'is_default'   : effect.get('is_default', False),
      }
      type_data['attributes'].append(effect_data)
      sleep(0.1)


    group_data['skills'].append(type_data)
    sleep(0.1)

  # Want to keep the following data:
  # category_id, name
  skill_list.append(group_data)
  pp.pprint(group_data)

pp.pprint(skill_list)
