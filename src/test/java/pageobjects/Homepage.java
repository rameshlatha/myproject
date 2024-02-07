package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {
 public Homepage(WebDriver driver) {
	 super(driver);
 }
 @FindBy(xpath="//a[text()='Create an Account']")
 WebElement btn_myact;
 
 public void click_myact() {
	 btn_myact.click();
 }
 
}
