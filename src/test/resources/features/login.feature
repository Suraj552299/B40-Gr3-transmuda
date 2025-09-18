@login
Feature: Users should be able to login
  User Story:
  As a user (Sales and Store manager), I should be able to select any vehicle  from the Vehicles page (web table)

  Background: User is already in the log in page
    Given the user is on the login page

  @wip
  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"  as "<userpassword>"

    Examples: search values we are going to use

      | userType        | userpassword |
      | storemanager59  | UserUser123  |
      | salesmanager109 | UserUser123  |

  #Scenario Outline: Verify login with different user types
   # Given the user logged in as "<userType>"  as "<userpassword>"
    #When user can check the first checkbox to select all the cars
  #  Then user can select any car
    #Examples: search values we are going to use



