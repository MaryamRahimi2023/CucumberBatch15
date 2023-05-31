package Utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


public class CommonMethods extends PageInitializer {

   public static WebDriver driver;

    public static void openBrowserAndLaunchApplication()
    {
        ConfigReader.readProperties();
        String browserType=ConfigReader.getPropertyValue("browserType");

        switch (browserType){
            case "Chrome":
                ChromeOptions ops = new ChromeOptions();// test without opening browser
                ops.addArguments("--no-sandbox"); // limit box
                ops.addArguments("--remote-allow-origins=*");
                if(ConfigReader.getPropertyValue("Headless").equals("true")){
                    ops.addArguments("--headless=new");
                }
                driver = new ChromeDriver(ops);
                break;
            case "Firefox":
                driver =new FirefoxDriver();
                break;
            case "IE":
                driver =new InternetExplorerDriver();
                break;
            default:
                driver =new EdgeDriver();
                break;
        }

        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Constants.WAIT_TIME));// not hard coded anymore and can be re useable
        initializePageObjects();

        // To configure the file and pattern of it
        DOMConfigurator.configure("log4j.xml");// in dependencies pom all these are written
        Log.startTestCase("This is the beginning of my test cae");
        Log.info("My test case is executing now");
        Log.warning("My test case might have some trivial issue");


    }

    public static void closeBrowser(){
        Log.info("This test cae is about to completed");
        Log.endTestCase("This test case is finished");
        driver.close();

    }

    public static void doClick(WebElement element){
        element.click();
    }

    public static void sendText(WebElement element, String text)
    {
        element.clear();
        element.sendKeys(text);
    }

    public static Select clickOnDropdown(WebElement element) { // for dropDown
        Select select = new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value)
    {
        clickOnDropdown(element).selectByValue(value);
    }
    public static void selectByVisibleText(WebElement element, String text)
    {
        clickOnDropdown(element).selectByVisibleText(text);
    }
    public static void selectByIndex(WebElement element, int index)
    {
        clickOnDropdown(element).selectByIndex(index);
    }
    public static void selectByOptions(WebElement element, String text)
    {
        List<WebElement> options=clickOnDropdown(element).getOptions();
        for (WebElement option : options) {
           String ddlOptionText=option.getText();
            if(ddlOptionText.equals(text)) {
                option.getText();
            }

        }
    }


   //=================================SCREENSHOT=====================================

    public static byte[] takeScreenshot(String imageName){

        // this casts the webdriver instance 'driver' to TakeScreenshot interface

        TakesScreenshot ts=(TakesScreenshot) driver;  // Why casting ? When you want to fit one Type to another explicitly

        // This captures the screenshot and stores it as byte array
        byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES); // we need array coz multiple screenshot will be there image return type is byte
        File sourcePath=ts.getScreenshotAs(OutputType.FILE); // copy to sorcepath the picture


        try {
            FileUtils.copyFile(sourcePath,new File(Constants.SCREENSHOT_FILEPATH+imageName+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".PNG"));
            // save it into the destination with a unique name                                               mm for minutes small to differentiate from month
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        return picBytes;


        // coz the same picture will save in the folder and we need to rename it inorder to have both pictures saved in the folder do
        // we add parameter to the method imageName and date and time or time stamp method to save every picture with different name.

    }

    public static String getTimeStamp(String pattern){

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
