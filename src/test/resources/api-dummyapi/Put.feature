@Put
Feature: Put

  @Success-put-first-name
  Scenario: User success put first name data
    Given The user API is available
    When User sends a PUT request to update the user with id "60d0fe4f5311236168a109d4" and the following data:
      | firstName | UpdatedName |
    Then The response status put should be 200
    And The response body should contain "UpdatedName" as "firstName"

  @Success-put-email
  Scenario: User success put email data
    Given The user API is available
    When User sends a PUT request to update the user with id "60d0fe4f5311236168a109d4" and email data:
      | email | updated.email@example.com |
    Then The response status put should be 200
    And The response body should contain the updated email

  @Put-wrong-id
  Scenario: User put with wrong id
    Given The user API is available
    When User sends a PUT request to update the user with id "Invalid132234511" and the following data:
      | firstName | UpdatedName |
    Then The response status put should be 400
    And The response body should contain error message "PARAMS_NOT_VALID"