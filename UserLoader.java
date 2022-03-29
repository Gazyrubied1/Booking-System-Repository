import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;

public class UserLoader extends UserAttributes {
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try {
			FileReader reader = new FileReader();
			JSONParser parser = new JSONParser();
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			// Account 
			for (int i = 0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON\.get(i);
				String AccountID = (String)personJSON.get(Const_AccID);
				String Email = (String)personJSON.get(Const_email);
				String Password = (String)personJSON.get(Const_Password);
				
				JSONArray RegisteredUsersJSON = (JSONArray)personJSON.get(Const_RegisterdUsers);
				for(int ii = 0; ii < RegisteredUsersJSON.size(); ++i) {
					JSONObject RegisteredUser = (JSONObject)RegisteredUsersJSON.get(ii);
					String First_Name = (String)RegisteredUser.get(Const_FIRST_NAME);
					String Last_name = (String)RegisteredUser.get(Const_LAST_NAME);
					String Date_of_birth = (String)RegisteredUser.get(Const_DATE_OF_BIRTH);
					String RegisteredID = (String)RegisteredUser.get(Cont_RegisteredId);
					boolean Discount = (boolean)RegisteredUser.get(Const_DISCOUNT);
					boolean RewardMember = (boolean)RegisteredUser.get(Const_REWARD_MEMBER);
					int numflights = (int)RegisteredUser.get(Const_NUM_FLIGHTS);
					double review =(double)RegisteredUser.get(const_REVIEW);

					// ticket
					JSONArray TicketJSON = (JSONArray)RegisteredUser.get(Const_Ticket);
					for(int iii = 0; iii < TicketJSON.size(); ++iii ) {
						
					}

				}



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
