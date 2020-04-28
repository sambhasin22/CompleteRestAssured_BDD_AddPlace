package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import groovyjarjarantlr4.runtime.tree.RewriteRuleNodeStream;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification requestSpeBuilder;
	Properties prop;
	FileInputStream fs;
	public JsonPath js;
	String result;

	public RequestSpecification requestSpecification() {

		PrintStream log = null;
		System.out.println("For Testing Purpose");

		if (requestSpeBuilder == null) {

			try {
				log = new PrintStream(new FileOutputStream("logging.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			requestSpeBuilder = new RequestSpecBuilder().addQueryParam("key", "qaclick123")
					.setBaseUri(getDataFromPropertyFile("BASEURI")).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

			return requestSpeBuilder;
		}
		return requestSpeBuilder;

	}

	public String getJson_ObjectValue(Response response, String key) {

		result = response.asString();
		js = new JsonPath(result);
		return js.get(key).toString();

	}
	
	public String getPlace_Id_For_Delete(String placeId){
		
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}\r\n";
		
	}
	

	public String getDataFromPropertyFile(String key) {

		try {
			if (prop == null) {
				prop = new Properties();
				fs = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\resources\\config.property");
				try {
					prop.load(fs);
					prop.getProperty(key);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getStackTrace());

		}
		return prop.getProperty(key);

	}

}
