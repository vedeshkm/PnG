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
            'CategoryMSPID', 1), ('ChannelMSPPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('CategoryMSPPassword', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(8)

WebUI.waitForElementVisible(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'), 5)

WebUI.click(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'))

WebUI.scrollToElement(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'), 5)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'), 6)

WebUI.click(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'))

WebUI.waitForElementNotVisible(findTestObject('OMVA_Landing_Page/pinBtn_AddSubtractions'), 5, FailureHandling.STOP_ON_FAILURE)

