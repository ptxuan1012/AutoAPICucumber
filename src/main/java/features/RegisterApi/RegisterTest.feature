#Author: Lan Anh
@RegisterUser
Feature: Register User Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have "<URL>" and Method and "<RequestBody>"
    When I send register user request
    Then I check <StatusCode> of register api correctly

    Examples: 
      | URL                            | StatusCode | RequestBody                             |
      | https://reqres.in/api/register |        200 | //RegisterApi//RegisterRequestBody.json |
