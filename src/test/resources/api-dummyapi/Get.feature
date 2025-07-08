@Get
Feature: Get

  @Get-all-data
  Scenario: User get all data
    Given The user API is available
    When User request get all data
    Then The response status should be 200
    And The data format must be match with jsonschema


  @Get-spesific-data
  Scenario: User get spesific data
    Given The user API is available
    When User request get spesific data "60d0fe4f5311236168a109d0"
    Then The id should be "60d0fe4f5311236168a109d0"
    And The response status should be 200

  @Get-wrong-id
  Scenario: User get wrong id
    Given The user API is available
    When User request get spesific wrong data "1234567890"
    Then User able to see error message "PARAMS_NOT_VALID"
    And The response status should be 400