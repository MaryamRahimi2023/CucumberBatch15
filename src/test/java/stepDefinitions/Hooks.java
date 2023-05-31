package stepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {


    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();

    }// what steps comes in between if data correct or not will run your text cases

    @After
    public void postConditions(Scenario scenario) {// will close the browser even if we pass wrong username or password

        // Scenario class will hole the complete information of your tests execution in cucumber framework

        byte [] pic;

        if(scenario.isFailed()){
            pic=takeScreenshot("failed/"+scenario.getId());
        }
        else {
            pic=takeScreenshot("passed/"+scenario.getName());
        }

        // attach the screenshot in my report

        scenario.attach(pic,"image/png",scenario.getName());

        closeBrowser();
    }
}
