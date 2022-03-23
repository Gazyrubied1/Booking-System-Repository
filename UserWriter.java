import java.io.*;

import netscape.javascript.JSObject;

public class UserWriter extends UserAttributes {
    public static void saveUsers() {
        Account account = Account.getInstance(); // implement
        ArrayList<RegisteredUser> userList = account.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get()));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUser.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSObject();
        userDetails.put(USER_ID, user.getId().toString());
    }
}