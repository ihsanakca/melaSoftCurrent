@wip
Feature: Create Company Tests
  Background:
    Given The user goes to login page and verifies that login page is opened
    When The user enters valid email: "testzsk123@gmail.com" and password: "testZsk199207."
    Then The user should be on the dashboard page

  Scenario: Creating a new company
    When The user clicks on the Create Company + located at the top-left corner.
    Then The user verifies that the Create Company page is opened.
    When The user types in "Germany" to the country select box and press Enter key.
    Then The user should be able to see Company Information Form.
    When The user fills the form with valid data.
    Then The user should be able to see the created company name on the left top

    Scenario: Deleting a company