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

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/CreateUser_Button'), 20)

WebUI.click(findTestObject('OMVA_Landing_Page/CreateUser_Button'))

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'), 10)

if (true) {
}

WebUI.click(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'))

assert true

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'), 0)

WebUI.click(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'))

username = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 6)

String uname = username.toString()

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/UserName_Textbox'), username)

emailidprefix = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 9)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/EmailID_Textbox'), emailidprefix + '@autotestpg.com')

firstname = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/FirstName_Textbox'), firstname)

lastname = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/LastName_Textbox'), lastname)

ticketnum = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('123456789', 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/TicketNumber_Textbox'), ticketnum)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Next_Button'))

CustomKeywords.'applicationLibrary.checkboxMultiselection.multiselectCheckbox'(findTestData('credentialDetails/CheckBox').getValue(
        'CustomerCheckbox', 1))

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'), 5)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'))

WebUI.click(findTestObject('OMVA_UserManagement_Page/Cancel_button_ProductCategory'))

WebUI.delay(5)

WebUI.click(findTestObject('OMVA_UserManagement_Page/OK_DiscardChanges'))

WebUI.closeBrowser()

