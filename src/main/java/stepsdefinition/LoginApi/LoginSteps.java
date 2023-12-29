package stepsdefinition.LoginApi;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import common.ApiUtils;
import common.Context;
import common.JsonUtils;
import common.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	String url, requestBody;
	JsonUtils jsonUtils = new JsonUtils();
	HttpResponse<String> response;
	TestContext testContext;
	
	
	public LoginSteps(TestContext context) {
		testContext = context;
	}

	@Then("The response returns token")
	public void the_response_returns_token() {
	    String response = testContext.scenarioContext.getContext(Context.responseBody).toString();
	    System.out.println("bbbb" + response.toString());
	    String actualToken = jsonUtils.getValueByKey(response, "token");
	    System.out.println("aaaaa" + actualToken);
	    Assert.assertTrue(actualToken != null && !actualToken.trim().isEmpty());
	}

//	@Given("I have url and Method and request body with {string} and {string}")
//	public void i_have_url_and_method_and_request_body_with_and(String fieldName, String value, DataTable givenTable) {
//	    List<Map<String, String>> list = givenTable.asMaps(String.class, String.class);
//	    String requestBodyName ="";
//	    for ( Map<String, String> m : list){
//	    	url = m.get("URL");
//	    	requestBodyName = m.get("RequestBody");
//	    }
//	    
//	    //copy file mới
//	    String jsonBodySourceFilePath = System.getProperty("user.dir") + "//src//main//resources"+ requestBodyName;
//	    //Path path = Paths.get(jsonBodyFilePath);
//	    File sourceFile = new File(jsonBodySourceFilePath);
//	    
//	    String jsonBodyDictinationFilePath = System.getProperty("user.dir") + "//src//main//resources"+ requestBodyName.replace(".json", "Copy.json");
//	    File dictinationFile = new File(jsonBodyDictinationFilePath);
//	    jsonUtils.copyJsonFile(sourceFile, dictinationFile);
//	    
//	    //đổi giá trị //đọc content file
//	    requestBody = jsonUtils.changeValueByFieldName(dictinationFile, fieldName, value);
//	    	    
//	}
//
//	@When("I send login request")
//	public void i_send_login_request() {
//		ApiUtils apiUtils = new ApiUtils();	
//	   response = apiUtils.sendPostRequest(url, requestBody);
//	}
//
//	@Then("I check {int} and {string} of login api correctly")
//	public void i_check_and_of_login_api_correctly(int expectedStatusCode, String expectedErrorMessage) {
//		assertEquals(response.statusCode(), expectedStatusCode);
//		assertEquals(jsonUtils.getValueByKey(requestBody, "error"), expectedErrorMessage);
//		
//	}
}
