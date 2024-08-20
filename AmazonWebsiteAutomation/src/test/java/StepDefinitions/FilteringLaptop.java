package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilteringLaptop {
	static WebDriver driver;
	static Actions action;
	
	@Given("user is on homepage")
	public void user_is_on_homepage() {
	    driver = new ChromeDriver();
	    action = new Actions(driver);
	    driver.get("https://www.amazon.com.tr/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.findElement(By.xpath("//*[@id=\"sp-cc-rejectall-link\"]")).click();
	}

	@When("user clicks on the Electronics text")
	public void user_clicks_on_the_electronics_text() {
		driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[6]")).click();
	}

	@And("user clicks on Laptops under the Computers, Components & Accessories dropdown menu")
	public void user_clicks_on_laptops_under_the_computers_components_accessories_dropdown_menu() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[5]/span[1]"));
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Dizüstü Bilgisayarlar')]")).click();
	}

	@And("user clicks on the Windows option in the Laptops dropdown menu")
	public void user_clicks_on_the_windows_option_in_the_laptops_dropdown_menu() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[3]/span[1]"));
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ab:tr_subnav_flyout_pclaptops-content-1:generic-subnav-flyout\"]/div[2]/div/div/ul/li[2]/a")).click();
	}
	
	@When("user should view laptops with the Windows operating system")
	public void user_should_view_laptops_with_the_windows_operating_system() {
		assert driver.findElements(By.xpath("//div[@class='sg-col-inner']//span[contains(text(), 'Windows')]")).size()>0;
	}

	@Then("user should view laptops with the Windows11 Home operating system")
	public void user_should_view_laptops_with_the_windows11_home_operating_system() {
		 assert driver.findElements(By.xpath("//div[@class='sg-col-inner']//span[contains(text(), 'Windows 11 Home')]")).size()>0;
	}

	@And("close web browser")
	public void close_web_browser() {
	    driver.quit();
	}

	@And("user selects Windows11 Home from the Operation Systems section in the left sidebar filters")
	public void user_selects_windows11_home_from_the_operation_systems_section_in_the_left_sidebar_filters() {
	    driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[4]/ul/li[1]/span/a/div/label/i")).click();
	}

	@When("user clicks All hamburger menu")
	public void user_clicks_all_hamburger_menu(){
		driver.findElement(By.id("nav-hamburger-menu")).click();
	}

	@And("user clicks on Computer")
	public void user_clicks_on_computer() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[10]")).click();
		Thread.sleep(1000);
	}

	@And("user selects Laptops")
	public void user_selects_laptops() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hmenu-content']/ul[5]/li[3]/a")));

		WebElement element = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[5]/li[3]/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@And("user clicks on See All")
	public void user_clicks_on_see_all() {
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[11]/a[1]")).click();
	}

	@And("user selects Electronics")
	public void user_selects_electronics() {
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/ul/li[2]/a")).click();
	}

	@And("user selects computer")
	public void user_selects_computer() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[6]/li[3]/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@When("user enters {string} into the search bar")
	public void user_enters_into_the_search_bar(String searchText) {
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchText);
	}

	@And("user clicks the search button")
	public void user_clicks_the_search_button() {
		driver.findElement(By.id("nav-search-submit-button")).click();
	}
	
	@And("user selects Laptops from the Category section in the left sidebar filters")
	public void user_selects_laptops_from_the_category_section_in_the_left_sidebar_filters() {
		driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[2]/ul/li[7]/span/a")).click(); 
	}

	@And("user selects Laptops under the Category section in the left sidebar filters")
	public void user_selects_laptops_under_the_category_section_in_the_left_sidebar_filters() {
		driver.findElement(By.xpath("//*[@id=\"n/12601898031\"]/span/a")).click(); 
	}
	
	@And("user selects Windows11 Home under the Operation Systems section in the left sidebar filters")
	public void user_selects_windows11_home_under_the_operation_systems_section_in_the_left_sidebar_filters() {
		action.moveToElement(driver.findElement(By.id("p_n_feature_thirty-one_browse-bin-title")));
		action.perform();
	    driver.findElement(By.xpath("//*[@id=\"p_n_operating_system_browse-bin/27413042031\"]/span/a/div/label/i")).click();
	}
}
