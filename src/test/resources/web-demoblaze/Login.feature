@login
Feature: Login

  @success-login
  Scenario: User success login
    Given User is on landing page
    When User click header menu login
    And User input username with "zilong123"
    And User input password with "123"
    And User click button login
    Then User is success login

  @login-wrong-password
  Scenario: User login with wrong password
    Given User is on landing page
    When User click header menu login
    And User input username with "zilong123"
    And User input password with "xxx123"
    And User click button login
    Then User able to see popup "Wrong password."