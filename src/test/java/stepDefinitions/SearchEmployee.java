package stepDefinitions;

import Pages.EmployeeSearchPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchEmployee extends CommonMethods {


    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

      // WebElement idTextBox= driver.findElement(By.id("empsearch_id"));
       sendText(EmployeeSearchPage.idTextBox, ConfigReader.getPropertyValue("empid"));

    }
    @When("Clicks  on search button")
    public void clicks_on_search_button() {

      // WebElement searchBtn= driver.findElement(By.id("searchBtn"));
       doClick(EmployeeSearchPage.searchBtn);

    }
    @When("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {

      // WebElement idTextBox= driver.findElement(By.id("empsearch_id"));
        if(EmployeeSearchPage.idTextBox.equals(ConfigReader.getPropertyValue("empid")));
        System.out.println(EmployeeSearchPage.idTextBox.isDisplayed());
        System.out.println("Employee found");

    }

    @When("user select Job Title")
    public void user_select_job_title() {

     //   WebElement jobTitleDdl = driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(EmployeeSearchPage.jobTitleDdl, "Singer");

    }
    @When("user see the employee information is displayed")
    public void user_see_the_employee_information_is_displayed() {

     //  WebElement jobTitleDdl= driver.findElement(By.id("empsearch_job_title"));
        if(EmployeeSearchPage.jobTitleDdl.equals("Singer"));
        System.out.println(EmployeeSearchPage.jobTitleDdl.isDisplayed());
        System.out.println("The Employee found");

        WebElement jobTitleDdl1 = driver.findElement(By.id("empsearch_job_title"));
        selectByOptions(jobTitleDdl1, "Singer");

       // WebElement EmpStatusDdl2= driver.findElement(By.id("empsearch_employee_status"));
        selectByOptions(EmployeeSearchPage.EmpStatusDdl2, "Active");

       // WebElement includeDdl3= driver.findElement(By.id("empsearch_termination"));
        selectByOptions(EmployeeSearchPage.includeDdl3, "Current and Past Employees");
    }



}

