package dataBaseConnection

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

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
import groovy.sql.Sql

public class dataBase {

	private static Connection connection = null;

	@Keyword
	def connectDB(){

		//Load driver class for your specific database type
		String conn = 'jdbc:sqlserver://coa-demoazsql01.database.windows.net:1433;databaseName=coa-demosqldb'
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(conn, 'coademouser1', '$COA@demo973')
		if(connection)
		{
			println "Connected to DB"
		}
		else
		{
			println "Not connected to DB"
		}
	}

	@Keyword
	def void executeQuery(String userId) {
		String queryString ="EXEC[dbo].[DeleteUser_For_Testing]'"+userId+"'"
		Statement stm = connection.createStatement()
		stm.execute(queryString)
	}

	@Keyword
	def void ResetTestData() {
		String queryString ="EXEC [dbo].[Reset_For_Testing]"
		Statement stm = connection.createStatement()
		stm.execute(queryString)
	}

	@Keyword
	def closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}
}
