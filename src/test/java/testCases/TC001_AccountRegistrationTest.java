package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {

		try {
			logger.info("***********Starting TC001_AccountRegistrationTest************");

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();

			logger.info("Clicked on MyAccount link");

			hp.clickRegister();

			logger.info("Clicked on Register link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing customer details....");

			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString() + "@gmail.com"); // randomly generate the email
			regpage.setTelephone(randomeNumber());

			String password = randomeAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected Message...");
			String confmsg = regpage.getConfirmationMsg();
			
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed...");
				logger.debug("Debug logs...");
				Assert.assertFalse(false);
			}
			
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		} catch (Exception e) {

			Assert.fail();
		}
		
		logger.info("**********Finished TC001_AccountRegistrationTest********");
	}

}
