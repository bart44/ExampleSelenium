package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import objects.LoginPage;
import resources.Base;

import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

	@Given("^Init browser with Chrome$")
	public void init_browser_with_Chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = initDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" login page$")
	public void navigate_to_login_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	  @When("^User enters (.+) and (.+) and logging$")
	    public void user_enters_and_and_logging(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterLogin().sendKeys(username);
		loginPage.enterPassword().sendKeys(password);
		loginPage.signIn().click();
	}

	@Then("^Verify login of user$")
	public void verify_login_of_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.logged().getText(), "Secure Area");
		//it will thow error with wrong credentials on purpose
	}
	
    @And("^Close browsers$")
    public void close_browsers() throws Throwable {
		driver.close();
		driver = null;
    }
}
