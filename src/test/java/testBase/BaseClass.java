package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
 public static WebDriver driver;
 public ResourceBundle RB;
 public Logger logger;
 @BeforeClass
 @Parameters({"browser"})
	public void setup(String br) {
	 RB=ResourceBundle.getBundle("config");
	logger=LogManager.getLogger(this.getClass());//get class name of logs file
	 if(br.equals("chrome")) {
		driver=new ChromeDriver(); 
	 }else {
		 driver= new EdgeDriver();
	 }
		driver=new ChromeDriver();
		driver.get(RB.getString("baseURL"));
	 logger.info("*********Launced webpage*******");
    	driver.manage().window().maximize();
    	logger.info("********maximize**********");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logger.info("**********implicitly wait********");
	}
 @AfterClass
 public void close() {
	 driver.quit();
 }
 public String captureScreen(String tname) {
	 String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	 TakesScreenshot screenshot=(TakesScreenshot)driver;
	 File source=screenshot.getScreenshotAs(OutputType.FILE);
	 String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
	 try {
		 FileUtils.copyFile(source, new File(destination));
	 }catch(Exception e) {
		 e.getMessage();
	 }
	return destination;
	 
 }
}
