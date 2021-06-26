Feature: Count Characters

  i as writer want count characters for know
  the number of characters that have the words

  Scenario: Count characters of a word

    Given I want count characters

    When Count the characters of the word Mother

    Then Should see that the number of characters is 6

  Scenario: Count characters of a list of word

    Given I want count characters

    When Count the characters of list
      | Mother |
      | Father |

    Then Should see that the number of characters is 12