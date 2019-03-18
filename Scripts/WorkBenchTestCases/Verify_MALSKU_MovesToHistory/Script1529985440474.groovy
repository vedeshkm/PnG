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

WebUI.callTestCase(findTestCase('UserManagementTestCases/Login/Login_ChannelMSP'), [('ChannelMSPID') : findTestData('credentialDetails/Credentials_IDPwd').getValue('ChannelMSPID', 1)
        , ('ChannelMSPPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('ChannelMSPPassword', 1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.click(findTestObject('OMVA_Summary_Page/Select_puregold'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'), 0)

SKUID = WebUI.getText(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'))

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/DONE_Btn'), 5)

WebUI.scrollToElement(findTestObject('OMVA_Workbench_Page/DONE_Btn'), 5)

WebUI.click(findTestObject('OMVA_Workbench_Page/DONE_Btn'))

CustomKeywords.'applicationLibrary.ClicksOn1stBatchof_SKUID_andgetsBatchNo.ClickOnSKUInprogressBatch'(SKUID)

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/Notify_Btn'), 5)

WebUI.click(findTestObject('OMVA_Workbench_Page/Notify_Btn'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/ActionTaken_HeaderTxt'), 10)

ActionTakenHTxt = WebUI.getText(findTestObject('OMVA_Workbench_Page/ActionTaken_HeaderTxt'))

ActionTakenCTxt = WebUI.getText(findTestObject('OMVA_Workbench_Page/ActionTaken_ContenetTxt'))

WebUI.verifyMatch(ActionTakenHTxt, findTestData('credentialDetails/PopupStrings').getValue('ActionTakenHTxt', 1), true)

WebUI.click(findTestObject('OMVA_Workbench_Page/ActionTaken_CrossBtn'))

WebUI.verifyMatch(ActionTakenCTxt, findTestData('credentialDetails/PopupStrings').getValue('ActionTakenCTxt', 1), true)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/History_Logo'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/History_Logo'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Customer_dropdown'), 5)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Select_puregold'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Select_puregold'))

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('OMVA_Landing_Page/Search_icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Search_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Type_Here'), 0)

WebUI.sendKeys(findTestObject('OMVA_Landing_Page/Type_Here'), SKUID)

WebUI.delay(3)

searchedsku = WebUI.getText(findTestObject('OMVA_Workbench_Page/1st_SKUMaterial'))

not_run: CustomKeywords.'applicationLibrary.Checks_SelectedBatchIsDisplayedInHistory.ChecksBatchIsDisplayedInHistory'(SelectedBatch)

WebUI.verifyMatch(searchedsku, SKUID, false)

WebUI.closeBrowser()

