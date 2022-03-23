import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; // ask how to add this

public class GenerateRegistedUsers extends RegestedUsersConstants {
   
    public static ArrayList<RegisteredUser> GenerateUsers() {
    ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();

    try{
        FileReader reader = new FileReader(Registed_User_File);
        JSONParser parser = new JSONParser();
        JSONArray RegistedUserJSON = (JSONArray)new JSONParser().parse(reader);

        for(int i = 0; RegistedUserJSON.size(); ++i) {
            JSONObject RegistedUsersJSON = (JSONObject)RegistedUserJSON.get(i);
            
            String first_Name = (String)RegistedUsersJSON.get(First_Name);
            String Last_Name = (String)RegistedUsersJSON.get(Last_Name);
            String DOB = (String)RegistedUserJSON.get(Date_Of_Birth);
            String Bill_Address = (String)RegistedUsersJSON.get(Billing_Address);
            String ID = (String)RegistedUsersJSON.get(ID);
            boolean Discount = (boolean)RegistedUsersJSON.get(Discount);
            boolean Reward_Member = (boolean)RegistedUsersJSON.get(Reward_Member);
            int Number_Flights = (int)RegistedUsersJSON.get(Number_Flights);
            double Review = (double)RegistedUsersJSON.get(Review);
            ArrayList<Ticket> Past_Resrvation = (ArrayList<Ticket>)RegistedUsersJSON.get(Past_Resrvations);
            ArrayList<String> blackListed = (ArrayList<String>)RegistedUsersJSON.get(Black_Listed);
            ArrayList<Pet> pets = (ArrayList<Pet>)RegistedUsersJSON.get(pets); 

            users.add(new RegisteredUser(first_Name, Last_Name, DOB, Billing_Address, Discount, Reward_Member, Number_Flights, Review, Past_Resrvation, blackListed, pets, ID));
        }
        return users;

       }catch(Exception e) {
           e.printStackTrace();
       }
       return null;
    }
}
