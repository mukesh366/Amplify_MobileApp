Feature: General-Store.apk – Appium Automation Test case


Scenario Outline: General-Store.apk – Appium Automation Test case


Given Launch the General-Store.apk in an emulator
When Select the country "<country>"
And Enter  "<Name>" in name field
Then Select gender: female
Then Press the Let’s Shop button
And  Select the first two items in the list: 
Then Tap the shopping cart icon
And Validate that the Total Purchase Amount is equal to the two prices added together.



Examples:
          |country                    |Name |
          |Argentina                  |Hello|


