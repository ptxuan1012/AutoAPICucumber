#Author: Lan Anh
@LoginUser
Feature: Login User Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have url and Method and request body
      | URL                         | RequestBodyName                   |
      | https://reqres.in/api/login | \\LoginApi\\LoginRequestBody.json |
    When I send request
    Then I check <StatusCode> correctly
    And The response returns token

    Examples: 
      | StatusCode |
      |        200 |

