import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.Keys as Keys
import org.testng.Assert as Assert
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
//import customKeywords.SKUID_InProgress as SKUID_InProgress
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Login_AllocSPOC'), [('AllocSPOCID') : findTestData('credentialDetails/Credentials_IDPwd').getValue(
            'AllocationSPOCID', 1), ('AllocSPOCPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('AllocationSPOCPassword', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Customer_dropdown'), 5)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Select_puregold'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Select_puregold'))

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Search_icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Search_icon'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Type_Here'), 5)

WebUI.sendKeys(findTestObject('OMVA_Landing_Page/Type_Here'), SKUID_Inprogress)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/SKUID_Completed'), 10)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/TakeAction_Icon'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/TakeAction_Icon'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Search_icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Search_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Type_Here'), 5)

WebUI.sendKeys(findTestObject('OMVA_Landing_Page/Type_Here'), SKUID_Inprogress)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/SKUID_OkToRefresh'), 10)

WebUI.closeBrowser()

