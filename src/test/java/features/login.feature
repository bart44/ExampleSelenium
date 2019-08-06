Feature: login into application

Scenario Outline: Positive test validating login

Given Init browser with Chrome
And Navigate to "https://the-internet.herokuapp.com/login" login page
When User enters <username> and <password> and logging
Then Verify login of user
And Close browsers

Examples: 
|username	|password				|
|tomsmith		|SuperSecretPassword!	|
|admin			|admin					|