package dataManager

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.io.File
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Cell

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

public class ExcelLibrary {

	@Keyword
	public static String[][] readExcelData(String filePath,String fileName,String sheetName) throws IOException{
		String[][] values=null;
		try {
			File file = new File(filePath+"\\"+fileName);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook wb  = null;
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if(fileExtensionName.equals(".xlsx")){
				wb = new XSSFWorkbook(inputStream);
			}
			Sheet wbSheet = wb.getSheet(sheetName);
			int rowCount = wbSheet.getLastRowNum()-wbSheet.getFirstRowNum();
			for (int i = 0; i < rowCount+1; i++) {
				Row row = wbSheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					values = row.getCell(j).getStringCellValue();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace()
		}
		return values;
	}
}

