package com.cartaxcheck.stepdefs;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import util.BeanLibrary;

@CucumberContextConfiguration
@SpringBootTest
@ContextConfiguration(classes= BeanLibrary.class)
@TestPropertySource(value={"classpath:application.properties"})
public abstract class BaseStep {
    protected void sleep(long inSecs){
        try {
            Thread.sleep(inSecs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
