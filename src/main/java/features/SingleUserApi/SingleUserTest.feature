#Author: Lan Anh
@SingleUser
Feature: Single User Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have "<URL>" and Method
    When I send list user request
    Then I check <StatusCode> correctly
    And I check user id correctly

    Examples: 
      | URL                           | StatusCode |
      | https://reqres.in/api/users/2 |        200 |
