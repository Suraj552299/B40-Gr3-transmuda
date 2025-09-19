@wip @accounts
Feature: Accounts header filters
  As a Store or Sales manager
  I should see 8 filter items on Accounts page

  Background:
    Given user is on transmuda login page

  Scenario Outline: Verify 8 filters and their names
    When user logs in with "<username>" and "<password>"
    And user navigates to Customers and Accounts
    Then user should see 8 filters in header
    And filter names must be
      | Account Name  |
      | Contact Name  |
      | Contact Email |
      | Contact Phone |
      | Owner         |
      | Business Unit |
      | Created At    |
      | Updated At    |

    Examples:
      | username         | password    |
      | salesmanager113  | UserUser123 |
      | storemanager99   | UserUser123 |
