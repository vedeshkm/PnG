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

WebUI.callTestCase(findTestCase('null'), [('ValidID') : findTestData('credentialDetails/Credentials_IDPwd').getValue(
            'MALID', 1), ('ValidPwd') : findTestData('credentialDetails/Credentials_IDPwd').getValue('MALPassword', 1)], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Summary_Logo'), 5)

WebUI.delay(3)

WebUI.click(findTestObject('OMVA_Landing_Page/Summary_Logo'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Customer_dropdown'), 5)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Select_puregold'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Select_puregold'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Status_filter'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Status_filter'))

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/InProgressTaskID'), 5)

SKUID_Inprogress = WebUI.getText(findTestObject('OMVA_Summary_Page/InProgressTaskID'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Workbench_Logo'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Workbench_Logo'))

CustomKeywords.'customKeywords.ClicksOnMatierial_with_givenSKUID.ClickOnSKUInprogress'(SKUID_Inprogress)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/DONE_Btn'), 5)

WebUI.scrollToElement(findTestObject('OMVA_Workbench_Page/DONE_Btn'), 5)

WebUI.click(findTestObject('OMVA_Workbench_Page/DONE_Btn'))

CustomKeywords.'customKeywords.ClicksOn1stBatchof_SKUID_andgetsBatchNo.ClickOnSKUInprogressBatch'(SKUID_Inprogress)

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/Notify_Btn'), 5)

WebUI.click(findTestObject('OMVA_Workbench_Page/Notify_Btn'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Workbench_Page/ActionTaken_HeaderTxt'), 10)

ActionTakenHTxt = WebUI.getText(findTestObject('OMVA_Workbench_Page/ActionTaken_HeaderTxt'))

WebUI.verifyMatch(ActionTakenHTxt, findTestData('PopupStrings').getValue('ActionTakenHTxt', 1), true)

ActionTakenCTxt = WebUI.getText(findTestObject('OMVA_Workbench_Page/ActionTaken_ContenetTxt'))

WebUI.verifyMatch(ActionTakenCTxt, findTestData('PopupStrings').getValue('ActionTakenCTxt', 1), true)

WebUI.click(findTestObject('OMVA_Workbench_Page/ActionTaken_CrossBtn'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Summary_Logo'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Summary_Logo'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Customer_dropdown'), 5)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('null'), 10)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Search_icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Search_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Type_Here'), 5)

WebUI.sendKeys(findTestObject('OMVA_Landing_Page/Type_Here'), SKUID_Inprogress)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/SKUID_Completed'), 5)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('null'), [('ValidID') : findTestData('Credentials_IDPwd').getValue(
            'AllocationSPOCID', 1), ('ValidPwd') : findTestData('Credentials_IDPwd').getValue('AllocationSPOCPassword', 
            1)], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Customer_dropdown'), 5)

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Summary_Page/Select_puregold'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/Select_puregold'))

WebUI.click(findTestObject('OMVA_Summary_Page/Customer_dropdown'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Search_icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Search_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Type_Here'), 5)

WebUI.sendKeys(findTestObject('OMVA_Landing_Page/Type_Here'), SKUID_Inprogress)

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/SKUID_Completed'), 10)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/TakeAction_Icon'), 10)

WebUI.click(findTestObject('OMVA_Summary_Page/TakeAction_Icon'))

WebUI.delay(7)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Search_icon'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Search_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Type_Here'), 5)

WebUI.sendKeys(findTestObject('OMVA_Landing_Page/Type_Here'), SKUID_Inprogress)

WebUI.verifyElementPresent(findTestObject('OMVA_Summary_Page/SKUID_OkToRefresh'), 10)

