package Cucumber.RestAutomation_BDD;

import java.util.ArrayList;
import java.util.List;
import Pojo.AddPlace_MainClass;
import Pojo.LocationClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;


public class specBuilderPractice {

	public static void main(String[] args) {
		
		RequestSpecification requestSpecBuilder;
		ResponseSpecification responseSpecBuilder;
		
		
		
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
		
		 requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				 setContentType(ContentType.JSON).addQueryParam("key ", "qaclick123").build();
		 	 
		 
		 responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).
				 expectContentType(ContentType.JSON).build();
		 
		  RequestSpecification res = given().spec(requestSpecBuilder).body(p);
		 	
				 
				 Response response = res.when().post("/maps/api/place/add/json").
				 then().spec(responseSpecBuilder).extract().response();

				 String result = response.asString();
				 JsonPath js = new JsonPath(result);
				 
				 System.out.println("************** " + js.getString("id"));
				 	
		

	}

}
