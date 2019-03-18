import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Valid_Login '), [('superadminID') : findTestData('credentialDetails/Credentials_IDPwd').getValue(
            'SuperAdminID', 1), ('superadminPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('SuperAdminPassword', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/CreateUser_Button'), 15)

WebUI.click(findTestObject('OMVA_Landing_Page/CreateUser_Button'))

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'), 10)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'))

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'), 0)

WebUI.click(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'))

username = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('', 0)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/UserName_Textbox'), username)

emailidprefix = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('', 0)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/EmailID_Textbox'), emailidprefix + '@autotestpg.com')

firstname = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('', 0)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/FirstName_Textbox'), firstname)

lastname = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('', 0)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/LastName_Textbox'), lastname)

ticketnum = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('', 0)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/TicketNumber_Textbox'), ticketnum)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Next_Button'))

CustomKeywords.'applicationLibrary.checkboxMultiselection.multiselectCheckbox'(findTestData('CheckBox').getValue('CustomerCheckbox', 
        1))

WebUI.click(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'))

CustomKeywords.'applicationLibrary.checkboxMultiselection.multiselectCheckbox'(findTestData('CheckBox').getValue('ProductCheckBox', 
        1))

WebUI.click(findTestObject('OMVA_UserManagement_Page/UserCreation_Save_Btn'))

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/UserCreation_HeaderTxt'), 10)

WebUI.verifyElementText(findTestObject('OMVA_UserManagement_Page/UserCreation_HeaderTxt'), findTestData('CheckBox').getValue(
        'MendatoryMsge', 1))

WebUI.verifyElementText(findTestObject('OMVA_UserManagement_Page/UserCreation_ContentTxt'), 'User has successfully been created. Details of account created will be shared with the user over email.')

WebUI.click(findTestObject('OMVA_UserManagement_Page/UserCreation_OK_Btn'))

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Created_User_Username'), 15)

createduser = WebUI.getText(findTestObject('OMVA_UserManagement_Page/Created_User_Username'))

WebUI.verifyMatch(createduser, (firstname + ' ') + lastname, true)

WebUI.callTestCase(findTestCase('CommonTestcases/Logout_Closebrowser'), [:], FailureHandling.STOP_ON_FAILURE)

