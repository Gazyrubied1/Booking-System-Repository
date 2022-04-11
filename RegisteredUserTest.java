import static org.junit.jupiter.api.Assertions.*;

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
       Boolean hasNull = test = UserLoader.getUsers();
       asssertNotNull(test);

    }

    @Test
    public void BlackListTest(){
       ArrayList<Flight> flight = GenerateFilght.Generateflight();
       ArrayList<Account> test = UserLoader.getUsers();
       test.get(0).getUsers().get(0).blacklistAirport("airport");
       int index =0;
       for (int i = 0; i <test.get(0).getUsers().get(0).getBlackList().size();i++){
        index++;
       }
       assertSame("airport", test.get(0).getUsers().get(0).getBlackList().get(index), "fail - was not added");
    }
}
