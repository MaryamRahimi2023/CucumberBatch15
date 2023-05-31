package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue = "stepDefinitions",
        dryRun = false,
        tags = "@database",
        plugin = {"pretty", "html:target/Cucumber.html", "json:target/Cucumber.json","rerun:target/failed.txt"})


// when we have 100 case 80 passed 20 not passed and here we only need the 20 which failed so it provide the destination where it failed in a text file
// in target folder
// "html:target/Cucumber.html", "json:target/Cucumber.json" generate reports in target folder
// pretty give you more info in ur console
// tags = "@testcase1 or @testcase2 and @smoke", we can run multiple tags
// if dryRun = true not execute the test case only give you the codes after you got the code you needed you can make it false
// to executed

// if we put and instead of or then any test case which has @testcase2 and @smoke will be executed here 2 case will be

// if i write \\login.features in feature then only this file will run not all the folder with different cases
// if i write \Login.features in glue then it will not run
// there can be multiple features and stepDefinitions always and also multiple runner but in rare cases
// we need runner class to run different



public class SmokeRunner {
}
