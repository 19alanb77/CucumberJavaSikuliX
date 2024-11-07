package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

/**
 * Class that allows to run tests using SikuliX automation with IDE.
 * 
 * @author Alan Buda
 */ 
@RunWith(Cucumber.class)
@CucumberOptions(
  features = "features/Test1.feature"
  ,glue={"sikulixPage.General" , "sikulixPage.RegisterApp" , "sikulixPage.ScheduleApp"} 
  ,plugin = {"pretty", "html:test-output/cucumber-reports.html",
  "json:test-output/cucumber.json"} )
public class TestRunnerIDE {
	
}