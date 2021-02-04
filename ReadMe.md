#How to run BDD tests

Running Steps:
1. clone the git project to your local
2. import to your local IDE as a Maven Existing Project
3. update the maven project
4. make sure 'TestNG' and 'Cucumber' plugins are added to your IDE
5. run with TestNGSuite from 'testngCucumber.xml'

Verify Results:
1. test-output -> ExtentReportsTestNG, inex.html

Preparations
Running tests on a local machine requires Selenium Drivers to be installed. The canonical way is to put the drivers in the PATH. The other way is to specify webdriver.<browser>.driver property (see below).

Download Selenium Web drivers for:

Chrome: https://chromedriver.chromium.org/downloads
Firefox: https://github.com/mozilla/geckodriver/releases
Please make sure that version of the driver matches version of your browser engine. Put the driver into some folder.

After checking out the project form Github, check data.properties file will contain your local environment settings.

Understanding tests running modes
Testing platform supports two "local" modes for test running:

In-process mode, when webdrivers run on the machine where the tests are run. This is convenient for development and debugging.
Server mode, when tests operate browsers through the Selenium Server. This mode is useful when it's, for example, tests run on Linux and the target browser is MS Edge. In this case Selenium Server should be run in on Windows host.
For Server mode, please obtain Selenuim server from here: https://selenium-release.storage.googleapis.com/3.141/selenium-server-standalone-3.141.59.jar Copy, edit and run-selenium-server.sh.template shell script template to run the the Standalone Server.

Running Tests via Maven
By default, all tests will be run against the local Extractor App, so you need to have it running.

To run all tests: mvn clean verify

To run tests: 
testngCucumber.xml
mvn clean verify -Dtest=TestClassName

See Maven Surefire plugin documentation about avaliable options. https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html

Running specific Tests in the IDE
Running individual tests in the IDE is a preferred and recommended way for developers to write feature tests in the context of tickets. In this case it's much easier to debug the test because Surefire plugin makes a JVM fork. So usual debugging tools will not be available in this mode.

Known Problems
Tests may fail randomly becausof various reasosn. If some test tails in the batch, rerun this test separately using -Dtest=TestName.