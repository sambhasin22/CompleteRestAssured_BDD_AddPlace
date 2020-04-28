package StepDefenition;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() {
		/*
		 * Execute below Code only when Place_Id = null write a code first it
		 * will give us Place_Id
		 */

		stepDefenation step = new stepDefenation();

		if (stepDefenation.Place_id == null) {

			step.add_Place_Payload_with("Automation", "English", "London");
			step.user_calls_APi_with_http_request("AddPlaceAPI", "POST");
			step.verify_place_id_created_map_to_using("Automation", "GetPlaceAPI");

			String placeid = stepDefenation.Place_id;
			System.out.println("Place Id is using @DeletePlace API tag ==== > " + placeid);

		}

	}

}
