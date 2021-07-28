Feature: Next CRM login functionality
  Agile Story: As a user, when I am on the Next CRM login page,
  I should be able to login with correct username and password.

  Scenario Outline: User login verification
    Given User is on NextBase login page
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

