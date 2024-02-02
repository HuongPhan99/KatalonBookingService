import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

'send POST request to create a booking'
ResponseObject responseCreate = WS.sendRequest(findTestObject('Object Repository/POST Create booking', [('firstName') : "Lan", ('lastName') : "Phan"]), FailureHandling.STOP_ON_FAILURE)

'Verify the status code'
WS.verifyResponseStatusCode(responseCreate, 200, FailureHandling.STOP_ON_FAILURE)

def jsonSlurperCreateBooking = new JsonSlurper()
def jsonResponseCreateBooking = jsonSlurperCreateBooking.parseText(responseCreate.getResponseText())

'Store the booking ID.'
def bookingID =  jsonResponseCreateBooking.bookingid

def newFirstName = "Lan01"
def newLastName = "Phan01"

'send PATCH request to update the created booking.'
ResponseObject responseUpdate = WS.sendRequestAndVerify(findTestObject('Object Repository/PATCH Update booking with Authorization', [('id') : bookingID, ('firstName') : newFirstName, ('lastName') : newLastName]), FailureHandling.STOP_ON_FAILURE)

'Verify the status code'
WS.verifyResponseStatusCode(responseUpdate, 200, FailureHandling.STOP_ON_FAILURE)

def jsonSlurperUpdateBooking = new JsonSlurper()
def jsonResponseUpdateBooking = jsonSlurperUpdateBooking.parseText(responseUpdate.getResponseText())

'Verify that the response body contains the correct updated information.'
WS.verifyEqual(jsonResponseUpdateBooking.firstname, newFirstName, FailureHandling.CONTINUE_ON_FAILURE)
WS.verifyEqual(jsonResponseUpdateBooking.lastname, newLastName, FailureHandling.CONTINUE_ON_FAILURE)
println jsonResponseUpdateBooking

'create schema'
def schema = """
{
	"\$id": "https://example.com/person.schema.json",
  "\$schema": "https://json-schema.org/draft/2020-12/schema",
  "type": "object",
  "properties": {
    "firstname": {
      "type": "string"
    },
    "lastname": {
      "type": "string"
    },
    "totalprice": {
      "type": "integer"
    },
    "depositpaid": {
      "type": "boolean"
    },
    "bookingdates": {
      "type": "object",
      "properties": {
        "checkin": {
          "type": "string"
        },
        "checkout": {
          "type": "string"
        }
      },
      "required": [
        "checkin",
        "checkout"
      ]
    },
    "additionalneeds": {
      "type": "string"
    }
  },
  "required": [
    "firstname",
    "lastname",
    "totalprice",
    "depositpaid",
    "bookingdates",
    "additionalneeds"
  ]
}
"""

'Verify the schema of the response body.'
WS.validateJsonAgainstSchema(responseUpdate,schema)


'send DELETE request to delete the booking'
ResponseObject responseDelete = WS.sendRequestAndVerify(findTestObject('Object Repository/DELETE Delete booking', [('id') : bookingID]), FailureHandling.STOP_ON_FAILURE)

'Verify the status code'
WS.verifyResponseStatusCode(responseDelete, 201, FailureHandling.CONTINUE_ON_FAILURE)

'Verify the response body'
WS.containsString(responseDelete, 'Created', true, FailureHandling.CONTINUE_ON_FAILURE)


'Use a GET request to verify if the booking has been successfully deleted'
ResponseObject responseGetBookingId = WS.sendRequest(findTestObject('Object Repository/Get Booking', [('id') : bookingID]), FailureHandling.STOP_ON_FAILURE)

'Verify the status code'
WS.verifyResponseStatusCode(responseGetBookingId, 404, FailureHandling.CONTINUE_ON_FAILURE)

'Verify the reponse body'
println WS.containsString(responseGetBookingId, 'Not Found', true)
