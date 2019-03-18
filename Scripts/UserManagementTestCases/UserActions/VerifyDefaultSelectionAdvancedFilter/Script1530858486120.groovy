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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('CommonTestcases/OpenBrowserandNavigateToQAURL'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), findTestData('credentialDetails/Credentials_IDPwd').getValue(
        'SuperAdminID', 1))

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), findTestData('credentialDetails/Credentials_IDPwd').getValue(
        'SuperAdminPassword', 1))

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForAngularLoad(10)

WebUI.delay(4)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Filter_Icon'), 5)

assert true

WebUI.click(findTestObject('OMVA_Landing_Page/Filter_Icon'))

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Advanced_FilterPopUp'), 5)

assert true

WebUI.delay(3)

CustomKeywords.'applicationLibrary.checkboxMultiselection.checkbox'(findTestData('credentialDetails/CheckBox').getValue(
        'Role', 1))

WebUI.waitForElementVisible(findTestObject('OMVA_AdvancedFilter_Page/resetButton'), 3)

WebUI.click(findTestObject('OMVA_AdvancedFilter_Page/resetButton'))

WebUI.verifyElementAttributeValue(findTestObject('OMVA_AdvancedFilter_Page/checkboxSelectAll'), 'ng-reflect-model', 'false', 
    3, FailureHandling.STOP_ON_FAILURE)