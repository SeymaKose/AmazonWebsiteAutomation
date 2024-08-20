package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepDefinitions {
	static WebDriver driver;
	
	@Given("user is on Amazon homepage")
	public void user_is_on_amazon_homepage() throws InterruptedException {
	    driver = new ChromeDriver();
	    driver.get("https://www.amazon.com.tr/");
	    driver.manage().window().maximize(); 
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user clicks sign up text")
	public void user_clicks_sign_up_text() {
	    driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/div/a")).click();
	}

	@And("user is on sign up page")
	public void user_is_on_sign_up_page() {
		assert driver.findElements(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1")).size()>0;
	}

	@And("user enters a valid name-surname")
	public void user_enters_a_valid_name_surname() {
	    driver.findElement(By.id("ap_customer_name")).sendKeys("Hamit");
	}

	@And("user enters a valid email")
	public void user_enters_a_valid_email() throws InterruptedException {
	    driver.findElement(By.id("ap_email")).sendKeys("hamit@gmail.com");
	    Thread.sleep(500);
	}

	@And("user enters a valid password")
	public void user_enters_a_valid_password() {
	    driver.findElement(By.id("ap_password")).sendKeys("1234567");
	}

	@And("user re-enters the password for confirmation")
	public void user_re_enters_the_password_for_confirmation() throws InterruptedException {
		driver.findElement(By.id("ap_password_check")).sendKeys("1234567");
		Thread.sleep(1000);
	}

	@And("user clicks create account button")
	public void user_clicks_create_account_button() {
	    driver.findElement(By.id("continue")).click();
	}

	@Then("user should be navigated to the email verification page")
	public void user_should_be_navigated_to_the_email_verification_page() {
	    assert driver.findElements(By.xpath("//*[@id=\"verification-code-form\"]/div[1]/div[1]/h1")).size()>0;
	}

	@And("close browser")
	public void close_browser() {
	    driver.quit();
	}

	@And("user enters invalid name-surname")
	public void user_enters_invalid_name_surname() {
		driver.findElement(By.id("ap_customer_name")).sendKeys("&^&+^865");
	}

	@Then("user should see an error message indicating the name-surname is invalid")
	public void user_should_see_an_error_message_indicating_the_name_surname_is_invalid() throws InterruptedException {
		driver.findElement(By.id("auth-error-message-box")).isDisplayed();
		Thread.sleep(1000);
	}

	@And("user enters an invalid email")
	public void user_enters_an_invalid_email() {
		driver.findElement(By.id("ap_email")).sendKeys("gdxsrfrg");
	}

	@Then("user should see an error message indicating the email address is invalid")
	public void user_should_see_an_error_message_indicating_the_email_address_is_invalid() {
	    driver.findElement(By.id("auth-email-invalid-email-alert")).isDisplayed();
	}

	@And("user enters a registered email")
	public void user_enters_a_registered_email() {
		driver.findElement(By.id("ap_email")).sendKeys("sseymakkose@gmail.com");
	}

	@Then("user should see an error message indicating the email address is already registered")
	public void user_should_see_an_error_message_indicating_the_email_address_is_already_registered() throws InterruptedException {
		driver.findElement(By.id("auth-warning-message-box")).isDisplayed();
		Thread.sleep(1000);
	}

	@And("user re-enters a different password")
	public void user_re_enters_a_different_password() {
		driver.findElement(By.id("ap_password_check")).sendKeys("158xffj");
	}

	@Then("user should see an error message indicating that the passwords do not match")
	public void user_should_see_an_error_message_indicating_that_the_passwords_do_not_match() {
	    driver.findElement(By.id("auth-password-mismatch-alert")).isDisplayed();
	}

	@And("user leaves the name-surname field empty")
	public void user_leaves_the_name_surname_field_empty() {
		driver.findElement(By.id("ap_customer_name")).sendKeys("");
	}

	@Then("user should see an error message indicating that the name-surname field cannot be empty")
	public void user_should_see_an_error_message_indicating_that_the_name_surname_field_cannot_be_empty() {
		driver.findElement(By.id("auth-customerName-missing-alert")).isDisplayed();
	}

	@And("user leaves the email field empty")
	public void user_leaves_the_email_field_empty() {
		driver.findElement(By.id("ap_email")).sendKeys("");
	}

	@Then("user should see an error message indicating that the email field cannot be empty")
	public void user_should_see_an_error_message_indicating_that_the_email_field_cannot_be_empty() {
		driver.findElement(By.id("auth-email-missing-alert")).isDisplayed();
	}

	@And("user leaves the password field empty")
	public void user_leaves_the_password_field_empty() {
		driver.findElement(By.id("ap_password")).sendKeys("");
	}

	@And("user leaves the re-enter password field empty")
	public void user_leaves_the_re_enter_password_field_empty() {
		driver.findElement(By.id("ap_password_check")).sendKeys("");
	}

	@Then("user should see an error message indicating that the password field cannot be empty")
	public void user_should_see_an_error_message_indicating_that_the_password_field_cannot_be_empty() {
		driver.findElement(By.id("auth-password-missing-alert")).isDisplayed();
	}

	@Then("user should see an error message indicating that the re-enter password field cannot be empty")
	public void user_should_see_an_error_message_indicating_that_the_re_enter_password_field_cannot_be_empty() {
		driver.findElement(By.id("auth-passwordCheck-missing-alert")).isDisplayed();
	}

	@Then("user check the legal marketing checkbox")
	public void user_check_the_legal_marketing_checkbox() {
	    driver.findElement(By.name("legalMarketingCheckBox")).click();
	}

	@And("user clicks resend OTP button")
	public void user_clicks_resend_otp_button() {
	    driver.findElement(By.id("cvf-resend-link")).click();
	}

	@Then("user should see information text about resending verification code")
	public void user_should_see_information_text_about_resending_verification_code() {
		driver.findElement(By.xpath("//*[@id=\"verification-code-form\"]/div[3]/div[3]")).isDisplayed();
	}

	@And("user should see information note about not recieving verification email")
	public void user_should_see_information_note_about_not_recieving_verification_email() {
		driver.findElement(By.xpath("//*[@id=\"cvf-page-content\"]/div/div/div[3]/span")).isDisplayed();
	}

	@And("user clicks change text")
	public void user_clicks_change_text() {
	    driver.findElement(By.xpath("//*[@id=\"verification-code-form\"]/div[1]/div[2]/a")).click();
	}

	@Then("user should be navigated to sign up page")
	public void user_should_be_navigated_to_sign_up_page() {
	    assert driver.findElements(By.xpath("//*[@id=\"ap_register_form\"]/div/div/h1")).size()>0;
		//String currentUrl = driver.getCurrentUrl(); 
		//assert.assertEquals(currentUrl, "https://www.amazon.com.tr/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com.tr%2Fref%3Dnav_logo%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=trflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	}
}
