Feature: Login function

  Scenario: Positive Login test
    Given The user goes to login page and verifies that login page is opened
    When The user enters valid email: "testzsk123@gmail.com" and password: "testZsk199207."
    Then The user should be on the dashboard page