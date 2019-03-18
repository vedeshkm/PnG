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

WebUI.callTestCase(findTestCase('UserManagementTestCases/CreateUser/Create_User_Validate'), [('username') : '', ('emailidprefix') : ''
        , ('firstname') : '', ('lastname') : '', ('ticketnum') : '', ('createduser') : ''], FailureHandling.STOP_ON_FAILURE)

CreatedUsername = WebUI.getText(findTestObject('OMVA_UserManagement_Page/Created_User_Username'))

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/CreatedUser_EditBtn'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/CreatedUser_EditBtn'))

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'), 10)

WebUI.delay(3)

WebUI.click(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_EditUser_Page/SaveExit_Btn'), 5)

WebUI.click(findTestObject('OMVA_EditUser_Page/SaveExit_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_EditUser_Page/DeactivateUser_HeaderTxt'), 5)

AHeaderTxt = WebUI.getText(findTestObject('OMVA_EditUser_Page/DeactivateUser_HeaderTxt'))

WebUI.verifyMatch(AHeaderTxt, findTestData('credentialDetails/PopupStrings').getValue('DeactivateUserHeaderTxt', 1), true, 
    FailureHandling.STOP_ON_FAILURE)

AContentTxt = WebUI.getText(findTestObject('OMVA_EditUser_Page/DeactivateUser_ContentText'))

WebUI.verifyMatch(AContentTxt, 'Are you sure you want to deactivate ' + (CreatedUsername + ('\'s account' + '\\D*')), true, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OMVA_EditUser_Page/DeactivateUser_OKBtn'))

DeactivateToastMsg = WebUI.getText(findTestObject('OMVA_EditUser_Page/Deactivate_ToastMsg'))

WebUI.verifyMatch(DeactivateToastMsg, findTestData('credentialDetails/PopupStrings').getValue('DeactivateUserToastMsg', 
        1), true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/CretedUser_Status'), 20)

CreatedUserStatus = WebUI.getText(findTestObject('OMVA_Landing_Page/CretedUser_Status'))

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/CretedUser_Status'), 5)

WebUI.verifyMatch(CreatedUserStatus, 'Inactive', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/CreatedUser_EditBtn'), 15)

WebUI.click(findTestObject('OMVA_Landing_Page/CreatedUser_EditBtn'))

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'), 20)

WebUI.click(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_EditUser_Page/EditUserNext_Btn'), 10)

WebUI.click(findTestObject('OMVA_EditUser_Page/EditUserNext_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_EditUser_Page/DeactivateUser_HeaderTxt'), 10)

AHeaderTxt = WebUI.getText(findTestObject('OMVA_EditUser_Page/DeactivateUser_HeaderTxt'))

WebUI.verifyMatch(AHeaderTxt, findTestData('credentialDetails/PopupStrings').getValue('ActivateUserHeaderTxt', 1), true, 
    FailureHandling.CONTINUE_ON_FAILURE)

AContentTxt = WebUI.getText(findTestObject('OMVA_EditUser_Page/DeactivateUser_ContentText'))

WebUI.verifyMatch(AContentTxt, 'Are you sure you want to activate ' + (CreatedUsername + ('\'s account' + '\\D*')), true, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OMVA_EditUser_Page/DeactivateUser_OKBtn'))

ActivateToastMsg = WebUI.getText(findTestObject('OMVA_EditUser_Page/Activate_ToastMsg'))

WebUI.verifyMatch(ActivateToastMsg, findTestData('credentialDetails/PopupStrings').getValue('ActivateUserToastMsg', 1), 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/CretedUser_Status'), 20)

CreatedUserStatus = WebUI.getText(findTestObject('OMVA_Landing_Page/CretedUser_Status'))

WebUI.verifyMatch(CreatedUserStatus, 'Active', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'), 0)

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'), 15)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_UserManagement_Page/UserCreation_Save_Btn'), 10)

WebUI.click(findTestObject('OMVA_UserManagement_Page/UserCreation_Save_Btn'))

WebUI.waitForElementPresent(findTestObject('OMVA_EditUser_Page/ActivateUserOK_Btn'), 10)

WebUI.click(findTestObject('OMVA_EditUser_Page/ActivateUserOK_Btn'))

WebUI.closeBrowser()

