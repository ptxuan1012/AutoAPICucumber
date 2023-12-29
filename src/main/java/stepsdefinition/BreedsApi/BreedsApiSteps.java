package stepsdefinition.BreedsApi;

import static org.testng.Assert.assertEquals;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import common.ApiUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BreedsApiSteps {
	String url;
	ApiUtils apiUtils = new ApiUtils();
	HttpResponse<String> response;
	
	@Given("I have url of breeds api")
	public void i_have_url_of_breeds_api(DataTable breedsTable) {
		List<Map<String, String>> list = breedsTable.asMaps(String.class, String.class);
		for (Map<String, String> m : list) {
			url = m.get("URL");
		}
	}

	@When("I send breeds request")
	public void i_send_breeds_request() {
		response = apiUtils.sendGetRequest(url);
	}

	@Then("I check {int} of breeds api correctly")
	public void i_check_of_breeds_api_correctly(int expectedStatusCode) {
		assertEquals(response.statusCode(), expectedStatusCode);
	}
}
