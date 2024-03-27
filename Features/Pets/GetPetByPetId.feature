@getPetByPetId

Feature: Get Pet By Pet Id

  @Test2
  Scenario Outline: Get Pet By Valid Pet Id
    Given Pet Service
    When We hit getPetByPetId endpoint with valid id "<id>"
    Then We get statuscode 200
    And name field in response should be "<value>"
    Examples:
      | id | value  |
      | 1  | doggie |