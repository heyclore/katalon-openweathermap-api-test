import internal.GlobalVariable as GlobalVariable

GlobalVariable.API_KEY = System.getenv("API_KEY")

assert GlobalVariable.API_KEY != null && GlobalVariable.API_KEY.trim() != '' : "API_KEY is not set in environment"
assert GlobalVariable.BASE_URL != null && GlobalVariable.BASE_URL.trim() != '' : "BASE_URL is not set in profile"
assert GlobalVariable.LAT != null : "LAT is not set in profile"
assert GlobalVariable.LON != null : "LON is not set in profile"
