Feature: API workflow for HRMS

Background:

  Given  a JWT is generated

  @api
  Scenario: create an employee using API call

    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    Then the employee contains key "Message" and value "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

@apijsonWorkflow

Scenario: create an employee using API call

  Given a request is prepared to create an employee using json payload
  When a POST call is made to create an employee
  Then the status code for creating an employee is 201
  Then the employee contains key "Message" and value "Employee Created"
  Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls


  @apijsonWorkflow

  Scenario: retrieve an employee using API call

    Given a request is prepared to get the created employee
    When a get call is made to get the employee
    Then the status code for this employee is 200
    Then the employee data we get having id "employee.employee_id" must match with global variable
    # employee.employee_id is coming from different API from get call employee source
    Then the retrieved data at "employee" object matched with the data of created employee

    |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title
    |Mati        |Masi       |mr              |Male        |2014-07-25  |confirmed |QA Engineer

    @dynamic

    Scenario: create an employee using API call
      Given a request is prepared to create an employee with dynamic data "nelena" , "faria" , "ms" , "F" , "2012-05-20" , "Confirmed" , "Engineer"
      When a POST call is made to create an employee
      Then the status code for creating an employee is 201
      Then the employee contains key "Message" and value "Employee Created"
      Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

      @updateemployee

      Scenario: updating the employee

        Given a request is prepared to update an employee
        When a Put call is made to update an employee
        Then the status code of Updated employee is 200
