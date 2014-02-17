#language: en
@it @manual
Feature: Authentication 
	Dummy feature to login and logout
	
	Scenario Outline: Invite and register a user
		
		Given user "<admin>" is logged in
		Then go to site "rijkshuisstijl"
		Then go to controle panel
		Then do something else using "test"
		Then logout

		Examples:
			| admin				| 
			| test@liferay.com	| 
