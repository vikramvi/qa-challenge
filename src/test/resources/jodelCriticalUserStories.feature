Feature: Verify Jodel Android App related critical user stories

Scenario: Verify user can input message
Given App is in active state
When  User taps on Post Message Icon
Then  User can input text inside message input area

Scenario: Verify user can goto Trending page
Given App is in active state
When  User taps on Trending Today
Then  User is taken to Trending Today page

Scenario: Verify user can goto MyKarma page
Given App is in active state
When  User taps on MYKARMA Score
Then  User is taken to MYKARMA page

Scenario: Verify user can goto Channel page
Given App is in active state
When  User taps on Channels Icon
Then  User is taken to Channels page
