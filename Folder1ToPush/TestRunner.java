package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resource\\StringParameterization.feature", 
                 glue = "com.stepdefinitions",
                 dryRun = true,
                 monochrome = true,
                 plugin= {"pretty","html:target/cucumber-html-report", "json:target/cucumber.json","pretty:target/cucumber-pretty.txt",
     					"usage:target/cucumber-usage.json","junit:target/cucumber-junitresults.xml"},
                 strict = false)
public class TestRunner {

}
