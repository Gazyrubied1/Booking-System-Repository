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
       test = UserLoader.getUsers();
       asssertNull("should not be null", test);

    }

    @Test
    public void BlackListTest(){
       ArrayList<Flight> flight = GenerateFilght.Generateflight();
       ArrayList<Account> test = UserLoader.getUsers();

    }
}
