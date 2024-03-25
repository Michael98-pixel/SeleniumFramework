Feature: Error Validation
  
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with <username> and <password>
    Then "Incorrect email or password." message is displayed

     Examples: 
      | username                  |  password       | 
      | mihail.durnea98@gmail.com |  MihailDurea98  |  