#Author: Pham Cong
@Breeds
Feature: Breeds Api Test

  @MainCase
  Scenario Outline: Check response when send request successfully
    Given I have url of breeds api
      | URL                                 |
      | https://api.thecatapi.com/v1/breeds |
    When I send breeds request
    Then I check <ExpectedStatusCode> of breeds api correctly

    Examples: 
      | ExpectedStatusCode |
      |                200 |
