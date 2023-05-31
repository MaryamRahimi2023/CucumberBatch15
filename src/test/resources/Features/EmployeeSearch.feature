Feature: Searching the Employee

  Background: # when we have common steps for our testcases we write it here

    # Background: This is used to define all the common steps that is available in multiple
    # scenarios in our feature file. One Condition is that it will work until the flow or sequence is not broken

    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @empSearch @smoke1
  Scenario: Search employee by  Id
  #  Given open the browser and lunch HRMS application

    When user enters valid employee id
    And Clicks  on search button
    And user see employee information is displayed
   # And close the browser

  @empSearchJobTitle @smoke1
  Scenario: Search Employee by Job Title
    # Given open the browser and lunch HRMS application

    When user select Job Title
    And Clicks  on search button
    And user see the employee information is displayed
    # And close the browser

   # hooks@before->Background-->steps-->hooks@after