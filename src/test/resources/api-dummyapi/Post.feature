@Post
Feature: Post

  @Success-post-data
  Scenario: User success post data
    Given The user API is available
    When User sends a POST request to create a user with:
      | firstName | Test    |
      | lastName  | User    |
      | email     | dynamic |
    Then The response create status should be 200
    And The email should contain the correct email

  @Post-with-same-email
  Scenario:User post with same email
    Given The user API is available
    When User sends a POST request to create a user with:
      | firstName | Test               |
      | lastName  | User               |
      | email     | leevi.savela@example.com |
    Then The response create status should be 400
    And The response body should contain error "BODY_NOT_VALID"
    And The response body should contain email message "Email already used"