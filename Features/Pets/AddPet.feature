@addPet

Feature: Add Pet

  @Test1
  Scenario Outline: Add a new pet with valid requestBody
    Given Add Pet API
    When user hits add pet endpoint with valid requestbody having id "<id>" and payload "<payload>"
    Then user gets statusCode 200
    And status field in response should be "<status>"
    Examples:
      | id | status    | payload |
      | 0  | available | AddPet  |