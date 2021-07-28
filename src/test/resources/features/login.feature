Feature: Next CRM login functionality
  Agile Story: As a user, when I am on the Next CRM login page,
  I should be able to login with correct username and password.

  Background: Assuming user is on the login page
    Given User is on NextBase login page

  Scenario Outline: User login verification
    When User enters "<username>" and "<password>"
    Then User should see Dashboard Page

    Examples:
      | username                       | password |
      | helpdesk29@cybertekschool.com  | UserUser |
      | helpdesk30@cybertekschool.com  | UserUser |
      | marketing29@cybertekschool.com | UserUser |
      | marketing30@cybertekschool.com | UserUser |
      | hr29@cybertekschool.com        | UserUser |
      | hr30@cybertekschool.com        | UserUser |

Scenario: login with wrong credentials
  When User enters "username" and "password"
  Then user should be able to see the error message

  Scenario: checking remember me button
    And user should be able to check remember me checkbox

    Scenario: accessing forgot password link
      And user should be able to access forgot password link