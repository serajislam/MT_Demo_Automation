Feature: Find A Provider Page
  
  @Smoke
  Scenario Outline: Verify Find A Provider Page Functionality
  
    Given User should be on Montana Provider Portal Page
    When User Click On Find A Provider Hyperlink
    Then User select "<Category>" from Filter by Category dropdown
    Then User select "<Specialty>" from Filter by Specialty dropdown
    Then User enter "<City>"
    Then Click On Find providers
    
    Examples:
    |Category              ||Specialty               ||City  |
    |Dental Providers      ||Dental Hygienist        ||Helena|
    |Chiropractic Providers||Chiropractor            ||Missoula|
    