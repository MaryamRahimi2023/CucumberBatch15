package stepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.globalVariables;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
      //  WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        doClick(addEmployeePage.pimTab);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        //WebElement addEmployeeBtn=driver.findElement(By.id("menu_pim_addEmployee"));
        doClick(addEmployeePage.addEmployeeBtn);
    }
    @When("user entries firstname and middlename and lastname")
    public void user_entries_firstname_and_middlename_and_lastname() {
       // WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
        sendText(addEmployeePage.firstNameTextBox,ConfigReader.getPropertyValue("firstname"));
      //  WebElement middleNameTextBox=driver.findElement(By.id("middleName"));
        sendText(addEmployeePage.middleNameTextBox,ConfigReader.getPropertyValue("middlename"));
     //   WebElement lastNameTextBox=driver.findElement(By.id("lastName"));
        sendText(addEmployeePage.lastNameTextBox,ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
     //   WebElement saveBtn=driver.findElement(By.id("btnSave"));

        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        System.out.println("My Assertion is true");
        doClick(addEmployeePage.saveBtn);
    }

    @When("user entries {string} and {string} and {string}")
    public void user_entries_and_and(String fname, String mname, String lname) {
        sendText(addEmployeePage.firstNameTextBox,fname);// add fname directly from our feature file
        sendText(addEmployeePage.middleNameTextBox,mname);
        sendText(addEmployeePage.lastNameTextBox,lname);

    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
      globalVariables.emp_id= addEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee id is: " + globalVariables.emp_id);

    }
    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query="select * from hs_hr_employees where employee_id='"+globalVariables.emp_id+"'";
        // to store the table coming from db, we used global variable here
        //in this variable we got all the keys and vales for the employee we searched
        globalVariables.tabledata = DBUtility.getListOfMapsFromRset(query);
    }
    @Then("verify the results from frontend to backend")
    public void verify_the_results_from_frontend_to_backend() {
       // we use junit Assertion in cucumber to varify
        // now, from all values we need to compare one by one value
       String firstNmeFromDB= globalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNmeFromDB);
        String lastnamefromDB=globalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastnamefromDB);
        String middleNamefromDB=globalVariables.tabledata.get(0).get("emp_middle_name");

        Assert.assertEquals(firstNmeFromDB,"Nisha");
        Assert.assertEquals(lastnamefromDB,"standart");
        Assert.assertEquals(middleNamefromDB,"sania");// we can pass through config as well
        System.out.println("My assertion has passed my test case");
    }





}
