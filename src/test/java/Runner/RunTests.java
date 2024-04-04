package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//NOT IMPLEMENTED
@CucumberOptions(tags="",features = {"src/test/resources/Features/CheckElements.feature"},
        glue={"StepDefinitions"})
        //plugin={"pretty","html:target/htmlreport.html"})
public class RunTests extends AbstractTestNGCucumberTests {
}
