package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsDemo {
	ExtentReports extent;  
	@BeforeTest
	public void Config()
	{
		//ExtentReports , ExtentSparkReporter
		String path = System.getProperty("Eclipse.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Harsha");
	}
	@Test 
	public void InitialDemo()
	{
		ExtentTest test = extent.createTest("Intial Demo");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.oracle.com/in/index.html");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result is not matching");
		extent.flush();
		
	}
	
}
