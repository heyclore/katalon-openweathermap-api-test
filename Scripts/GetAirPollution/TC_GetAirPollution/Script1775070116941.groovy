import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import groovy.json.JsonSlurper

GlobalVariable.API_KEY = System.getenv("API_KEY")

def requestUrl = "${GlobalVariable.BASE_URL}/data/2.5/air_pollution?lat=${GlobalVariable.LAT}&lon=${GlobalVariable.LON}&appid=${GlobalVariable.API_KEY}"

RequestObject request = new RequestObject('GetAirPollution')
request.setRestUrl(requestUrl)
request.setRestRequestMethod('GET')

def response = WS.sendRequest(request)

WS.verifyResponseStatusCode(response, 200)
assert response.getResponseTime() < 10000 : "Response too slow"
WS.verifyElementPropertyValue(response, 'cod', null)

def json = new JsonSlurper().parseText(response.getResponseText())

assert json.coord.lat == GlobalVariable.LAT
assert json.coord.lon == GlobalVariable.LON

assert json.list.size() > 0 : "Air pollution data list is empty"
json.list.each { item ->
    assert item.main != null : "Missing 'main' air quality data"
    assert item.main.aqi != null : "Missing AQI value"
    assert item.components != null : "Missing pollution components"
 }