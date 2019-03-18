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
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

not_run: data = TestDataFactory.findTestData('credentialDetails/CreateUser')

not_run: data.getValue('UserName', 4)

not_run: WebUI.openBrowser('https://amalgamplus.techendeavour.com/index.php/component/lms/')

not_run: WebUI.delay(4)

not_run: WebUI.waitForElementVisible(findTestObject('Pratice/googleSubmitButton'), 5)

not_run: googleText = WebUI.getText(findTestObject('Pratice/googleSubmitButton'))

not_run: println(googleText)

//WebUI.verifyMatch(googleText, findTestData('credentialDetails/CreateUser').getValue('UserName', 7), false)
not_run: Assert.assertEquals(googleText, findTestData('credentialDetails/CreateUser').getValue('UserName', 7))

WebUI.callTestCase(findTestCase('CommonTestcases/Create_NewUser'), [('username') : '', ('emailidprefix') : '', ('firstname') : ''
        , ('lastname') : '', ('ticketnum') : '', ('createduser') : '', ('uname') : GlobalVariable.null], FailureHandling.STOP_ON_FAILURE)

println ('uname')
