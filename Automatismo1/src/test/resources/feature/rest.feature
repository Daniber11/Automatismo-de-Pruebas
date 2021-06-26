Feature: Rest

  i as a mathematician want rest so
  as not to err in the calculation

  Scenario Outline: Rest integers numbers

    Given I want rest

    When rest <firstNumber> less <secondNumber>

    Then Should see that the result <result>

    Examples:
    |firstNumber|secondNumber|result|
    |4          |2           |2     |
    |2          |2           |0     |


