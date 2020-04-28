package resources;

public enum APIResource_EnumClass {

	AddPlaceAPI("/maps/api/place/add/json"), 
	GetPlaceAPI("/maps/api/place/get/json"), 
	DeletePlaceAPI("/maps/api/place/delete/json"),
	PutPlaceAPI("/maps/api/place/update/json");
	
	
	private String resource;

	APIResource_EnumClass(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;

	}

}
