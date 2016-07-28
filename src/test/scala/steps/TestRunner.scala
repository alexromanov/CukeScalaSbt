package steps

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
  * Created by aleksandr on 13.07.16.
  */
@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("classpath:features"),
  glue = Array("classpath:steps"),
  tags = Array("@wip"),
  plugin = Array("pretty", "html:target/cucumber/test-report.html")
)
class TestRunner{

}
