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

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), InvalidID)

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

if (true) {
}

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

assert true

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), InvalidPassword)

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

AHeaderTxt = WebUI.getText(findTestObject('OMVA_Login_Page/InvalidLogin_HeaderTxt'))

WebUI.verifyMatch(AHeaderTxt, findTestData('credentialDetails/PopupStrings').getValue('InvalidLoginHeaderTxt', 1), true, 
    FailureHandling.STOP_ON_FAILURE)

AContentTxt = WebUI.getText(findTestObject('OMVA_Login_Page/InvalidLogin_ContentTxt'))

WebUI.verifyMatch(AContentTxt, findTestData('credentialDetails/PopupStrings').getValue('InvalidLoginContentTxt', 1), true, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/InvalidLogin_OKbtn'), 5)

assert true

WebUI.click(findTestObject('OMVA_Login_Page/InvalidLogin_OKbtn'))

WebUI.closeBrowser()

