# AppiumCucumber
Sample Appium test automation for calculator

## Pre-requisites
* Appium 1.7
* Java 8
* Maven
* IDE with Cucumber Plugin installed


## Project Structure
* Configuration package - Hooks and API Processor
* Runners - Cucumber Runner Test
* Screens - Page Classes with Page Actions defined
* Step Definitions - Screen and its Steps Defs.
* Features - cucumber features

## Dependencies
* Appium Java Client
* Cucumber JVM
* Cucumber Java


## Test Execution
$ git clone https://github.com/sam20487/AppiumCucumber.git
$ `mvn clean install

## Points to note before running the test cases
* Need to start Appium server Manually (url : https://0.0.0.0:4327)
* Configure the \src\test\resources\deviceconfig.properties file to point to specific device
* App Launched is handled at Before Hooks

## To run the docker file 
* Clone the git repo on your local machine by using git clone command: git clone https://github.com/sam20487/AppiumCucumber.git
* Build a docker image using the Dockerfile.


