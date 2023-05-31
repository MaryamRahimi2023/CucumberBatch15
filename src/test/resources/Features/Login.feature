Feature: Login Functionalities

  @testcase1 @smoke
  Scenario: Valid Admin login

    # Given open the browser and lunch HRMS application // managed by HOOKS now
    When user enters valid email and valid password
      # data fitch from property file (config)
    And click on login button
    Then user is logged in successfully
    # And close the browser // managed by HOOKS now


  @testcase2
  Scenario: Valid Admin login

    # Given open the browser and lunch HRMS application // managed by HOOKS now
    When user enters valid email "ADMIN" and valid password "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    # And close the browser // managed by HOOKS now

   # 3 way to fitch data
    #1. hard coded
    #2. config or properties file
  #3. use cucumber feature

  # Parameterization/Data Driven

  @ScenarioOutline
  Scenario Outline: # if we use this we need to use example keyword too otherwise will gives us error
# login with multiple credentials using scenario outline
 # Given open the browser and lunch HRMS application // managed by HOOKS now
    When user enters valid email "<username>" and valid password "<password>"
    And click on login button
    Then user is logged in successfully
    # And close the browser // managed by HOOKS now
  Examples:
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |
    # no limitation we can add as mu ch data as needed  Cntl +alt +l to align it

  # data table  same performance just only one time the browser will lunch performs the actions and close and this is coz of java code
  # login with multiple credentials using data table
  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |