package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.Loginpage;
import utilities.ExcelUtility;

public class Logintest extends Base {

	@Test(description = "Verifying successful user login with valid credentials")
	public void loginWithValidCeredentials() throws IOException {
		String user = ExcelUtility.getStringData(0, 0, "loginpage");
		String pass = ExcelUtility.getStringData(0, 1, "loginpage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameonUserNameField(user);
		loginpage.enterPasswordOnPasswordField(pass);
		loginpage.clickOnSubmitButton();
		boolean dashboarddisplay = loginpage.dashboardTileDisplayed();
		Assert.assertTrue(dashboarddisplay);
	}

	@Test(description = "Verifying user login with invalid credentials")
	public void loginWithBothInvalidCeredentials() throws IOException {
		String user = ExcelUtility.getStringData(1, 0, "loginpage");
		String pass = ExcelUtility.getStringData(1, 1, "loginpage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.enterUserNameonUserNameField(user);
		loginpage.enterPasswordOnPasswordField(pass);
		loginpage.clickOnSubmitButton();
		boolean alertdisplay = loginpage.alertMessageDisplayed();
		Assert.assertTrue(alertdisplay);
	}

}
