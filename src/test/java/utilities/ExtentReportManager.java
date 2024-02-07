package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repname;
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
		repname="Test-Report-"+timestamp+".html";
		//specify the location of folder
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repname);
		sparkreporter.config().setDocumentTitle("Automation testing");
		sparkreporter.config().setReportName("Smoke Test");
		sparkreporter.config().setTheme(Theme.DARK);
		
		//common info
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("computer name", "localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Testername", "Latha");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "chrome");	
	}
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());  //create a entry in report
		test.log(Status.PASS, "Test is passed:"+result.getName()); //update the info in the report
		System.out.println("Test is passed");
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getName());
		test.log(Status.FAIL, "Test is failed:"+result.getThrowable());
		
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getName());
		test.log(Status.SKIP, "Test is skipped:"+result.getThrowable());
		try {
			String imgpath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	


}
