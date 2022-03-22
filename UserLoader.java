import java.io.*;

public class UserLoader extends UserAttributes {
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try {
			FileReader reader = new FileReader();
			JSONParser parser = new JSONParser();
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			for (int i = 0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(User_ID));
				String firstName = (String)personJSON.get(FIRST_NAME);
				String lastName = (String)personJSON.get(LAST_NAME);
				int dateOfBirth = ((Long)personJSON.get(DATE_OF_BIRTH)).intValue();
				boolean discount = (Boolean)personJSON.get(DISCOUNT);
				boolean RewardMember = (Boolean)personJSON.get(REWARD_MEMBER);
				int numFlights = ((Long)personJSON.get(NUM_FLIGHTS)).intValue();
				double review = (Double)personJSON.get(REVIEW);
				JSONArray past = personJSON.get(PASTFLIGHTS);
				ArrayList<Flights> pastFlights = new ArrayList();
				for (int j = 0; j < past.size(); j++) {
					pastFlights.add(past[i]);
				}
				users.add(new User(id, firstName, lastName, dateOfBirth, discount, RewardMember, numFlights, review, pastFlights));
			}
			return users;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



}
