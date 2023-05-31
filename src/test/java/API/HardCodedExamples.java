package API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURI=RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNDk5MjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTA5MzEyOCwidXNlcklkIjoiNTI4MiJ9.p9PkDvzKTG9pqIqF-sznCxfrd8n0SZJAKofaTEImnIo";

    static String employee_id;
    static  String expectedStatus=null;
    static String actualStatus;

    //in homework, create a method to get all employee status and job title

    @Test
    public void egetAllEmployeeStatus(){

        RequestSpecification preparedRequest= given().header("Authorization",token);
        Response response=preparedRequest.when().get(
                "/employeementStatus.php");
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void fgetJobTitle(){

        RequestSpecification preparedRequest=given().header("Authorization",token);
        Response response=preparedRequest.when().get("/jobTitle.php");
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest=given().header("Content-Type","application/json").header("Authorization",token).
                queryParam("employee_id",employee_id);

        // hitting the endpoint
        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        // verify the response

        response.then().assertThat().statusCode(200);
        String tempEmpId=response.jsonPath().getString("employee.employee_id");

        // we have emp id, one is global and second is local
        Assert.assertEquals(employee_id,tempEmpId);

    }

    @Test

    public  void cupdateEmployee(){
        RequestSpecification preparedRequest=given().header("content-type","application/json").header("Authorization",token)
                .body("{\n" +
                        "    \"employee_id\": \""+employee_id+"\",\n" +
                        "    \"emp_firstname\": \"Mati\",\n" +
                        "    \"emp_lastname\": \"Masi\",\n" +
                        "    \"emp_middle_name\": \"mr\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"2021-08-10\",\n" +
                        "    \"emp_status\": \"unconfirmed\",\n" +
                        "    \"emp_job_title\": \"Tester\"\n" +
                        "}");

        // hitting the endpoint
        Response response=preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        // for verification

        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }

    @Test

    public void dgetUpdatedEmployee(){

        RequestSpecification preparedRequest=given().header("Content-Type","application/json").header("Authorization",token).
                queryParam("employee_id",employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response.
        //you can do that using hamcrest matchers

    }

    @Test
    public void acreateEmployee(){

        // prepare the request

        RequestSpecification prepareRequest= given().header("content-type","application/json").header("Authorization",token)
                .body("{\n" +
                "  \"emp_firstname\": \"Mati\",\n" +
                "  \"emp_lastname\": \"Masi\",\n" +
                "  \"emp_middle_name\": \"mr\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2021-08-10\",\n" +
                "  \"emp_status\": \"confirmed\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}");

        // hitting the endpoint/ sending the request

       Response response= prepareRequest.when().post(
                "/createEmployee.php");

        //verifying the assertions

        response.then().assertThat().statusCode(201);

        // we are capturing employee id from the response

        employee_id=response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        // verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Mati"));
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Masi"));

        // we can verify  heathers

        response.then().assertThat().header("Content-Type","application/json");
        System.out.println("My testcase is passed");// to print my own message

      //  it will print the out name in to the console

        response.prettyPrint();// is printing the response


    }
}
