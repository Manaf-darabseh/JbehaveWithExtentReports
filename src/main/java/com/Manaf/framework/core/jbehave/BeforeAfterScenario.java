package com.Manaf.framework.core.jbehave;

import static com.Manaf.framework.driver.DriverManager.getDriver;
import static com.Manaf.framework.driver.DriverManager.quitDriver;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.ScenarioType;

import com.Manaf.framework.driver.DriverManager;

public class BeforeAfterScenario {

    @BeforeStories
    public void beforeStories() {

    }
    @BeforeScenario(uponType = ScenarioType.ANY)
    public void beforeScenario() {
        if(getDriver() == null) {
            DriverManager.startDriver();
            getDriver().manage().deleteAllCookies();
        }
    }

    @AfterScenario(uponType = ScenarioType.ANY)
    public void afterScenario(){
        if(getDriver() != null) {
            quitDriver();
        }
    }

    @AfterStories
    public void tearDown() {

    }
}
