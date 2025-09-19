Feature: As a user, I should see error messages when I enter an invalid integer number into the calendar Repeat Every input box.

 @invalid
  Scenario Outline: Verifications of invalid integers
    Given the user logged in as "<userType>"
    And the user navigates to "Activities" and "Calendar Events"
    And the user clicks create calendar events link
    Then the user checks Repeat checkbox
    And the user enters -1 into the input  box
    Then user should see "The value have not to be less than 1."
    And user enters 111 into the input box
    And user should see "The value have not to be more than 99."

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |
