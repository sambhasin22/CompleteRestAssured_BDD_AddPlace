package StepDefenition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Pojo.AddPlace_MainClass;
import Pojo.LocationClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//features", glue = { "StepDefenition" }

)
public class stepDefenation {
	

	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	public RequestSpecification response;
	public Response result;
	
	

	@Given("Add Place Payload")
	public void add_Place_Payload() throws JsonProcessingException {

		LocationClass lc2 = new LocationClass();
		lc2.setLat(-38.383494);
		lc2.setLng(38.1111111);

		List<String> typeList = new ArrayList<String>();
		typeList.add("WineShop");
		typeList.add("Nike ShowRoom");

		AddPlace_MainClass addPlace = new AddPlace_MainClass();
		addPlace.setAccuracy(100);
		addPlace.setAddress("London");
		addPlace.setLanguage("Punjabi");
		addPlace.setLocation(lc2);
		addPlace.setType(typeList);
		addPlace.setName("Cucumber BBD");
		addPlace.setPhone_number("1111111111");
		addPlace.setWebsite("https://udemy.com");

		/*
		 * com.fasterxml.jackson.databind.ObjectMapper mapper = new
		 * com.fasterxml.jackson.databind.ObjectMapper(); String s =
		 * mapper.writeValueAsString(addPlace);
		 */

		requestSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123")
				.build();

		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		response = given().spec(requestSpec).body(addPlace);

	}

	@When("User calls {string} APi with Post http request")
	public void user_calls_APi_with_Post_http_request(String string) {

		result = response.when().log().all().post("/maps/api/place/add/json").then().spec(responseSpec)
				.extract().response();
	}

	@Then("The API call should got sucess with status code {int}")
	public void the_API_call_should_got_sucess_with_status_code(Integer int1) {

		System.out.println(
				" ************************** Sucessfully added place and status code is 200 ****************** ");

		assertEquals(200,result.getStatusCode());

	}

	@Then("{string} in Response body should be {string}")
	public void status_in_Response_body_should_be_ok(String keyvalue, String ExpectedValue) throws JsonMappingException, JsonProcessingException {
		String compleresponse = result.asString();

		System.out.println("Complete Response is ====== > " + compleresponse);
		
		JsonPath js = new JsonPath(compleresponse);

		System.out.println(js.toString());

		System.out.println("Fetch ID is === > " + js.get("id"));

	}

}
