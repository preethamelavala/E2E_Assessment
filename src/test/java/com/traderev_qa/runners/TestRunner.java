package com.traderev_qa.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/com/traderev_qa/features",
	    glue="com.traderev_qa.steps")

public class TestRunner extends AbstractTestNGCucumberTests  {

}
