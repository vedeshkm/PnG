package applicationLibrary

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ClicksCreatedUserDashboard {

	@Keyword
	def void editUser(String userId) {
		WebDriver driver = DriverFactory.getWebDriver()
		boolean isPresent = driver.findElement(By.xpath("//tr[contains(text(),'"+userId+"')]/ancestor::td/following-sibling::td/descendant::span[@class='icon-edit custom-cursor']")).isDisplayed();
		if(isPresent) {
			driver.findElement(By.xpath("//tr[contains(text(),'"+userId+"')]/ancestor::td/following-sibling::td/descendant::span[@class='icon-edit custom-cursor']")).click();
		}
		else {
			  println "Username not exist"
		}
	}
}
