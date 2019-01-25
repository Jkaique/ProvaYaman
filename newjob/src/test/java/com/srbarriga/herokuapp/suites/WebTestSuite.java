package com.srbarriga.herokuapp.suites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Jheferson Kaique
 * @data 24.01.2019
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", tags = "@jheferson_oliveira", 
glue = "com.srbarriga.herokuapp.web", monochrome = true, dryRun = false)
public class WebTestSuite {

}
