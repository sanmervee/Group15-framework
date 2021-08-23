@group15
Feature: Next CRM send poll feature

  Scenario: Creating a pool with the message" The message title is not specified
      ##users get error message "The message title is not specified"
      # when they are trying to create a poll without poll title (negative )
      #3. users check "allow multiple Choice" while create a poll
      #4. users can add more questions to a poll
      #5. users are able to cancel creating a poll
    Given User is on NextBase login page
    When User enters "helpdesk29@cybertekschool.com" and "UserUser"
    And the user clicks on the poll from dashboard and enters following info

      | message  |                  |
      | question | winter or summer |
      | answer1  | winter           |
      | answer2  | summer           |


    Then the user sees "The message title is not specified" on the dashboard