package RestApiTest.RestApiTest;



import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAutomationTest extends AbstactMethods {


	public static Response generateResponseUtility() {


		RestAssured.baseURI = "http://demo4032024.mockable.io/apitest";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET);
		
		return response;

	}

	@Test
	@Override
	public void validateStatusCode() {
		Response response = generateResponseUtility();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	@Override
	public void validateResponseHeader() {
		Response response = generateResponseUtility();
		Assert.assertEquals(response.getHeader("content-type"), "application/json; charset=UTF-8");

	}

	@Test
	@Override
	public void validateResponseBody() {
		Response response = generateResponseUtility();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("message"), "data retrieved successful");

	}

}
