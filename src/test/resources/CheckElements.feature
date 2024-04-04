Feature: Check Elements on Home Page

  #Not Implemented
  Scenario: Check elements under Transform Your Risk Decision section
    Given I am on LexisNexis home page
    When I check the below element
      #financial services
      |fs|
      #insurance
      |insurance|
      #life and pensions
      |life|
      #coroporations and nonprofits
      |bnp|
    Then The status of the element is verified

    #Not Implemented
  Scenario: Check elements under Choose Your Industry section
    Given I am on LexisNexis home page
    And I have opened choose your industry tab
    And I have opened financial services section
    When I check the below element
    |financial-crime-compliance|
    |fraud-and-identity-management|
    |customer-data-management|
    |credit-risk-assessment|
    |collections-and-recovery|
    |tracing-and-investigations|
    Then The status of the element is verified

