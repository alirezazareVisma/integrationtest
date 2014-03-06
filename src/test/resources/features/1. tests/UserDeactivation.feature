#language: en
@it @manual
Feature: Deactivate user
  This feature is used to test user de-activation

  Scenario Outline: 
  	Login as admin and deactivate user
  	
    Given user "<admin>" is logged in
    When go to controle panel
    Then deactivate user "test.dlc.1@liferay.com"
    Then logout

    Examples: 
      | admin            |
      | test@liferay.com |
     