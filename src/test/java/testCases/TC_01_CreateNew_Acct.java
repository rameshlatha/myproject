package testCases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.New_accountpage;
import testBase.BaseClass;

public class TC_01_CreateNew_Acct extends BaseClass {
@Test
	public void CreateAccount() {
		Homepage Hp=new Homepage(driver);
		New_accountpage Nact=new New_accountpage(driver);
		logger.debug("*********Application logs*****");
		logger.info("**********click on my account*****");
	Hp.click_myact();
	Nact.setFirstname(RB.getString("Firstname"));
	logger.info("**********firstname*******");
	Nact.setlastname(RB.getString("lastname"));
	logger.info("**********lastname*******");
	Nact.setemail(RB.getString("email"));
	logger.info("**********email********");
	Nact.setPassword(RB.getString("password"));
	logger.info("***********password******");
	Nact.setConfirmpwd(RB.getString("Confirmpwd"));
	logger.info("**********confirmpwd********");
	Nact.clickcreateacct();
	logger.info("**********click on my act*****");
	
	
	
	}
}
