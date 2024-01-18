import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper
import internal.GlobalVariable

'Send a POST request to generate a token'
ResponseObject response = WS.sendRequest(findTestObject('Object Repository/POST Create token'))

def jsonSlurper = new JsonSlurper()
def responseBody =  jsonSlurper.parseText(response.getResponseBodyContent())
'Store the obtained token.'
GlobalVariable.token = responseBody.token


'send POST request to create a booking'
ResponseObject responseCreate = WS.sendRequest(findTestObject('Object Repository/POST Create booking', [('firstName') : "Huong", ('lastName') : "Phan"]))

'Verify the status code'
WS.verifyResponseStatusCode(responseCreate, 200)

def jsonSlurperCreateBooking = new JsonSlurper()
def jsonResponseCreateBooking = jsonSlurperCreateBooking.parseText(responseCreate.getResponseText())

'Store the booking ID.'
def bookingID =  jsonResponseCreateBooking.bookingid
println bookingID
'send PUT request to update the created booking.'
ResponseObject responseUpdate = WS.sendRequestAndVerify(findTestObject('Object Repository/PUT Update booking', [('id') : bookingID]))
'Verify the status code'
//println WS.verifyResponseStatusCode(responseUpdate, 200)

