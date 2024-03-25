Feature: Purchase the order from Ecommerce Website

Background:
Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with <username> and <password>
    When I add product <productName> to Cart
    And Checkout <productName>  and submit the order
    Then "Thankyou for the order." message is displayed on ConfirmationPage

    Examples: 
      | username                  |  password       | productName |
      | mihail.durnea98@gmail.com |  MihailDurnea98 | ZARA COAT 3 |