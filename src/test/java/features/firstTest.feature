Feature: Validation Place API's

@AddPlace @Regression
Scenario Outline: Verify if place is added/get sucessfully using Add/get/deletePlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>" 
	When User calls "AddPlaceAPI" APi with "Post" http request
	Then The API call should got sucess with status code "200"
	And "status" in Response body should be "OK"
	And "scope" in Response body should be "APP"
	And verify place_id created map to "<name>" using "GetPlaceAPI"
	
	
Examples: 
	|name	|language	|address	|
	|JON	|English	|US			|
	|PETER	|English	|Europe		|	
	|SAM	|Japnees	|Japan		|
	
@DeletePlace @Regression
Scenario: Verify delete functionality using DeletePlaceAPI
	Given Using deletePlaceAPI payload for delete a place
	When  User calls "DeletePlaceAPI" APi with "Post" http request
	Then  The API call should got sucess with status code "200"
	And   "status" in Response body should be "OK"