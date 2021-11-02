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
$ `mvn clean install

## Points to note before running the test cases
* Need to start Appium server Manually (url : https://0.0.0.0:4327)
* Configure the \src\test\resources\deviceconfig.properties file to point to specific device
* App Launched is handled at Before Hooks


