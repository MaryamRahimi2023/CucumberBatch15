package Utils;

import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload= "{\n" +
                "  \"emp_firstname\": \"Mati\",\n" +
                "  \"emp_lastname\": \"Masi\",\n" +
                "  \"emp_middle_name\": \"mr\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2014-07-25\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"QA Engineer\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){

    JSONObject obj=new JSONObject();

        obj.put("emp_firstname","Mati");
        obj.put("emp_lastname","Masi");
        obj.put("emp_middle_name","mr");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2014-07-25");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","QA Engineer");
        return obj.toString();
    }

    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj = new JSONObject();
        obj.put("employee_id","57590A");
        obj.put("emp_firstname","natalia");
        obj.put("emp_lastname","glusco");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2011-04-22");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Manager");
        return obj.toString();
    }
}
