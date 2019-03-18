package applicationLibrary
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.testng.Assert
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class checkboxMultiselection {
	/**
	 * Refresh browser
	 */
	@Keyword
	def multiselectCheckbox(String input) {
		KeywordUtil.logInfo("multiselecting checkboxes")
		String[] input_array=input.split('#');
		println input_array
		WebDriver webDriver = DriverFactory.getWebDriver()
		for(int i=0;i<input_array.length;i++) {
			println ("Element is "+input_array[i])
			Thread.sleep(2000);
			//webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS)
			webDriver.findElement(By.xpath(input_array[i])).click();
		}
	}

	@Keyword
	def checkbox(String input) {
		KeywordUtil.logInfo("checkbox")
		String[] input_array=input.split('#');
		println input_array
		WebDriver webDriver = DriverFactory.getWebDriver()
		for(int i=0;i<input_array.length;i++) {
			println ("Element is "+input_array[i])
			Thread.sleep(2000);
			webDriver.findElement(By.xpath(input_array[i])).click();
		}
	}
}