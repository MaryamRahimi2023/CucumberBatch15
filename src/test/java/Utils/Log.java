package Utils;

import org.apache.log4j.*;

public class Log {

    public static Logger log = Logger.getLogger(Log.class.getName());

     // When the test starts, I should print the logs
    // When my tests stops, I should print the logs
    // If I want to print any message in between, I should print the logs
    // it is optional as per boss or customer request if they need a log to be printed

    public static void  startTestCase(String testCaseName){

        log.info("********************");
        log.info("*********************");
        log.info("***************"+ testCaseName + "**********");
    }

    public static void endTestCase(String testCaseName){

        log.info("###############################");
        log.info("#################################");
        log.info("#############"+ testCaseName+"#####################");

    }

    public static void info(String message){
        log.info(message);
    }
    public  static void warning(String warning)
    {
        log.info(warning);
    }
}
