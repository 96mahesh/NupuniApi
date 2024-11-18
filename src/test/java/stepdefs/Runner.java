package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features",
		glue = "stepdefs",
		dryRun = false,
		monochrome = true,
	    
				plugin = { "pretty",
						"junit:target/cucumber-reports/Cucumber.xml",
						"json:target/cucumber-reports/Cucumber.json",
						"html:target/cucumber-report/cucumber.html",
						"html:target/cucumber-html-report",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						//"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
		}
	   
	
		)
public class Runner {

}
