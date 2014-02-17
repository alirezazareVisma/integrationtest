# language: en
Feature: Test cleanup
	Closes connections
  
@cleanup
Scenario: Close connections
	Then close database connections