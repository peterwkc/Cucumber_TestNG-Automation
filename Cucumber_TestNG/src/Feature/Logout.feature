@Logout_Valid
Feature: Logout from Volare Collector
Description:  As a user, I want login to Volare Collector 

Scenario: Valid Logout
	Given A user has login to Volare Collector
	When Click logout button
	Then Logout from Volare Collector and redirect to login page