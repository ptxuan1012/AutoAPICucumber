package stepsdefinition.CatApi;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import common.ApiUtils;
import common.Context;
import common.JsonUtils;
import common.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatApiSteps {
	String url, requestBodyFilePath;
	JsonUtils jsonUtils = new JsonUtils();
	ApiUtils apiUtils = new ApiUtils();
	HttpResponse<String> response;
	TestContext testContext;

	public CatApiSteps(TestContext context) {
		testContext = context;
	}

	@Given("I have url and Method and request body")
	public void i_have_and_method_and_request_body(DataTable catTable) {
		// Lay ten file request body va url
		List<Map<String, String>> list = catTable.asMaps(String.class, String.class);
		String requestBodyName = "";
		for (Map<String, String> m : list) {
			url = m.get("URL");
			requestBodyName = m.get("RequestBodyName");
		}

		if(requestBodyName == null || requestBodyName.isEmpty() || requestBodyName.isBlank()) {
			System.out.println("Empty");
		}else {
			requestBodyFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\" + requestBodyName;
		}
	}

	// For Successfully Case
	@When("I send request")
	public void i_send_request() {
		if(requestBodyFilePath == null || requestBodyFilePath.isEmpty() || requestBodyFilePath.isBlank()) {
			response = apiUtils.sendGetRequest(url);
		}else {
			String requestBody = jsonUtils.readJsonFile(requestBodyFilePath);
			response = apiUtils.sendPostRequest(url, requestBody);
			System.out.println("ccccc" + response.body());
			testContext.scenarioContext.setContext(Context.responseBody, response.body());
		}
	}

	@Then("I check {int} correctly")
	public void i_check_correctly(int expectedStatusCode) {
		assertEquals(response.statusCode(), expectedStatusCode);
	}

	// For Validation Case
	@When("I send cat request with validation data with {string} and {string}")
	public void i_send_cat_request_with_validation_data(String fieldName, String value) {
		String requestBody = jsonUtils.createRequestBody(requestBodyFilePath, fieldName, value);
		response = apiUtils.sendPostRequest(url, requestBody);
		System.out.println("aaaa" + response.body().toString());
	}

	@Then("I check {int} and {string} of cat api correctly")
	public void i_check_expected_status_code_and_expected_message_of_cat_api_correctly(int expectedStatusCode,
			String expectedErrorMessage) {
		assertEquals(response.statusCode(), expectedStatusCode);
		System.out.println("Actual body: " + response.body());
		assertEquals(response.body().toString(), expectedErrorMessage);
	}

}
