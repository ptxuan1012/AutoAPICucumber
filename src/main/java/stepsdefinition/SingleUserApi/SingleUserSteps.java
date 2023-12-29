package stepsdefinition.SingleUserApi;

import static org.testng.Assert.assertEquals;

import common.Context;
import common.JsonUtils;
import common.TestContext;
import io.cucumber.java.en.Then;

public class SingleUserSteps {

	public TestContext testContext;
	public SingleUserSteps(TestContext context) {
		testContext = context;
	}
	@Then("I check user id correctly")
	public void i_check_user_id_correctly() {
		int expectedUserId = 2;
		String responseBody = (String)testContext.scenarioContext.getContext(Context.responseBody);
		System.out.println(responseBody);
		JsonUtils jsonUtils = new JsonUtils();
	    String data = jsonUtils.getValueByKey(responseBody, "data");
	    String actualUserId = jsonUtils.getValueByKey(responseBody, "id");
	    int actualUserIdConverted = Integer.parseInt(actualUserId);
	    assertEquals(expectedUserId, expectedUserId);
	    
	}
	}
