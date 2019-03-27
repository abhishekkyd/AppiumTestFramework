# AppiumTestFramework

Appium Test Framework for android mobile testing using Selendroid Test App

------------------------------------
Test Coverage
------------------------------------

1. As a guest user, I am able to enter the text in a text input field
2. As a guest user, I am able to register
3. As a guest user, I am able to view text message
4. As a guest user, I am able to view simple alert
5. As a guest user, I am able to view confirm alert


------------------------------------
Prequisites for System
------------------------------------

1. Java should be installed and configured.
2. Android should be installed and configured.
3. Appium client should be installed and configured.
4. Create an Android Emulator with name "MyAndroid".
5. Install TestNG in Eclipse or Java Editor which is in used.


------------------------------------
Prequisites before Test Execution
------------------------------------

1. Start Android Emulator with name "MyAndroid"
2. Start Appium Server at "http://127.0.0.1:4723"


------------------------------------
Steps to execute scripts
------------------------------------

1. Execute from command line:

    i) Open Terminal and CD to project root directory
    ii) To execute all test cases using TestNG, specify parameters in command line:
	
	<code>mvn clean test</code>

2. Execute from Eclipse:

	i) Go/Open project in eclipse. Right click and execute a TestNG suite.


------------------------------------
Reports
------------------------------------

Report: .\test-output\emailable-report.html
Screenshots: .\test-output
