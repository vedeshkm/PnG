import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert as Assert
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('CommonTestcases/OpenBrowserandNavigateToQAURL'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), findTestData('credentialDetails/Credentials_IDPwd').getValue(
        'SuperAdminID', 1))

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), findTestData('credentialDetails/Credentials_IDPwd').getValue(
        'SuperAdminPassword', 1))

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(4)

if (true) {
}

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/CreateUser_Button'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/CreateUser_Button'))

assert true

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'), 10)

WebUI.delay(3)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'))

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'), 0)

WebUI.click(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'))

username = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 6)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/UserName_Textbox'), username)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/EmailID_Textbox'), emailID)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/FirstName_Textbox'), firstName)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/LastName_Textbox'), lastName)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/TicketNumber_Textbox'), ticketNumber)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Next_Button'))

ActualToastMessage = WebUI.getText(findTestObject('OMVA_UserManagement_Page/EmailID_ToastMsg'))

WebUI.verifyMatch(ActualToastMessage, findTestData('credentialDetails/CreateUser').getValue('ExpUNToast', 2), true)

WebUI.closeBrowser()

