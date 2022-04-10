Feature: Smoke Test

  @SmokeJenkins
  Scenario: TC08 registering with valid credentials
    Given user is on registration page
    And user enters ssn number
    And user enters firstname
    And user enters lastname
    And user provides username
    And user provides email
    And user provides firstPassword
    And user provides secondPassword
    When user clicks on register button
    Then user verifies the success message as "Registration Saved"
