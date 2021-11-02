package com.test.stepdefinitions;

import com.test.Configurations.FlickrAPIProcessor;
import com.test.screens.CalculatorScreen;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CalculatorSteps {

	CalculatorScreen searchScreen= new CalculatorScreen();
    
        
    @When("^I go to the calculator application$")
    public void i_go_to_the_calculator_application() throws Throwable {
    	
    	// App is launched at Before hook here just checking the title once app is launched
        String title= searchScreen.appLaunched();
        System.out.println("Calculator App Launched  "+title);
        
    }
    
    @When("^I type \"([^\"]*)\" in the input field$")
    public void i_type_in_the_input_field(String arg1) throws Throwable {
     
    	searchScreen.ClickWholeEquation(arg1);
    }
    

    @When("^I click \"([^\"]*)\" button$")
    public void i_click_button(String arg1) throws Throwable {
    	
        char c= arg1.charAt(1);
    	searchScreen.ClickElement(c);
    }

    @Then("^\"([^\"]*)\" result is displaying in the result field$")
    public void result_is_displaying_in_the_result_field(String arg1) throws Throwable {
        
    	Thread.sleep(1000);
    	String res= searchScreen.getResult();
    	// here just printing output , can validate with assert statements
    	System.out.println("Result = "+res);
    	
    }
    
    @Then("^\"([^\"]*)\" red validation message appears in the result field$")
    public void red_validation_message_appears_in_the_result_field(String arg1) throws Throwable {
      
    	String msg= searchScreen.errorMsg();
    	// here just printing output , can validate with assert statements
    	System.out.println("Result = "+msg);
    	Thread.sleep(1000);
    	searchScreen.clearScreen();
    }
    
    @When("^I type \"([^\"]*)\"$")
    public void i_type(String arg1) throws Throwable {
        
    	searchScreen.ClickWholeEquation(arg1);
    }
}
