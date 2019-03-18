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

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Login_AllocSPOC'), [('AllocSPOCID') : findTestData('credentialDetails/Credentials_IDPwd').getValue(
            'AllocationSPOCID', 1), ('AllocSPOCPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('AllocationSPOCPassword', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/AddComment_Icon'), 5)

WebUI.click(findTestObject('OMVA_Summary_Page/AddComment_Icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Add_EditCommentDone_btn'), 5)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/Add_EditCommentDone_btn'), 5)

WebUI.delay(7)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Add_Comment_Window'), 20)

WebUI.sendKeys(findTestObject('OMVA_Summary_Page/Add_Comment_Window'), 'TEST')

WebUI.click(findTestObject('OMVA_Summary_Page/Add_EditCommentDone_btn'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Comment_ToastHeader'), 5)

AddCommentToast = WebUI.getText(findTestObject('OMVA_Summary_Page/Comment_ToastHeader'))

WebUI.closeBrowser()

