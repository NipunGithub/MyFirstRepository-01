package com.listcollection;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class LearnListParameterization {

	WebDriver driver;
	String url = "";

	@Given("navigate to demo automation site")
	public void navigate_to_demo_automation_site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-Jar\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		url = "http://demo.automationtesting.in/Index.html";
		driver.get(url);
	}

	@Then("enter the valid username")
	public void enter_the_valid_username(DataTable credentials) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.

		List<List<String>> data = credentials.cells();
		driver.findElement(By.id("email")).sendKeys(data.get(0).get(0));
	}

	@Then("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.id("enterimg")).click();
	}

	@Then("enter the registry details")
	public void enter_the_registry_details(DataTable registryDetail) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.

		List<List<String>> data = registryDetail.cells();

		// enter the first name
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data.get(0).get(0));
		// enter the last name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data.get(0).get(1));
		// enter the address
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(data.get(0).get(2));
		// enter the email id
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(data.get(0).get(3));
	}

	@Then("print the message")
	public void print_the_message() {
		System.out.println("Registry page details are added");
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

	@Then("verify login successfull")
	public void verify_login_successfull() {
		String actValue = driver.findElement(By.xpath("//h1[contains(text(), 'Automation Demo Site')]")).getText();
		if (actValue.contains("Automation Demo")) {
			System.out.println("Welcome to registry page");
		} else {
			System.out.println("Registry page not opened");
		}
	}

}
