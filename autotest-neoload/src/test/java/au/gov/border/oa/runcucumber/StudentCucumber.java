package au.gov.border.oa.runcucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/" },
    glue = { "au.gov.border.oa.stepDefinitions" })
public class StudentCucumber
{
}
