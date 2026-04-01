import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import groovy.json.JsonSlurper

GlobalVariable.API_KEY = System.getenv("API_KEY")

def requestUrl = "${GlobalVariable.BASE_URL}/data/2.5/forecast?lat=${GlobalVariable.LAT}&lon=${GlobalVariable.LON}&appid=${GlobalVariable.API_KEY}&units=metric"

RequestObject request = new RequestObject('Get5DayForecast')
request.setRestUrl(requestUrl)
request.setRestRequestMethod('GET')

def response = WS.sendRequest(request)

WS.verifyResponseStatusCode(response, 200)
assert response.getResponseTime() < 10000 : "Response too slow"
WS.verifyElementPropertyValue(response, 'cod', '200')

def json = new JsonSlurper().parseText(response.getResponseText())

assert json.coord.lat == GlobalVariable.LAT
assert json.coord.lon == GlobalVariable.LON

assert json.list.size() > 0 : "Forecast list is empty"
json.list.each { item ->
    assert item.dt != null : "Missing timestamp"
    assert item.main.temp != null : "Missing temperature"
    assert item.weather != null && item.weather.size() > 0 : "Missing weather description"
}