package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace_MainClass;
import Pojo.LocationClass;

public class TestDataBuild {

	public AddPlace_MainClass addPlacePayload(String name,String language,String address) {

		AddPlace_MainClass addPlace = new AddPlace_MainClass();
		addPlace.setAccuracy(50);
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setPhone_number("1234567890");
		addPlace.setWebsite("https://rahulshettyacademy.com");
		addPlace.setName(name);
		List<String> list = new ArrayList();
		list.add("shoe park");
		list.add("shop");
		addPlace.setTypes(list);
		LocationClass location = new LocationClass();
		location.setLat(-38.383494);
		location.setLng(33.447362);
		addPlace.setLocation(location);

		return addPlace;

	}

}
