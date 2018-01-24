Feature: Search
  As a new customer
  I want to be able to search for different products, using different search criteria

  Scenario: Successfully searching for products by brand
    Given I am on the Home page
    When I search for a product by brand
    Then Products from the specified brand should be retrieved

  Scenario: Successfully searching for products by Mfr. Part No.
    Given I am on the Home page
    When I search for a product by Mfr. Part No.
    Then Product Details Page With The Specified Mfr. Part No. Should Be Opened

  Scenario: Successfully searching for products by RS Stock No.
    Given I am on the Home page
    When I search for a product by RS Stock No.
    Then Product Details Page With The Specified RS Stock No. Should Be Opened