# language: en
Feature: Test setup
	Sets up the required connections

@setup
Scenario: Setup connnections
	Given set up connections "http://localhost:8080/", "localhost:3306?databaseName=lportal&user=root&password=root"

