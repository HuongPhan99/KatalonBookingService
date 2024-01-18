import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

'send POST request to create  multiple bookings using data driven'
ResponseObject responseCreate = WS.sendRequest(findTestObject('Object Repository/POST Create booking', [('firstName') : "${firstName}", ('lastName') : "${lastName}"]))

'Verify the status code'
WS.verifyResponseStatusCode(responseCreate, 200)
'Verify that the response body contains the correct information as specified in the data file'
WS.verifyElementPropertyValue(responseCreate, 'booking.firstname', "${firstName}")
WS.verifyElementPropertyValue(responseCreate, 'booking.lastname', "${lastName}")


def jsonSlurperCreateBooking = new JsonSlurper()

def jsonResponseCreateBooking = jsonSlurperCreateBooking.parseText(responseCreate.getResponseText())
def bookingID =  jsonResponseCreateBooking.bookingid
'Utilize the booking ID from the POST response body to perform a GET request for the booking'
ResponseObject responseGetBookingId = WS.sendRequest(findTestObject('Object Repository/Get Booking', [('id') : bookingID]))

'Verify the status code'
WS.verifyResponseStatusCode(responseGetBookingId, 200)

def jsonSlurperGetBooking = new JsonSlurper()

def jsonResponseGetBooking = jsonSlurperGetBooking.parseText(responseGetBookingId.getResponseText())

'Verify that the response body contains the correct information as specified in the data file'
WS.verifyEqual(jsonResponseGetBooking.firstname, "${firstName}")
WS.verifyEqual(jsonResponseGetBooking.lastname, "${lastName}")
