import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;

public class UserLoader extends UserAttributes {
	public static ArrayList<Account> getUsers() {
		ArrayList<Account> users = new ArrayList<>();

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
				
				// Registed users
				JSONArray RegisteredUsersJSON = (JSONArray)personJSON.get(Const_RegisterdUsers);
				ArrayList<RegisteredUser> AddToend = new ArrayList<>();
				for(int ii = 0; ii < RegisteredUsersJSON.size(); ++i) {
					JSONObject RegisteredUser = (JSONObject)RegisteredUsersJSON.get(ii);
					String First_Name = (String)RegisteredUser.get(Const_FIRST_NAME);
					String Last_name = (String)RegisteredUser.get(Const_LAST_NAME);
					String Date_of_birth = (String)RegisteredUser.get(Const_DATE_OF_BIRTH);
					String Bill_Adress = (String)RegisteredUser.get(Const_BILLING_ADDRESS);
					String RegisteredID = (String)RegisteredUser.get(Cont_RegisteredId);
					boolean Discount = (boolean)RegisteredUser.get(Const_DISCOUNT);
					boolean RewardMember = (boolean)RegisteredUser.get(Const_REWARD_MEMBER);
					int numflights = (int)RegisteredUser.get(Const_NUM_FLIGHTS);
					double review =(double)RegisteredUser.get(const_REVIEW);

					// ticket
					JSONArray TicketJSON = (JSONArray)RegisteredUser.get(Const_Ticket);
					ArrayList<Ticket> TicketToAdd = new ArrayList<>();
					for(int iii = 0; iii < TicketJSON.size(); ++iii ) {
						// TODO finish when ticket is set

					}
					String [] BlackList = (String [])RegisteredUser.get(Const_BlackList);
					ArrayList<String> BlackListToAdd = new ArrayList<>();
					for(int iii = 0; iii < BlackList.length; ++iii) {
						BlackListToAdd.add(BlackList[iii]);
					}
					Pet[] pets = (Pet [])RegisteredUser.get(Const_Pets);
					ArrayList<Pet> PetsAdd = new ArrayList<>();
					for(int iii = 0; iii <pets.length; ++iii) {
						PetsAdd.add(pets[iii]);
					}
					RegisteredUser UserToAdd = new RegisteredUser(First_Name, Last_name, Date_of_birth, Bill_Adress, Discount, RewardMember, numflights, review, TicketToAdd, BlackListToAdd, PetsAdd, RegisteredID);
					AddToend.add(UserToAdd);
				}
				Account temp = new Account(AccountID, Email, Password, AddToend)
				users.add(temp);
				
			}
			return users;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}



}
