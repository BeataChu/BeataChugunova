@run
Feature: Home Page and Different Elements Page functions

  Scenario: Open home page
    Given I am on the JDI Index Page
    Then page title should be 'Home Page'


    When I login as 'epam'/'1234'
    Then User name should be 'PITER CHAILOVSKII'
    # TODO Home page ;) - fixed
    And Home Page should contain all necessary elements
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
    # TODO there - it is where? - fixed
    And there should be 'LOG_SECTION' in Different Elements page
    And there should be 'LEFT_SECTION' in Different Elements page
  # TODO It will be better to add page where these elements exist - fixed
    When I select checkbox 'WATER' in Different Elements page
    # TODO What do you mean under the 'corresponding log line'?  - ссответствующая строка лога. Вполне себе логично звучит, имхо
    Then for a clicked checkbox 'WATER' there should be a corresponding log line

    When I select checkbox 'WIND' in Different Elements page
    Then for a clicked checkbox 'WIND' there should be a corresponding log line

    When I select radio button 'SELEN' in Different Elements page
    Then for a clicked radio button 'SELEN' there should be a corresponding log line

    When I select dropdown item 'YELLOW' in Different Elements page
    Then for a clicked dropdown item 'YELLOW' there should be a corresponding log line

    When I unselect checkbox 'WATER' in Different Elements page
    Then for a clicked checkbox 'WATER' there should be a corresponding log line

    When I unselect checkbox 'WIND' in Different Elements page
    Then for a clicked checkbox 'WIND' there should be a corresponding log line


