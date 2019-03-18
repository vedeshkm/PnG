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

WebUI.callTestCase(findTestCase('CommonTestcases/OpenBrowserandNavigateToQAURL'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), LockUserID)

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), InvalidPassword)

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/LockedLogin_HeaderTxt'), 10)

AHeaderTxt = WebUI.getText(findTestObject('OMVA_Login_Page/LockedLogin_HeaderTxt'))

WebUI.verifyMatch(AHeaderTxt, findTestData('PopupStrings').getValue('LockedLoginHeaderTxt', 1), true, FailureHandling.STOP_ON_FAILURE)

AContentTxt = WebUI.getText(findTestObject('OMVA_Login_Page/LockedLogin_ContentTxt'))

WebUI.verifyMatch(AContentTxt, findTestData('PopupStrings').getValue('LockedLoginContentTxt', 1), true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/InvalidLogin_OKbtn'), 10)

WebUI.click(findTestObject('OMVA_Login_Page/InvalidLogin_OKbtn'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.clearText(findTestObject('OMVA_Login_Page/Username_Textbox'))

WebUI.clearText(findTestObject('OMVA_Login_Page/Password_Textbox'))

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), ValidID)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), ValidPwd)

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForAngularLoad(10)

greetingtext = WebUI.getText(findTestObject('OMVA_Landing_Page/Greeting_Label'))

WebUI.verifyMatch(greetingtext, '\\D*' + ValidID, true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Locked_Icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Locked_Icon'))

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/UnlockUserPopup_HeaderTxt'), 5)

AHeaderTxt = WebUI.getText(findTestObject('OMVA_Landing_Page/UnlockUserPopup_HeaderTxt'))

WebUI.verifyMatch(AHeaderTxt, findTestData('PopupStrings').getValue('UnlockUserHeaderTxt', 1), true, FailureHandling.STOP_ON_FAILURE)

AContentTxt = WebUI.getText(findTestObject('OMVA_Landing_Page/UnlockUserPopup_ContentTxt'))

WebUI.verifyMatch(AContentTxt, findTestData('PopupStrings').getValue('UnlockUserContentTxt', 1) + '\\D*', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OMVA_Landing_Page/UnlockUserPopup_OKBtn'))

UnlockToastMsg = WebUI.getText(findTestObject('OMVA_Landing_Page/Unlock_ToastMsg'))

WebUI.verifyMatch(UnlockToastMsg, findTestData('PopupStrings').getValue('UnlockUserToastMsg', 1), true, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('OMVA_Landing_Page/CloseToastMsgBtn'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/User_icon'), 20)

WebUI.click(findTestObject('OMVA_Landing_Page/User_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Logout_link'), 10)

WebUI.click(findTestObject('OMVA_Landing_Page/Logout_link'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), LockUserID)

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), LockUserPwd)

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForAngularLoad(10)

greetingtext = WebUI.getText(findTestObject('OMVA_Landing_Page/Greeting_Label'))

WebUI.verifyMatch(greetingtext, '\\D*' + LockUserID, true, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CommonTestcases/Logout_Closebrowser'), [:], FailureHandling.STOP_ON_FAILURE)

