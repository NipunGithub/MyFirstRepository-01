package com.mapcollection;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;

public class LearnMapParameterization {
	WebDriver driver;
	String url = "";

	@Given("navigate demo automation site")
	public void navigate_demo_automation_site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-Jar\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		url = "http://demo.automationtesting.in/Index.html";
		driver.get(url);
	}

	@Then("enter valid {string} username")
	public void enter_valid_username(String userName) {
		driver.findElement(By.id("email")).sendKeys(userName);
	}

	@Then("click submit button")
	public void click_submit_button() {
		driver.findElement(By.id("enterimg")).click();
	}

	@Then("Enter the validation data and click on refresh button")
	public void enter_the_validation_data_and_click_on_refresh_button(DataTable registryPage) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte Short, Long, BigInteger or BigDecimal.
		//

		for (Map<Object, Object> values : registryPage.asMaps(String.class, String.class)) {
			// enter the first name
			driver.findElement(By.xpath("//input[@placeholder='First Name']"))
					.sendKeys(values.get("FirstName").toString());

			// enter the last name
			driver.findElement(By.xpath("//input[@placeholder='Last Name']"))
					.sendKeys(values.get("LastName").toString());

			// enter the phone number
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(values.get("PhoneNumber").toString());

			// select the year
			WebElement year = driver.findElement(By.id("yearbox"));
			Select sel = new Select(year);
			List<WebElement> yr = sel.getOptions();
			for (WebElement el : yr) {
				if (el.getText().equals(values.get("Year").toString())) {
					el.click();
				}
			}

			// select month
			WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
			Select mon = new Select(month);
			List<WebElement> months = mon.getOptions();
			for (WebElement el : months) {
				if (el.getText().equals(values.get("Month").toString())) {
					el.click();
				}
			}

			// select day
			WebElement day = driver.findElement(By.xpath("//select[@placeholder='Day']"));
			Select dy = new Select(day);
			List<WebElement> days = dy.getOptions();
			for (WebElement el : days) {
				if (el.getText().equals(values.get("Day").toString())) {
					el.click();
				}
			}

			// enter the password
			driver.findElement(By.id("firstpassword")).sendKeys(values.get("Password").toString());

			// enter the confirm password
			driver.findElement(By.id("secondpassword")).sendKeys(values.get("ConfirmPassword").toString());

			// click on refresh button
			driver.findElement(By.id("Button1")).click();
			System.out.println("Refreshed successfully !!!! ");
		}
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
}
