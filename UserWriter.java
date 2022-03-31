import java.io.FileWriter;
import java.io.IOException;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import netscape.javascript.JSObject;

public class UserWriter extends UserAttributes {
    public static void saveUsers(ArrayList<Account> Accounts) {
        JSONArray jsonaccount = new JSONArray();

        for(int i = 0; i < Accounts.size();++i){
            jsonaccount.add(getAccountINFOJSON(Accounts.get(i)));
        }

        try(FileWriter file = new FileWriter("tempNAme")) {
            file.write(jsonaccount.toJSONString());
            file.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }


    }


    public static JSONObject getAccountINFOJSON(Account useAccount) {
        JSONObject toReturn = new JSObject(); 
        

        toReturn.put(Const_AccID);
        toReturn.put(Const_email);
        toReturn.put(Const_Password);
        JSONArray ResistedUSers = new JSONArray();
        ArrayList<RegisteredUser> RegistedUser =  useAccount.getUsers();
        for(int i = 0; i < RegistedUser.size();++i) {
            JSONObjct temp = new JSObject();

            temp.put(Const_FIRST_NAME, RegistedUser.get(i).getFirstName());
            temp.put(Const_LAST_NAME,RegistedUser.get(i).getLastName());
            temp.put(Const_DATE_OF_BIRTH,RegistedUser.get(i).getDateOfBirth());
            temp.put(Const_BILLING_ADDRESS, RegistedUser.get(i).getBillingAddress());
            temp.put(Cont_RegisteredId, RegistedUser.get(i).getID());
            temp.put(Const_DISCOUNT, RegistedUser.get(i).getDiscount());
            temp.put(Const_REWARD_MEMBER, RegistedUser.get(i).getRewardMember());
            temp.put(Const_NUM_FLIGHTS, RegistedUser.get(i).getNumFlights());
            temp.put(const_REVIEW, RegistedUser.get(i).getReview());
            
            String [] BlackList = new String[RegistedUser.get(i).getBlackList().size()];
            String [] Pets = new String[RegistedUser.get(i).getPets().size()];
            for(int ii = 0; ii < RegistedUser.get(i).getBlackList().size(); ++ii) {
                BlackList[ii] = RegistedUser.get(i).getBlackList().get(ii);
                Pets[ii] = RegistedUser.get(i).getPets().get(ii).toString();
            }
            temp.put(Const_BlackList, BlackList);
            temp.put(Const_Pets, Pets);
            ResistedUSers.add(temp);
        }
        toReturn.put(Const_RegisterdUsers, ResistedUSers);
        return toReturn;
    }
}