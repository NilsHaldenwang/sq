Feature: managing articles

  In order to manage my articles
  As the owner of the application
  I want to be able to create and edit articles

  Scenario: Creating an article
    Given I am on the new article page
    When I fill in "Title" with "Some Title"
    And I fill in "Content" with "Some Content"
    And I click the "Create Article" button
    Then I should be on the new articles show page
    And I should see "Article was successfully created"

  Scenario: Editing an article
    Given an article exists
    When I go to the articles show page
    And I click the "Edit" link
    When I fill in "Title" with "New Title"
    And I fill in "Content" with "New Content"
    And I click the "Update Article" button
    Then I should be on the new articles show page
    And I should see "Article was successfully updated"
    And I should see "New Title"
    And I should see "New Content"

