Feature: Subscribe Newsletter

Scenario: Newsletter subscription
Given Initialize the browser with chrome
And Navigate to "https://staging.thecollective.com/" Site
And Enter Email id in Newsletter section
When Click on submit button
Then Verify that "Thank you for signing up." displayed
And close browsers








