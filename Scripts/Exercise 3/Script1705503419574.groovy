import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WS.callTestCase(findTestCase('Create token'), [:], FailureHandling.STOP_ON_FAILURE)

'send POST request to create a booking'
ResponseObject responseCreate = WS.sendRequest(findTestObject('Object Repository/POST Create booking', [('firstName') : 'Huong', ('lastName') : 'Phan']), FailureHandling.STOP_ON_FAILURE)

'Verify the status code'
WS.verifyResponseStatusCode(responseCreate, 200, FailureHandling.STOP_ON_FAILURE)

def jsonSlurperCreateBooking = new JsonSlurper()

def jsonResponseCreateBooking = jsonSlurperCreateBooking.parseText(responseCreate.getResponseText())

'Store the booking ID.'
def bookingID = jsonResponseCreateBooking.bookingid

def newFirstName = 'Huong01'

def newLastName = 'Phan01'

'send PUT request to update the created booking.'
ResponseObject responseUpdate = WS.sendRequestAndVerify(findTestObject('Object Repository/PUT Update booking', [('id') : bookingID
            , ('firstName') : newFirstName, ('lastName') : newLastName]), FailureHandling.STOP_ON_FAILURE)

'Verify the status code'
WS.verifyResponseStatusCode(responseUpdate, 200)

def jsonSlurperUpdateBooking = new JsonSlurper()

def jsonResponseUpdateBooking = jsonSlurperUpdateBooking.parseText(responseUpdate.getResponseText())

'Verify that the response body contains the correct updated information.'
WS.verifyEqual(jsonResponseUpdateBooking.firstname, newFirstName)

WS.verifyEqual(jsonResponseUpdateBooking.lastname, newLastName)



