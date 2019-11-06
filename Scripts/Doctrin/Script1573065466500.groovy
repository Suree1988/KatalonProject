import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import sun.util.logging.resources.logging

import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.logging.KeywordLogger



WebUI.openBrowser('')

WebUI.maximizeWindow()

//Navigate to our website: https://doctrin.se/
WebUI.navigateToUrl('https://doctrin.se/')

WebUI.click(findTestObject('Page_Digitalisera vrden - Doctrin/a_Jobba hos oss'))

//Navigate to the careers section
WebUI.switchToWindowTitle('Doctrin - Career at Doctrin!')

WebUI.click(findTestObject('Object Repository/Page_Doctrin - Career at Doctrin/span_Career menu'))

WebUI.click(findTestObject('Object Repository/Page_Doctrin - Career at Doctrin/a_People'))

WebDriver driver = DriverFactory.getWebDriver()
// Get xpath
List<WebElement> columVal1 =  driver.findElements(By.xpath("//section//div//div//ul//li//a"))

//Logger
KeywordLogger log = new KeywordLogger()
String oneVal = "engineer"
String twoVal = "project"

//Go through the list of people working at Doctrin
for(int i=0; i<columVal1.size(); i++) {
	
	//Find  the list of names of people along with their titles, where their title contains either the word 'Engineer' or 'Project'	
	if (columVal1.get(i).getText().toLowerCase().contains(oneVal) || columVal1.get(i).getText().toLowerCase().contains(twoVal))  {
		
		log.logInfo("Name : " + columVal1.get(i).getText().replaceAll("[\\t\\n\\r]+", " - "))
		
		
	}

 }

// Close
WebUI.closeBrowser()


