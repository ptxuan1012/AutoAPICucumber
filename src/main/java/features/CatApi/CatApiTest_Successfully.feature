#Author: Pham Cong
@Cat
Feature: Cat Api Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have url and Method and request body
      | URL                                | RequestBodyName                  |
      | https://api.thecatapi.com/v1/votes | \\CatApi\\CatApiRequestBody.json |
    When I send request
    Then I check <StatusCode> correctly

    Examples: 
      | StatusCode |
      |        201 |
