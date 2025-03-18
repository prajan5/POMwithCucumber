Feature: Login LeafTaps Application with vaild data

#common line for all the scenario
#Background:
#Given Launch the Browser and Load the Url 

@smoke @dilip @cucumber
Scenario: Login with Positive Value
When Enter the username as 'DemoSalesManager'
And Enter the passWord as 'crmsfa'
And Click on Login Button
Then Verfiy the login is Successful


Scenario: Login with Positive Value
When Enter the username as 'DemoCsr'
And Enter the passWord as 'crmsfa'
And Click on Login Button
Then Verfiy the login is Successful
