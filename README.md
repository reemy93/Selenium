# Selenium
# WibbitzHub

the project purpose is to automate the wibbitz website 

## overview

These instructions will lead you to create a similar Project . 

there is documentation for every step in the code .


### Prerequisites

you need to Install :

*java - 

go to google.com > search : java jdk download 
enter Oracle.com link 
download JDK

*eclipse / other editor - 

go to google.com > search eclipse download 
download the latest version 

*Testng -

go to google.com > search : testng download 
click on testng.org 
click on eclipse above 
click on installation

*Maven ( not nessecary )  -

and last > search : testng plugin installation 
this will allow the interface with maven 


### Break down into end to end tests

* implicit wait is defined ( 15 sec meximum time ) , i chose this number because sometimes it takes a lot of time for the website to upload everythind 

the testcases : 

*test cases are in class Reemy - WibbitzHub/src/test/java/rahulshettyacademy/Mavenjava/Reemy

Main testcase is the Login procedure 
clicks on Templates and picks the first video and plays it 
closes the video 

MoveTo method :goes to Social Media category > clicks on 'Quote of the day' video > 
closes the video after it's complete 

Intercom test : depends on main methos , it's included in the testng2.xml only 
clickson intercom button > switches to intercom frame > types 'hello' in the text-box and sends it > 
waits for response and prints the first message that we recieve from the intercom then closes the intercom frame 

checkList method : goes to 'Home' page > clicks on 'All Formats' checkList > uncheckes the first checkbox 'Landscape' 
> verifies that the checkbox is unchecked by using softAssert > clicks on apply 

SignOut method : chlicks on   the user account button and signs out 

## Running the tests

right click on the testng.xml > run as Testng 

### notes

in the project there are two xml files : testng.xml , testng2.xml 
these files determine what to execute and what not to . 
in the testng.xml i exluded the 'Intercom' method :
for somereason the intercome in the website disapeared after running my test a few times , 
it seems like the intercom can respond a limited number of times . 

* i created this project yesterday as a part of my learning process in the selenium course and added the test cases to it ,
there might be dead classes\code . sorry :) 
 
 
## Built With

*[Eclipse](https://www.oracle.com/) - Editor

*[Maven](https://maven.apache.org/) - Dependency Management

*[Testng] ( https://testng.org/doc/download.html)

*[Testng plugins] ( https://testng.org/doc/maven.html)


## Author

* **Reemy Naseraldden** 

