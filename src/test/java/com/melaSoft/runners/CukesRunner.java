package com.melaSoft.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-html-reports.html",
                "pretty"
        },
        features = "src/test/resources",
        glue = "com/melaSoft/stepDefs",
        dryRun = false,
        tags = "@wip"

)

public class CukesRunner {
}
