Feature: Create new posts

#  Scenario Outline: Create new post
#    Given User opens HomePage
#    And User opens CreateNewPostPopUp
#    When User types Headline "<headline>"
#    And User selects media type "<media>"
#    And User adds link on media or uploads it "<pathToFile>"
#    And User selects Ad type "<ad type>"
#    And User types Description "<description>"
#    And User click on Create Envygram button
#    Then New post is created
#    Examples:
#      | headline                   | media               | pathToFile                                                | ad type      | description                             |
#      | The best picture from PC   | Image From Computer | path included in my_script.exe                            | handwritting | Really the best picture in my PC        |
#      | The best image in Internet | Image From Internet | http://www.unoosa.org/res/timeline/index_html/space-2.jpg | Default      | Really the best picture in the Internet |
#      | The best Youtube Link      | Video Link          | https://youtu.be/P17h_JwzMuU                              | Default      | Really the best video in Youtube        |
#     #      | The best Envygram Link     | Envygram Link       | http://68.169.52.12/EnvyGram/html/olo/10643               | Default | Really the best picture in Envygram     |
#
#
#  Scenario Outline: Create new post with invalid data
#    Given User opens HomePage
#    And User opens CreateNewPostPopUp
#    When User types Headline "<headline>"
#    And User selects Ad type "<ad type>"
#    And User types Description "<description>"
#    And User click on Create Envygram button
#    Then Errors are appears "<errors>"
#    Examples:
#      | headline                 | ad type | description                             | errors                                                                                                    |
#      |                          |         |                                         | Headline cannot be blank., Media cannot be blank., Ad Type cannot be blank., Description cannot be blank. |
#      | The best picture from PC |         |                                         | Media cannot be blank., Ad Type cannot be blank., Description cannot be blank.                            |
#      | The best picture from PC |         | Really the best picture in the Internet | Media cannot be blank., Ad Type cannot be blank.                                                          |
#      | The best picture from PC | Default | Really the best picture in the Internet | Media cannot be blank.                                                                                    |
