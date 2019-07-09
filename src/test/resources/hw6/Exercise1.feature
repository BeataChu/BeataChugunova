@run
Feature: Home Page and Different Elements Page functions

  Scenario: Open home page
    Given I am on the JDI Index Page
    Then page title should be 'Home Page'


    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    And home page should contain all necessary elements
      | GREEN_PICTURES       | 4 |
      | UNDER_GREEN_PICTURES | 4 |
      | CENTER               | 2 |

    When I click Service subcategory in 'HEADER_SECTION' menu
    Then 'HEADER_SECTION' dropdown list should have 'SUPPORT,DATES,COMPLEX TABLE,SIMPLE TABLE,TABLE WITH PAGES,DIFFERENT ELEMENTS' items

    When I click Service subcategory in 'LEFT_SECTION' menu
    Then 'LEFT_SECTION' dropdown list should have 'SUPPORT,DATES,COMPLEX TABLE,SIMPLE TABLE,TABLE WITH PAGES,DIFFERENT ELEMENTS' items

    When I click Service subcategory in 'HEADER_SECTION' menu
    And I click Different Elements in Service dropdown
    Then page title should be 'Different Elements'
    And Different Elements page should contain all necessary elements
      | CHECKBOXES    | 4 |
      | RADIO_BUTTONS | 4 |
      | DROPDOWN      | 1 |
      | BUTTONS       | 2 |
    And there should be 'LOG_SECTION'
    And there should be 'LEFT_SECTION'

    When I select checkbox 'WATER'
    Then for a clicked checkbox 'WATER' there is a corresponding log line

    When I select checkbox 'WIND'
    Then for a clicked checkbox 'WIND' there is a corresponding log line

    When I select radio button 'SELEN'
    Then for a clicked radio button 'SELEN' there is a corresponding log line

    When I select dropdown item 'YELLOW'
    Then for a clicked dropdown item 'YELLOW' there is a corresponding log line

    When I unselect checkbox 'WATER'
    Then for a clicked checkbox 'WATER' there is a corresponding log line

    When I unselect checkbox 'WIND'
    Then for a clicked checkbox 'WIND' there is a corresponding log line


