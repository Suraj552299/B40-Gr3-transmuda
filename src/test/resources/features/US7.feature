@US7
Feature: Users should be able to select any vehicle  from the Vehicles page
  User Story:

  As a user (Sales and Store manager),
  I should be able to select any vehicle  from the Vehicles page (web table)

  #Background: User is already in the log in page
   # Given the user is on the login page

#--------------------AC #1------------------------------#
  @AC-1
  Scenario Outline:  Users launches on the Vehicles page,
  the users can see all the checkboxes as unchecked

    Given the user logged in as "<userType>"  as "<userpassword>"
    When user clicks on "Fleet" tab then "Vehicles" module
    Then user can see all the checkboxes as unchecked


    Examples: search values we are going to use

      | userType        | userpassword |
      | storemanager59  | UserUser123  |
      | salesmanager109 | UserUser123  |


    #-------------------------------AC#2---------------------------#

  @AC-2
  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"  as "<userpassword>"
    When user clicks on "Fleet" tab then "Vehicles" module
    Then user can check the first checkbox to select all the cars


    Examples: search values we are going to use

      | userType        | userpassword |
      | storemanager60  | UserUser123  |
      | salesmanager110 | UserUser123  |
    #----------------------------------AC #3------------------------------------#
  @AC-3

  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"  as "<userpassword>"
    When user clicks on "Fleet" tab then "Vehicles" module
    Then user can select any car

    Examples: search values we are going to use

      | userType        | userpassword |
      | storemanager65  | UserUser123  |
      | salesmanager115| UserUser123  |





