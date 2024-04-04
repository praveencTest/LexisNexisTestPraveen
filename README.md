**Automation Exercise for verifying elements in https://risk.lexisnexis.co.uk/**

Project Configuration Steps
- created a new mvn project in intellij IDE
- added required dependcies for selenium, cucumber, testng
- added a base class where webdriver and exntent reporting get initialized under setup and tear down section using testng annotations
- created a homepage pageboject in order to set required elements and actions used on this page
- created two tests under 'verifyelements' (src->test->java) folder with @test annotations which is recognised by testng as runnable tests
- test name 'TransformYourRiskDecisionMakingSection' verifies required elements are present and clickable as per the requirement under this section
- test name 'ChooseYourIndustrySection' verifies required elements are present and clickable as per the requirement under this section
- Extent reporting added to capture html reporting
- Screenshot method used to capture the screenshot incase of any failures

Test Execution:
- Although Cucumber feature file added, due to lack of necessary depenedcy files and lack of full integration with base calss and due to conflict with testng annottations,
  cucumber feature file could not be executed
 - The above can be resolvable but requires spending more time on cucumber runner file
 - Please execute using testng.xml file either in Intellij or in commandline
 - Steps to execute
    - open command line and go to project folder and run mvn test
    - OR open project in Intellij IDE and right click on testng.xml and run it
    - After execution got Reporting folder and latest html report can be seen
  
Note:
   There can be lot of improvement done on this but due to time limit only this could be achieved.


