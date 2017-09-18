Feature: Login with email

  Scenario: Login with valid credentials
    Given LandingPage is opened
    When User clicks Log in link
    And SignIn popup is loaded
    And User Signs in with login "olegmarket@gmail.com" and password "123456"
    Then HomePage is loaded

  Scenario Outline: Login with invalid data
    Given LandingPage is opened
    When User clicks Log in link
    And User Signs in with login "<login>" and password "<password>"
    Then Error message "<usernameError>" appears in username field
    And Error message "<passwordError>" appears in password field
    Examples:
      | login                | password   | usernameError | passwordError    |
      |                      |            | Required      | Required         |
      | olegmarket@gmail.com |            |               | Required         |
      | olegmarket@gmail.com | invalidPas |               | Invalid password |
      |                      | 123456     | Required      |                  |

  Scenario Outline: Login with invalid data, check another error message
    Given LandingPage is opened
    When User clicks Log in link
    And User Signs in with login "<login>" and password "<password>"
    Then Error message under login field "<errorMessage>" appears
    Examples:
      | login                 | password | errorMessage                            |
      | test                  | 123      | Please activate your account            |
      | unregistered@mail.com | 123      | You are not registered. Please register |