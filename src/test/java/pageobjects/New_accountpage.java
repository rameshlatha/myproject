package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class New_accountpage extends Basepage {
 public New_accountpage(WebDriver driver) {
	 super(driver);
 }
 @FindBy(xpath="//input[@id='firstname']")
 WebElement txt_firstname;
 
 @FindBy(xpath="//input[@id='lastname']")
 WebElement txt_lastname;
 
 @FindBy(xpath="//input[@id='email_address']")
 WebElement txt_email;
 
 @FindBy(xpath="//input[@id='password']")
 WebElement txt_pwd;
 
 @FindBy(xpath="//input[@id='password-confirmation']")
 WebElement txt_conpwd;
 @FindBy(xpath="//button[@class='action submit primary']")
 WebElement btn_createacct;


 public void setFirstname(String uname) {
	 txt_firstname.sendKeys(uname);	 
 }
 public void setlastname(String lname) {
	 txt_lastname.sendKeys(lname);
 }
 public void setemail(String mailid) {
	 
	txt_email.sendKeys(mailid);
 }
 public void setPassword(String password) {
	 txt_pwd.sendKeys(password);
 }
 public void setConfirmpwd(String confmpwd) {
	 txt_conpwd.sendKeys(confmpwd);
	 
 }
 public void clickcreateacct() {
	 btn_createacct.click();
 }
 
 
 
 
 
 
 
}
