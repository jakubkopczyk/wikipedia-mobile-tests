Feature: Test the entire app
  Scenario: Successful Home Page loading
    Given I am launching the application
    When the app is done loading
    Then I can see specific elements on Home Page

  Scenario: Open Featured article
    Given I am on Home Page
    When I tap on first Featured article
    Then Featured article with same title is opened

    Scenario: Open news
      Given I am on Home Page
      When I open first news
      Then News with same title is opened

    #Scenario: Open Trending Article
     # Given I am on Home Page
     # When I tap on first Trending article
     # Then Trending article with same title is opened

   Scenario: Open Side menu
      Given I am on Home Page
      When I tap on hamburger menu button
      Then Side menu with specific options is opened


