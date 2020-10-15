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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
for(def rowNum=1; rowNum <=findTestData("data").getRowNumbers(); rowNum++)
{
//WebUI.navigateToUrl(url)
WebUI.navigateToUrl(findTestData("data").getValue(1,rowNum))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Make Appointment'))

//WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), username)
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), findTestData("data").getValue(2,rowNum))
//WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), password)
WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), findTestData("data").getValue(3,rowNum))

Thread.sleep(3000)
}
WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))

WebUI.waitForElementPresent(findTestObject('Page_CURA Healthcare Service/h2_Make Appointment'), 15)

WebUI.verifyElementText(findTestObject('Page_CURA Healthcare Service/h2_Make Appointment'), 'Make Appointment')

WebUI.closeBrowser()
