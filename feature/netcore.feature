Feature: Netcore_Automation_Task

  @tag1
  Scenario Outline: Automationcode|netcore
  
    Given Navigate to the flipkart
    When Search for iphone
    Then capture the details in CSV format

    Examples: 
      
      | Flipkartwebsite |     
      |https://www.flipkart.com/ | 

      