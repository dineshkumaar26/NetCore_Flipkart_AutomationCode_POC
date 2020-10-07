package netcore;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\d.ravichandran\\Eclipse-Workspace\\New Workspace\\netcore\\feature\\netcore.feature",
        glue = {"support",
        		"stepdefinition"},
        plugin = {
                "de.monochromata.cucumber.report.PrettyReports:reporting/cucumber",
                "html:reporting/CucumberHTMLReports",
                "json:reporting/cucumberOtherreports/Cucumber.json",
                "junit:reporting/cucumber-reports/Cucumber.xml",
                "rerun:target/rerun.txt" //Creates a text file with failed scenarios
        },
        strict = false,
        tags = "@tag1"
)

public class CucumberRunner {
}
