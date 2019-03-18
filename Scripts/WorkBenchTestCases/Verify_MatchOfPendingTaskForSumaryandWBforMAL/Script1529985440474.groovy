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

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Login_MAL'), [('MALID') : findTestData('credentialDetails/Credentials_IDPwd').getValue(
            'MALID', 1), ('MALPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('MALPassword', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

MAL_WB_Count = CustomKeywords.'applicationLibrary.GetsPendingTaskCount_WBScreen.Get_PendingTask_Count_WBscreen'()

WebUI.click(findTestObject('OMVA_Landing_Page/Summary_Logo'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Customer_dropdown'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Select_puregold'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Select_puregold'))

WebUI.delay(5)

MAL_S_Count = CustomKeywords.'applicationLibrary.GetsPendingTaskCount_MALSummaryScreen.Get_MALPendingTask_Count_Summaryscreen'()

WebUI.verifyEqual(MAL_WB_Count, MAL_S_Count)

WebUI.callTestCase(findTestCase('CommonTestcases/Logout_Closebrowser'), [:], FailureHandling.STOP_ON_FAILURE)

