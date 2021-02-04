Feature: Careers page validation

  Scenario Outline: check whether Canada TradeRev career page is displayed properly
    Given user launch the traderev "traderevUrl" application
    When user navigates to Careers page
    Then verify Careers page displayed with "<Titles>" properly
    And user clicks Canadian Opportunities
    Then verify Canadian Opportunity page displayed with "<Labels>" properly
    And close browser
	Examples:
	|Titles				| Labels 	|
	|YOU FOUND US.,START-UP ATTITUDE. BIG COMPANY FUEL.,SPEED. SWAGGER. SERVICE.,TRADEREV MAKING HEADLINES|LOCATION,TEAM,WORK TYPE|
	
	 Scenario Outline: check whether job filter (city) is working properly
    Given user launch the traderev "traderevJobUrl" application
    When user filter the Search results by "City" "<citySearch>"
    Then verify all the job results displayed should belong to "<citySearch>" "City"
    And close browser
	Examples:
	|citySearch				|
	|Toronto, Ontario, Canada|
	
	 Scenario Outline: check whether job filter (city) and (team) is working properly
    Given user launch the traderev "traderevJobUrl" application
    When user filter the Search results by "City" "<citySearch>"
    And user filter the Search results by "Team" "<teamSearch>"
    Then verify all the job results displayed should belong to "<citySearch>" "City"
    Then verify all the job results displayed should belong to "<teamSearch>" "Team"
    And close browser
	Examples:
	|citySearch							 | teamSearch |
	|Toronto, Ontario, Canada| Engineering |
	