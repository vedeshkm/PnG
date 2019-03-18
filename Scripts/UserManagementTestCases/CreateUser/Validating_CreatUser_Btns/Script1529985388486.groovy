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

WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('OMVA_UserManagement_Page/SaveandExit_Button'))

WebUI.verifyElementNotClickable(findTestObject('OMVA_UserManagement_Page/Next_Button'))

WebUI.verifyElementClickable(findTestObject('OMVA_UserManagement_Page/Cancel_Button'))

WebUI.waitForElementClickable(findTestObject('OMVA_UserManagement_Page/Cancel_Button'), 5)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Cancel_Button'))

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Cancel_Button_Popup_HText'), 5)

WebUI.verifyElementText(findTestObject('OMVA_UserManagement_Page/Cancel_Button_Popup_HText'), 'Discard changes?')

WebUI.verifyElementText(findTestObject('OMVA_UserManagement_Page/Cancel_Button_Popup_CText'), 'You will lose any unsaved data on closing this section. Are you sure you want to discard the changes?')

not_run: ActHeaderTxt = WebUI.getText(findTestObject('OMVA_UserManagement_Page/Cancel_Button_Popup_HText'))

not_run: ActContentTxt = WebUI.getText(findTestObject('OMVA_UserManagement_Page/Cancel_Button_Popup_CText'))

not_run: WebUI.verifyMatch(ActHeaderTxt, ExpHeaderTxt, false)

not_run: WebUI.verifyMatch(ActContentTxt, ExpContentTxt, false)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Cancel_Button_Popup_OkButton'))

WebUI.callTestCase(findTestCase('CommonTestcases/Logout_Closebrowser'), [:], FailureHandling.STOP_ON_FAILURE)

