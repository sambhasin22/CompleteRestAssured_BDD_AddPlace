package StepDefenition;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResource_EnumClass;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.given;

public class stepDefenation extends Utils {

	ResponseSpecification responseSpecBuilder;
	RequestSpecification res;
	Response response;
	public static String Place_id;

	// Create Seprate file for test Data
	TestDataBuild testDataBuild = new TestDataBuild();

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) {

		// Access the method of testData using TestDataBuild class object in
		// Body
		res = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload(name, language, address));

	}

	@When("User calls {string} APi with {string} http request")
	public void user_calls_APi_with_http_request(String apiName, String apiHTTPMethod) {
		responseSpecBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200)
				.build();

		// Using enom class to remove hardcode of resources for all different
		// API's
		// Constructor will call with Valueof resource which we Pass i.e
		// 'apiName'
		APIResource_EnumClass resourceAPI = APIResource_EnumClass.valueOf(apiName);

		if (apiHTTPMethod.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (apiHTTPMethod.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
		else if (apiHTTPMethod.equalsIgnoreCase("DELETE"))
			response = res.when().delete(resourceAPI.getResource());
		else if(apiHTTPMethod.equalsIgnoreCase("PUT"))
			response = res.when().put(resourceAPI.getResource());
	}

	@Then("The API call should got sucess with status code {string}")
	public void the_API_call_should_got_sucess_with_status_code(String statusCode) {
		

		Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());

	}

	@Then("{string} in Response body should be {string}")
	public void in_Response_body_should_be(String kevVlaue, String expectedVale) {

		String result = getJson_ObjectValue(response, kevVlaue); // Use One
																	// Utility
																	// Method

		Assert.assertEquals(expectedVale, result);

	}

	@Then("verify place_id created map to {string} using {string}")
	public void verify_place_id_created_map_to_using(String expectedName, String apiName) {

		Place_id = getJson_ObjectValue(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", Place_id);
		user_calls_APi_with_http_request(apiName, "GET");

		String actualName = getJson_ObjectValue(response, "name");
		System.out.println("Sucessfully Added Place_id is ===== > " + Place_id);
		Assert.assertEquals(expectedName, actualName);

	}
	
	/*
	 * Code for Remove Place using Delete API
	 */

	@Given("Using deletePlaceAPI payload for delete a place")
	public void using_deletePlaceAPI_payload_for_delete_a_place() {

		res = given().spec(requestSpecification())
				.body(getPlace_Id_For_Delete(Place_id));
		System.out.println("Sucessfully Reomove Place_Id is ==== > " + Place_id);

	}

}

