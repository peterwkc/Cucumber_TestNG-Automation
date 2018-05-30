@Login_Valid
Feature: Login to Volare Collector
Description:  As a user, I want login to Volare Collector 

  Scenario: Valid Login
    Given Volare Collector Home Page opens in browser
    When I login to Volare Collector with Username and Password
    Then Page navigate to Volare Collector Home Page

