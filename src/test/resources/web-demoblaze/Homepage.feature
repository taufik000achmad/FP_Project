@homepage
Feature: Homepage

  @slide-image
  Scenario: User see slide image 2
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click button slide
    Then User able to see second image

  @next-page
  Scenario: User see next page
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User scroll down
    And User click next page
    Then User is on next page

  @previous-page
  Scenario: User see previous page
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User scroll down
    And User click previous page
    Then User is on previous page

  @product-detail
  Scenario: User see detail product Nexus 6
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click product nexus6
    Then User able to see detail product Nexus6