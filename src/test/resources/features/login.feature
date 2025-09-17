@login
Feature: Users should be able to login
  User Story:
  As a user (Sales and Store manager), I should be able to select any vehicle  from the Vehicles page (web table)

  Background: User is already in the log in page
    Given the user is on the login page

  @wip
  Scenario Outline: Verify login with different user types
    Given the user logged in as "<userType>"  as "<userpassword>"
    #Given the user logged in with username as "User1" and password as "UserUser123"
   # Given the user logged in with username as "storemanager51" and password as "UserUser123"
    #Given the user logged in with username as "salesmanager101" and password as "UserUser123"


    Examples: search values we are going to use

      | userType        | userpassword |
      #| User10          | UserUser123  |
      | storemanager59  | UserUser123  |
      | salesmanager109 | UserUser123  |



