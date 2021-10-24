package com.cartaxcheck.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features="classpath:features",
        glue={"com.cartaxcheck.stepdefs"}
)

public class CucumberRunner {
}
