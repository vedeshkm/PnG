package commonLibrary

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

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
import com.sun.media.sound.SoftReverb.Delay

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class commonFunctions {

	@Keyword
	def randomStringFunction(String chars, int length) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return sb.toString();
	}

	@Keyword
	def boolean ChecknoData () {

		WebDriver webDriver = DriverFactory.getWebDriver()
		Boolean checknoData= webDriver.findElements(By.xpath("//div[@class='rgt-panel-div col-lg-9 col-md-9 noData']")).size()>0;
		try {
			if(checknoData) {
				println "A"
				Thread.sleep(3000);
				webDriver.findElement(By.id("//img[@id='dropdown']")).click();
				webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
				webDriver.findElement(By.xpath("//a[text()='Logout']")).click();
			}
		} catch (Exception e) {
			println "Failed"
		}
	}
	//return value
}
