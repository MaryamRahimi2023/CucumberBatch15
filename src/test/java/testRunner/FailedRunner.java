package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


// here I want to run only that 20 failed test cases

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/failed.txt",
        glue = "stepDefinitions",
        plugin = {"pretty"})

public class FailedRunner {


}
