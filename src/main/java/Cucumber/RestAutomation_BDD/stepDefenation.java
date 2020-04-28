package Cucumber.RestAutomation_BDD;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Pojo.AddPlace_MainClass;
import Pojo.LocationClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;


public class stepDefenation {
 
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	
	
	/*@Given("Add Place Payload")
	public void add_place_payload() throws JsonProcessingException {
		
		
		
		AddPlace_MainClass p = new AddPlace_MainClass();
		p.setAccuracy(50);
		p.setAddress("Bengaluru");
		p.setLanguage("Hindi");
		p.setPhone_number("987654321");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline House");
		List<String> list = new ArrayList();
		list.add("shoe park");
		list.add("shop");
		p.setTypes(list);
		LocationClass location = new LocationClass();
		location.setLat(-38.383494);
		location.setLng(33.447362);
		p.setLocation(location);
		
			
 
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	
			
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
 
		res=given().spec(req)
		 .body(p);
			
	}
 
	@When("User calls {string} APi with Post http request")
	public void user_calls_with_post_http_request(String string) {
	    
		response = res.when().post("/maps/api/place/add/json").then()
				.spec(resspec).extract().response();
		

		
		Response  response = res.when().post("/maps/api/place/add/json").then().extract().response();
		 System.out.println("Collected response");
	}
 
	@Then("The API call should got sucess with status code {int}")
	public void api_call_is_successful_with_status_code(Integer int1) {

		Assert.assertEquals(200,response.getStatusCode());
		

	}
 
	@Then("{string} in Response body should be {string}")
	public void in_response_body_is1(String keyvalue, String ExpectedValue) {
	    
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		
		System.out.println(js.get(keyvalue));
		
		
		//Assert.assertEquals(js.getString(keyvalue).toString(),ExpectedValue);
		
	}
 
	
 
*/	
}