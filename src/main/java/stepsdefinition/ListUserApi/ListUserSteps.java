package stepsdefinition.ListUserApi;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;

import common.ApiUtils;
import common.Context;
import common.JsonUtils;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListUserSteps {
	String url,method;
	HttpResponse<String> response;
	TestContext testContext;
	public ListUserSteps(TestContext context) {
		testContext = context;
	}
//	@Given("I have {string} and Method")
	public void i_have_url_and_method(String givenUrl) {
		System.out.println("url" + givenUrl);
	    url = givenUrl;
	    method ="GET";
	   
	}

	@When("I send list user request")
	public void i_send_list_user_request() {
	   ApiUtils apiUtils = new ApiUtils();
	   response = apiUtils.sendGetRequest(url);
	   testContext.scenarioContext.setContext(Context.responseBody, response);
	}

//	@Then("I check {int} correctly")
//	public void i_check_status_code_and_page_number_correctly(int expectedStatusCode) {
//	    assertEquals(response.statusCode(), expectedStatusCode);
//	}
	
	@Then("I check page number correctly")
	public void i_check_page_number_correctly() {
	    int expectedPageNumber = 2;
	    String responseBody = response.body();
	    JsonUtils jsonUtils = new JsonUtils();
	    String actualPageNumber = jsonUtils.getValueByKey(responseBody, "page");
	    int actualPageNumberConverted = Integer.parseInt(actualPageNumber);
	    assertEquals(actualPageNumberConverted, expectedPageNumber);
	    
	}
}
