package stepDefinitions;

import Pages.AddEmployeePage;
import Pages.EmployeeSearchPage;
import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;
    public  static AddEmployeePage addEmployeePage;
    public static EmployeeSearchPage EmployeeSearchPage;

    public static void initializePageObjects(){

        login=new LoginPage();
        addEmployeePage= new AddEmployeePage();
        EmployeeSearchPage=new EmployeeSearchPage();


    }





    // This class will manage the object creation of different page Objects in our Framework.
// Instead of calling the age objects again and again, this class will take good care of that step
}
