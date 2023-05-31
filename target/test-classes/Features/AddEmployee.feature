Feature: Employee

  Background:

    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button


  @addemployee @smoke # we can add multiple tags for one test case
  Scenario: Adding a new Employee
   # Given open the browser and lunch HRMS application
   # When user enters valid email and valid password
   # And click on login button
   # When user clicks on PIM option
   # And user clicks on add employee button
    And user entries firstname and middlename and lastname
   # And user clicks on save button
   # And close the browser

  @database
  Scenario:  Adding the employee from UI (frontend) and verifying it from backend

   # When user enters valid email and valid password
   # And click on login button
   # When user clicks on PIM option
   # And user clicks on add employee button
    And user entries "Nisha" and "sania" and "standart"
    And user captures the employee id
    And user clicks on save button
    And query the information in backend
    Then verify the results from frontend to backend
