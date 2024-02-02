import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

'Send a POST request to generate a token'
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/POST Create token'), FailureHandling.STOP_ON_FAILURE)

def jsonSlurper = new JsonSlurper()
def responseBody =  jsonSlurper.parseText(response.getResponseBodyContent())
'Store the obtained token.'
GlobalVariable.token = "token=" + responseBody.token
