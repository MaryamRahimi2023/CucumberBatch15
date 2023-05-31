package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    public LoginPage() {
        PageFactory.initElements(driver,this); // to initialize all the elements by driver in this page (hold driver anytime we call)
    }

    @FindBy(id="txtUsername") // here we can enter xpath ccs selector as well any way to find the webelement
    public WebElement usernameTextBox;

    @FindBy(id="txtPassword")
   public WebElement passwordTextBox;

    @FindBy(id="btnLogin")
   public WebElement loginBtn;

    @FindBy(id="welcome")
    public WebElement welcomeIcon;

    @FindBy(xpath="//a[text()='Logout']")
   public WebElement logoutLink;


    // this is page factory model in selenium is a better approach to write  and find the webelement

    // PageFactory: This is the name of a class in the Selenium WebDriver library.
    //.initElements(): This is a static method of the PageFactory class that initializes all the elements on a web page that are defined in a particular class.
    //driver: This is an object of the WebDriver class that is used to control the web browser.
    //this: This keyword refers to the current instance of the LoginPage class. In this case,
    // we're passing this as a parameter to the initElements method to indicate that we want to initialize the elements on the current page.



}
