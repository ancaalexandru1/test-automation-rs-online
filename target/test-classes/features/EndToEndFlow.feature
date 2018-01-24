Feature: End To End Flows
  As a new customer
  I want to add several products to my basket
  So that I can complete a new order

  Scenario: Successfully adding products to the basket after checking stock levels
    Given I am on the Home page
    When I click on 'New products' link
    And I click on a product from the list
    And I click on Add to basket after checking stock levels
    Then I Should see My basket form
    And I should see Clear All products and Update buttons
    And I Should see Checkout securely button

  Scenario: Successfully removing products from the basket after selecting a top branded product
    Given I am on the Home page
    When I click on 'Our Brands' link
    And I select a brand from the list
    And I select a popular category
    And I select a product from the list and add it to basket
    And I click on View basket link
    And I click on Clear all products link
    Then My Basket Should Be Empty