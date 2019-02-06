package com.todo.webApplication.todo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionMapper {
	
	BusinessLogicOfStepDefinition baseMethod = new BusinessLogicOfStepDefinition();
	@Given("^Am hitting retrive all user api$")
	public void am_hitting_retrive_all_user_api() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseMethod.RetriveUsers();
	}

	@When("^api response is (\\d+) ok$")
	public void api_response_is_ok(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^print list of created user$")
	public void print_list_of_created_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Given("^Am hitting post api to create user$")
	public void am_hitting_post_api_to_create_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		baseMethod.CreateUser();
	}

	@When("^api response is (\\d+) created$")
	public void api_response_is_created(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^user created successfully$")
	public void user_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}


}
