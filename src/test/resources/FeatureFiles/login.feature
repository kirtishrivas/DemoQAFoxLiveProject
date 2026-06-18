
Feature: Login Functionality

  @Login @One
  Scenario: Verify whether the user is able to login into the application by providing valid credentials
    Given I launch the application
    And I navigate to Login page
    When I enter valid email address "Ravi.kiran88@gmail.com"
    And I enter valid password "rkiran"
    And I click on Login button
    Then I should see that the user is successfully logged in
    
    @Login @Two
  Scenario: Verify that the User is not able to login with invalid credentials
    Given I launch the application
    And I navigate to Login page
    When I login to the application using Username "ravi.kiran99@gmail.com" and Password "rkiran99"
    Then I should see an error message informing the User about invalid credentials
    
    @Login @Three
  Scenario: Verify that the User is not able to login without providing credentials
    Given I launch the application
    And I navigate to Login page
    When I login to the application using Username "" and Password ""
    Then I should see an error message informing the User about invalid credentials
    
    @Login @Four
  Scenario: Verify that the User is able to reset forgotten password
    Given I launch the application
    And I navigate to Login page
    When I reset the forgotten password for "ravi.kiran88@gmail.com"
    Then I should see a message informing that the password reset details have been sent to the email address