import gzip
import json

jsonfilename = "resources/eve_skills.json.gz"

with gzip.open(jsonfilename, 'rb') as f:
  skills_json = f.read()
parsed = json.loads(skills_json)
print(json.dumps(parsed, indent=4, sort_keys=True))
