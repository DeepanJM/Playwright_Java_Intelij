Feature: Login functionality
  Scenario: Successful login and click Time link
    Given user navigates to the login page
    When user logs in with username "Admin" and password "admin123"
    Then user should see the Time link
    And user clicks the Time link
