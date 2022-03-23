# SysdigCoding

The above project is created for automating the sysdig login page as part of a coding challenge. This README file describes the structure of code, testcase validations and how to download and run this project.

Download and Install the project in your local.
1. Please go to the github url : https://github.com/karthiknagupalli/SysdigCoding.git
2. In your local ide i.e. either ecllipse or intellij, create a new project and import from the above git url.
3. Perform a Maven clean and a Maven Install
4. Build the project and it will be ready for execution.

Files
1. LoginTest.xml can be run as TestNG  which starts the exection of the testcases.
2. testData.properties file contains all the testing related data.
3. Utilities.Java file consists of all the java methods used for running the testcases.
4. Login.Java file contains all the testcases that are implemented.
5. Screenshots file consists of the screencaptures taken during test execution.
6. pom.xml consists of all the dependencies needed.

Right click on the LoginTest.xml and select Run as TestNG option to start the script and in the console all the logs can be viewed.

Below are the functionalities impelemented and the testcases added.
1. Open the Login URL.
2. Validating if all the elements are present on the Login Page.
3. Asserting the elements with text values on the Login page.
4. Store all the Xpaths, textNames, Placeholders in properties file and fetching them.
5. Adding a password encryption with Base64
6. Passing emmpty values and validating if the user is able to login.
7. Passing invalid values and validating if the user is able to login.
8. Taking screenshots for the invalid user login.


Things that can be accomplished if provided more time:
1. Add the API testcases also for the Login functionality.
2. Navigating to other pages.
3. Screenshot capturing for all the failed scenarios.
4. Adding more validations like invalid login with incorrect email format.
5. 3 party login validations.
