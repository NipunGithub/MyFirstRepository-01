package com.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ParameterizeUsingString {

	WebDriver driver;
	String url = "";

	@Given("nevigate to demo automation site")
	public void nevigate_to_demo_automation_site() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-Jar\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		url = "http://demo.automationtesting.in/Index.html";
		driver.get(url);
	}

	@Then("click on skipsign {string} button")
	public void click_on_skipsign_button(String skipSignIn) {
		driver.findElement(By.id(skipSignIn)).click();
	}

	@Then("verify register title")
	public void verify_register_title() {
		if (driver.getTitle().equals("Register")) {
			System.out.println("Title -" + driver.getTitle());
		}
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}

	@Then("click on webtable tab")
	public void click_on_webtable_tab() {
		driver.findElement(By.xpath("//a[text()='WebTable']")).click();
	}

	@Then("verify webtable title")
	public void verify_webtable_title() {
		if (driver.getTitle().equals("Web Table")) {
			System.out.println("Title - " + driver.getTitle());
		}
	}

	@Then("click on home tab")
	public void click_on_home_tab() {
		driver.findElement(By.xpath("//a[text()='Home']")).click();
	}

	@Then("verify home page title")
	public void verify_home_page_title() {
		if (driver.getTitle().equals("Index")) {
			System.out.println();
		}
	}
}
