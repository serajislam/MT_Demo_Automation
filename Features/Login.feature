Feature: Login Page
  
  @Smoke @Regression
  Scenario Outline: Verify Login Page Functionality
  
    Given User should be on Montana Provider Portal Page
    When User Click On Provider
    Then User Click On Login and Registration
    Then User enter "<OptumGovID>" & "<Password>"
    Then User Click On Continue
    Then User Click On Via Text Message on Verify Your Identity page
    Then User enter Access Code "<AccessCode>"
    Then User Click On Continue
    Then User Click On Logout
    
    Examples:
    | OptumGovID               ||Password||AccessCode|
    | thelmakuhic0@getnada.com||Test!2025||902100|
    
    
    

    