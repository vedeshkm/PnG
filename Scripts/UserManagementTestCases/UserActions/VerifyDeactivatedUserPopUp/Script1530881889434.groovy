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

WebUI.callTestCase(findTestCase('CommonTestcases/OpenBrowserandNavigateToQAURL'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), findTestData('credentialDetails/Credentials_IDPwd').getValue(
        'SuperAdminID', 1))

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), findTestData('credentialDetails/Credentials_IDPwd').getValue(
        'SuperAdminPassword', 1))

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/CreateUser_Button'), 20)

WebUI.click(findTestObject('OMVA_Landing_Page/CreateUser_Button'))

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'), 10)

if (true) {
}

WebUI.click(findTestObject('OMVA_UserManagement_Page/Role_Dropdown'))

assert true

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'), 0)

WebUI.click(findTestObject('OMVA_UserManagement_Page/DropdownOption_RoleDropdown_Market Admin'))

username = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 6)

String username = username.toString()

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/UserName_Textbox'), username)

emailidprefix = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 9)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/EmailID_Textbox'), emailidprefix + '@autotestpg.com')

firstname = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/FirstName_Textbox'), firstname)

lastname = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('abcdefghijklmnopqrstuvwxyz', 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/LastName_Textbox'), lastname)

ticketnum = CustomKeywords.'commonLibrary.commonFunctions.randomStringFunction'('123456789', 7)

WebUI.sendKeys(findTestObject('OMVA_UserManagement_Page/TicketNumber_Textbox'), ticketnum)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Next_Button_Update'))

CustomKeywords.'applicationLibrary.checkboxMultiselection.multiselectCheckbox'(findTestData('credentialDetails/CheckBox').getValue(
        'CustomerCheckbox', 1))

WebUI.scrollToElement(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'), 5)

WebUI.click(findTestObject('OMVA_UserManagement_Page/Customer_Next_Btn'))

CustomKeywords.'applicationLibrary.checkboxMultiselection.multiselectCheckbox'(findTestData('credentialDetails/CheckBox').getValue(
        'ProductCheckBox', 1))

WebUI.click(findTestObject('OMVA_UserManagement_Page/UserCreation_Save_Btn'))

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/UserCreation_HeaderTxt'), 10)

WebUI.verifyElementText(findTestObject('OMVA_UserManagement_Page/UserCreation_HeaderTxt'), findTestData('credentialDetails/CheckBox').getValue(
        'MendatoryMsge', 1))

WebUI.verifyElementText(findTestObject('OMVA_UserManagement_Page/UserCreation_ContentTxt'), 'User has successfully been created. Details of account created will be shared with the user over email.')

WebUI.click(findTestObject('OMVA_UserManagement_Page/UserCreation_OK_Btn'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('OMVA_UserManagement_Page/Created_User_Username'), 15)

createdNewuser = WebUI.getText(findTestObject('OMVA_UserManagement_Page/Created_User_Username'))

String uname = createdNewuser.toString()

createduser = WebUI.verifyMatch(createdNewuser, (firstname + ' ') + lastname, true)

WebUI.delay(5)

CustomKeywords.'applicationLibrary.ClicksCreatedUserDashboard.editUser'(uname)

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'), 10)

WebUI.click(findTestObject('OMVA_Landing_Page/Act_DeAct_Radio_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_EditUser_Page/SaveExit_Btn'), 5)

WebUI.click(findTestObject('OMVA_EditUser_Page/SaveExit_Btn'))

WebUI.waitForElementVisible(findTestObject('OMVA_EditUser_Page/DeactivateUser_HeaderTxt'), 5)

AHeaderTxt = WebUI.getText(findTestObject('OMVA_EditUser_Page/DeactivateUser_HeaderTxt'))

WebUI.verifyMatch(AHeaderTxt, findTestData('credentialDetails/PopupStrings').getValue('DeactivateUserHeaderTxt', 1), true, 
    FailureHandling.STOP_ON_FAILURE)

AContentTxt = WebUI.getText(findTestObject('OMVA_EditUser_Page/DeactivateUser_ContentText'))

WebUI.verifyMatch(AContentTxt, findTestData('credentialDetails/PopupStrings').getValue('DeactivateUserContentTxt', 1) + 
    '\\D*', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('OMVA_EditUser_Page/DeactivateUser_OKBtn'))

ADeactivatedToastMsg = WebUI.getText(findTestObject('OMVA_EditUser_Page/Deactivate_ToastMsg'))

WebUI.verifyMatch(ADeactivatedToastMsg, findTestData('credentialDetails/PopupStrings').getValue('DeactivateUserToastMsg', 
        1), true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(8)

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/User_icon'), 10)

WebUI.click(findTestObject('OMVA_Landing_Page/User_icon'))

WebUI.waitForElementPresent(findTestObject('OMVA_Landing_Page/Logout_link'), 5)

WebUI.click(findTestObject('OMVA_Landing_Page/Logout_link'))

WebUI.waitForElementNotPresent(findTestObject('OMVA_Landing_Page/User_icon'), 0)

WebUI.callTestCase(findTestCase('CommonTestcases/OpenBrowserandNavigateToQAURL'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Username_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Username_Textbox'), username)

WebUI.click(findTestObject('OMVA_Login_Page/Next_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_Login_Page/Password_Textbox'), 10)

WebUI.sendKeys(findTestObject('OMVA_Login_Page/Password_Textbox'), username)

WebUI.click(findTestObject('OMVA_Login_Page/Signin_Button'))

WebUI.waitForElementVisible(findTestObject('OMVA_UserManagement_Page/DeactivatePopupMessage'), 5)

deactivateAccount = WebUI.getText(findTestObject('OMVA_UserManagement_Page/DeactivatePopupMessage'))

WebUI.verifyMatch(deactivateAccount, findTestData('credentialDetails/DeactivedAccountPopup').getValue('DeactivatedAccount', 
        1), false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

