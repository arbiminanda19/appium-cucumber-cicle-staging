package runner;

import helper.requestAPI;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDef",
        plugin = "html:target/HTML_report.html"
)
public class runAll {

    static requestAPI requestAPI = new requestAPI();
    @AfterClass
    public static void afterAll() {
        String companyId = requestAPI.getCompanyId();
        requestAPI.deleteCompany(companyId);
    }

}
