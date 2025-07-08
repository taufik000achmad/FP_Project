@cart
Feature: Cart

  @add-to-cart
  Scenario: User add to cart product
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click product Nokia lumia1520
    And User click button add to cart
    Then User able to see warning popup "Product added."

  @delete-cart
  Scenario: User delete cart product
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click product Iphone632gb
    And User click button add to cart
    And User click button ok
    And User click menu cart
    And User click button delete
    Then User success delete product

  @checkout
  Scenario: User checkout product
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click product HTC OneM9
    And User click button add to cart
    And User click button ok
    And User click menu cart
    And User click button place order
    And User input name with "zilong"
    And User input country with "Indonesia"
    And User input city with "Bandung"
    Then User input credit card with "123456xxxc7890"
    And User input month with "08"
    And User input year with "2027"
    And User click button purchase
    Then User able to see alert popup "Thank you for your purchase!"

  @cancel-checkout
  Scenario: User cancel checkout
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click product HTC OneM9
    And User click button add to cart
    And User click button ok
    And User click menu cart
    And User click button place order
    And User click button close checkout
    Then User is on Cart page

  @empty-data-checkout
  Scenario: User Checkout with empty data order
    Given User doing login with "zilong123" and "123"
    When User is on homepage
    And User click product HTC OneM9
    And User click button add to cart
    And User click button ok
    And User click menu cart
    And User click button place order
    And User click button purchase
    Then User able to see warning popup "Please fill out Name and Creditcard."


