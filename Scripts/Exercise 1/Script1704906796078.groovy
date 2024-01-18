import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

'create unique first name'
def firstName =  CustomKeywords.'commonKeyWords.generateRandomKey'(6)
'create unique last name'
def lastName = CustomKeywords.'commonKeyWords.generateRandomKey'(9)

'send POST request create Booking with unique first name and last name'
ResponseObject responseCreate = WS.sendRequest(findTestObject('Object Repository/POST Create booking', [('firstName') : firstName, ('lastName') : lastName]))

'Verify the status code'
WS.verifyResponseStatusCode(responseCreate, 200)

def jsonSlurperCreateBooking = new JsonSlurper()

def jsonResponseCreateBooking = jsonSlurperCreateBooking.parseText(responseCreate.getResponseText())

'Verify the response body'
println jsonResponseCreateBooking


'Send a request to search for the booking by first name and last name.'
ResponseObject responseGetBooking = WS.sendRequest(findTestObject('Object Repository/GET Booking Ids', [('firstName') : firstName, ('lastName') : lastName]))

'Verify the status code of search booking by unique first name and last name'
WS.verifyResponseStatusCode(responseGetBooking, 200)

'Verify number of the response body contains only one booking ID'
WS.verifyElementsCount(responseGetBooking, 'bookingid', 1)

def jsonSlurperGetBooking = new JsonSlurper()

def jsonResponseGetBooking = jsonSlurperGetBooking.parseText(responseGetBooking.getResponseText())

def bookingID = jsonResponseGetBooking[0].bookingid

'Verify that the booking ID is correct'
WS.verifyElementPropertyValue(responseCreate, 'bookingid', bookingID)



