package stepdefs;

import java.util.HashMap;

import org.testng.asserts.SoftAssert;

import common.Constants;
import common.Headers;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.FileUtils;

public class APITest {
	SoftAssert soft = new SoftAssert();
	
	
	@Given("user invoke the api for user")
	public Response user_invoke_the_api_for_user() {
		Response response = Headers.PostHeader(Constants.USER_URL);
		System.out.println(response);
	    return response;
	}

	@When("the user will get201 response")
	public void the_user_will_get201_response() {
		soft.assertTrue(String.valueOf(user_invoke_the_api_for_user().getStatusCode()).equals("201"));
		soft.assertAll(); 
	}

	@Then("user will see all the users")
	public void user_will_see_all_the_users() {
	    soft.assertEquals(user_invoke_the_api_for_user().getBody().jsonPath().get("name"), "Michael","success message not display");
	    soft.assertEquals(user_invoke_the_api_for_user().getBody().jsonPath().get("job"), "leader","success message not display");
	}
	
	@Given("user invoke the api for {string}")
	public Response user_invoke_the_api_for(String user) {
		Response response = Headers.GetHeader(Constants.USER_URL+user);
	    return response;
	}

	@When("the user will get200 response for users {string}")
	public void the_user_will_get200_response_for_users(String page) {
	   soft.assertTrue(String.valueOf(user_invoke_the_api_for(page).getStatusCode()).equals("200"));
	  // soft.assertAll();
	}

	@Then("user will see all the users {string}")
	public void user_will_see_all_the_users(String page) {
	  soft.assertEquals(user_invoke_the_api_for(page).getBody().jsonPath().getList("data").size(), FileUtils.getUsers().size(),"Success message is not display");
	  soft.assertEquals(user_invoke_the_api_for(page).getBody().jsonPath().getInt("page"),1,"Success message is not display");
	  soft.assertEquals(user_invoke_the_api_for(page).getBody().jsonPath().getInt("total_pages"),2,"Success message is not display");
	  soft.assertEquals(user_invoke_the_api_for(page).getBody().jsonPath().getInt("total"),12,"Success message is not display");
	  soft.assertEquals(user_invoke_the_api_for(page).getBody().jsonPath().getInt("per_page"),6,"Success message is not display");
	  
	  for(int i=0;i<FileUtils.getUsers().size();i++) {
		  
		  HashMap<String, Object> data = (HashMap<String, Object>)user_invoke_the_api_for(page).getBody().jsonPath().getList("data").get(i);
		  soft.assertEquals(data.get("id"),FileUtils.getUsers().get(i).getId(),"Success massege not displayed");
		  soft.assertEquals(data.get("email"), FileUtils.getUsers().get(i).getEmail(),"Success massege not displayed");
		  soft.assertEquals(data.get("first_name"), FileUtils.getUsers().get(i).first_name(),"success message not displayed");
		  soft.assertEquals(data.get("last_name"), FileUtils.getUsers().get(i).last_name(),"success message not displayed");
		  soft.assertEquals(data.get("avatar"), FileUtils.getUsers().get(i).avatar(),"success message not displayed");
		  
		  
		  
	  }
	}
	
	@Given("user invoke the api for update {string}")
	public Response user_invoke_the_api_for_update(String user) {
		Response response = Headers.PostHeader(Constants.USER_URL+user);
	    return response;
	}

	@When("the user will get update200  response {string}")
	public void the_user_will_get_update200_response(String page) {
		 soft.assertTrue(String.valueOf(user_invoke_the_api_for_update(page).getStatusCode()).equals("200"));
	}

	@Then("user will see the updated {string}")
	public void user_will_see_the_updated(String page) {
		soft.assertEquals(user_invoke_the_api_for_update(page).getBody().jsonPath().getList("data").size(), FileUtils.getMultiuserUsers().size(),"Success message is not display");
		  soft.assertEquals(user_invoke_the_api_for_update(page).getBody().jsonPath().getInt("page"),2,"Success message is not display");
		  soft.assertEquals(user_invoke_the_api_for_update(page).getBody().jsonPath().getInt("total_pages"),2,"Success message is not display");
		  soft.assertEquals(user_invoke_the_api_for_update(page).getBody().jsonPath().getInt("total"),12,"Success message is not display");
		  soft.assertEquals(user_invoke_the_api_for_update(page).getBody().jsonPath().getInt("per_page"),6,"Success message is not display");
		  
	}
}
