Feature: Create new posts

  Scenario Outline: Create new post
    Given User opens HomePage
    And User opens CreateNewPostPopUp
    When User types Headline "<headline>"
    And User selects media type "<media>"
    And User adds link on media or uploads it "<pathToFile>"
    And User selects Ad type "<ad type>"
    And User types Description "<description>"
    And User click on Create Envygram button
    Then New post is created
    Examples:
      | headline     | media               | pathToFile                                                  | ad type | description                      |
      | Best picture | Image From Computer | K:\Job\Testing\ScopicNew\src\main\resources\images\lego.jpg | Default | Really best picture in the world |

