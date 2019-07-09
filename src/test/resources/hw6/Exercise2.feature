@run
Feature: Exercise02

  Scenario: User Table Page test
    Given I am on the JDI Index Page
    And I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'

    When I click Service subcategory in 'HEADER_SECTION' menu
    And I click User Table in Service dropdown
    Then page title should be 'User Table'
    And '6' 'TYPE_DROPDOWNS' are displayed on Users Table on User Table Page
    And '6' 'USER_NAMES' are displayed on Users Table on User Table Page
    And '6' 'DESCRIPTION_IMAGES' are displayed on Users Table on User Table Page
    And '6' 'DESCRIPTION_TEXTS' are displayed on Users Table on User Table Page
    And '6' 'CHECKBOXES' are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number | User             | Description                       |
      | 1      | Roman            | Wolverine                         |
      | 2      | Sergey Ivan      | Spider Man                        |
      | 3      | Vladzimir        | Punisher                          |
      | 4      | Helen Bennett    | Captain America\nsome description |
      | 5      | Yoshi Tannamuri  | Cyclope\nsome description         |
      | 6      | Giovanni Rovelli | Hulk\nsome description            |
    When I select vip checkbox for 'Sergey Ivan'
    Then 1 log line has "Vip: condition changed to 'true'" text in log section
    When I click on dropdown in column Type for user 'Roman'
    Then 'Roman' droplist contains values
      | Admin   |
      | User    |
      | Manager |
