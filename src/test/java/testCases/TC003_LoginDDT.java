package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Data is valid -- login success -- test passed -- logout
 * Data is valid -- login failed -- test fail
 * 
 * Data is invalid -- login success -- test fail -- logout
 * Data is invalid -- login failed -- test passed
 */

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="DataDriven") // here dataProviderClass parameter is
																				// required as dataProviderClass is
																				// created in another class
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("****Starting TC003_LoginDDT****");

		try {
			// Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MyAccount page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			/*
			 * Data is valid -- login success -- test passed -- logout Data is valid --
			 * login failed -- test fail
			 * 
			 * Data is invalid -- login success -- test fail -- logout Data is invalid --
			 * login failed -- test passed
			 */

			if (exp.equalsIgnoreCase("Valid")) // Data is valid -- login success -- test passed -- logout
			{
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true); // assertion for test passed
				} else // Data is valid -- login failed -- test fail
				{
					Assert.assertTrue(false); // assertion for test failed
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) // Data is invalid -- login success -- test fail -- logout
			{
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false); // assertion for test failed
				} else // Data is invalid -- login failed -- test passed
				{
					Assert.assertTrue(true); // assertion for test passed
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("****Finished TC003_LoginDDT****");
	}

}
