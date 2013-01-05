Given /^I am on the new article page$/ do
  visit new_article_path
end

When /^I fill in "(.*?)" with "(.*?)"$/ do |field, value|
  fill_in field, with: value
end

Then /^I should be on the new articles show page$/ do
  current_path.should == article_path(Article.last)
end

Then /^I should see "(.*?)"$/ do |content|
  page.should have_content(content)
end

Given /^an article exists$/ do
  @article = Article.create!(title: "Some Title", content: "Some Content")
end

When /^I go to the articles show page$/ do
  visit article_path(@article)
end

When /^I click the "(.*?)" link$/ do |link|
  click_link link
end

When /^I click the "(.*?)" button$/ do |button|
  click_button button
end
