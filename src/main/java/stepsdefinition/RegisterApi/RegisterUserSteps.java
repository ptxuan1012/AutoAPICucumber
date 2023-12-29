package stepsdefinition.RegisterApi;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;

import common.ApiUtils;
import common.JsonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUserSteps {
	String url, method, requestBody;
	HttpResponse<String> response;
	
	@Given("I have {string} and Method and {string}")
	public void i_have_and_method_and_request_body(String givenUrl, String requestBodyName) {
	   url = givenUrl;
	   method = "POST";
	   String jsonBodyFilePath = System.getProperty("user.dir") + "//src//main//resources"+ requestBodyName;
	   JsonUtils jsonUtils = new JsonUtils();
	   requestBody = jsonUtils.readJsonFile(jsonBodyFilePath);
	}

	@When("I send register user request")
	public void i_send_register_user_request() {
	    ApiUtils apiUtils = new ApiUtils();
	    response = apiUtils.sendPostRequest(url, requestBody);    
	}
	
	@Then("I check {int} of register api correctly")
	public void i_check_of_register_api_correctly(int expectedStatusCode) {
		assertEquals(response.statusCode(), expectedStatusCode);
	}


}
