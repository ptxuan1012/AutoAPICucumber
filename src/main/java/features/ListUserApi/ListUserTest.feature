#Author: Lan Anh
@ListUser
Feature: List User Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have url and Method and request body
      | URL                                |
      | https://reqres.in/api/users?page=2 |
    When I send request
    Then I check <StatusCode> correctly
    And I check page number correctly

    Examples: 
      | StatusCode |
      |        200 |
