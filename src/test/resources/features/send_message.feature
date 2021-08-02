@wip
Feature: As a user, i should be able to send message.
  AC: 1- Verify users can send message clicking message tab
  2- Verify users can cancel messages
  3- Verify users can attach link by clicking on the link icon.


  Scenario Outline: Sending a message
    When User login with "<username>" and "<password>" and user is on Dashboard page
    And user click message tab and send a message "Hi Saim" and click send button
    Then user should be able to send the message "Hi Saim"
    Then user should be able to cancel the message

    Examples:
      | username                       | password |
      | helpdesk29@cybertekschool.com  | UserUser |
      | helpdesk30@cybertekschool.com  | UserUser |
      | marketing29@cybertekschool.com | UserUser |
      | marketing30@cybertekschool.com | UserUser |
      | hr29@cybertekschool.com        | UserUser |
      | hr30@cybertekschool.com        | UserUser |


  Scenario Outline: Sending a message with link attached
    When User login with "<username>" and "<password>" and user is on Dashboard page
    And user click message tab and send a message "Hi Murodil" and click add link button and send link name "amazon" and send link address "https://www.amazon.com" and click save button and click send button
    Then user should be able to send the message "Hi Murodil" with a link "amazon"
    Then user should be able to cancel the message

    Examples:
      | username                       | password |
      | helpdesk29@cybertekschool.com  | UserUser |
      | helpdesk30@cybertekschool.com  | UserUser |
      | marketing29@cybertekschool.com | UserUser |
      | marketing30@cybertekschool.com | UserUser |
      | hr29@cybertekschool.com        | UserUser |
      | hr30@cybertekschool.com        | UserUser |
