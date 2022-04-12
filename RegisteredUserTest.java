import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Verifier;
import org.junit.jupiter.*;
public class RegisteredUserTest {
    

    @Test
    public void GenerateUserTest(){
        
       ArrayList<Flight> flight = GenerateFilght.Generateflight();
       ArrayList<Account> test = new ArrayList<>();
       test = UserLoader.getUsers();
       assertNotNull(test, "false - this should have somthing");;

    }

    @Test
    public void BlackListTest(){
       ArrayList<Flight> flight = GenerateFilght.Generateflight();
       ArrayList<Account> test = UserLoader.getUsers();
       ArrayList<String> black = new ArrayList<>();
       black.add("test");
       RegisteredUser user = new RegisteredUser("dave", "long", "12/12/12", "doesn't matter", false, false, 2, 4, black, null, "6543321");
       ArrayList<RegisteredUser> users = new ArrayList<>();
       users.add(user);
       Account tests = new Account("12345", "1235@gmail.com", "4321", users);
       tests.getUsers().get(0).blacklistAirport("airport");
       int index =0;
       for (int i = 0; i <tests.getUsers().get(0).getBlackList().size();i++){
        index++;
       }
       assertSame("airport", tests.getUsers().get(0).getBlackList().get(index), "fail - was not added");
    }
}
