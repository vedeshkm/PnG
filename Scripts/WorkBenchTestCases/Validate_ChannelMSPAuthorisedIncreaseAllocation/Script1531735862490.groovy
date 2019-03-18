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

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Login_ChannelMSP'), [('ChannelMSPID') : findTestData('credentialDetails/Credentials_IDPwd').getValue(
            'ChannelMSPID', 1), ('ChannelMSPPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('ChannelMSPPassword', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Search_button'), 7)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Search_button'))

WebUI.waitForElementVisible(findTestObject('OMVA_UserManagement_Page/Enter_Text_Search'), 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/Enter_Text_Search'), findTestData('credentialDetails/CreateUser').getValue(
        'skuId', 1))

WebUI.waitForElementVisible(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'), 5)

WebUI.click(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'))

WebUI.waitForElementVisible(findTestObject('OMVA_Summary_Page/SummaryText'), 5)

WebUI.delay(4)

WebUI.scrollToElement(findTestObject('OMVA_Landing_Page/OMVA_Recommendation'), 5)

WebUI.waitForElementNotPresent(findTestObject('OMVA_Landing_Page/IncreaseAllocation_Summary'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('CommonTestcases/Logout_Closebrowser'), [:], FailureHandling.STOP_ON_FAILURE)

