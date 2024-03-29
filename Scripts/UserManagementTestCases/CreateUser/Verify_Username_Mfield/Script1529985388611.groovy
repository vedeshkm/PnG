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

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Valid_Login '), [('superadminID') : findTestData('Credentials_IDPwd').getValue(
            'SuperAdminID', 1), ('superadminPwd') : findTestData('Credentials_IDPwd').getValue('SuperAdminPassword', 1)], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/CreateUser_Button'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/CreateUser_Button'))

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'), 10)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'))

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'), 0)

WebUI.click(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'))

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/UserName_Textbox'), userName)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/EmailID_Textbox'), emailID)

ActualUsernameErrormsg = WebUI.getText(findTestObject('OMVA_UserManagement_Page/Username_Error_Msg'))

WebUI.verifyMatch(ActualUsernameErrormsg, findTestData('CreateUser').getValue('MendatoryMsge', 3), true)

WebUI.closeBrowser()

