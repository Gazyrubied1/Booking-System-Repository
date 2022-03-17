
import java.util.UUID;
public class id {
    public static void main(String[] args) {
    
       for(int i = 1; i <= 20; ++i){ 
    String id = UUID.randomUUID().toString(); 
        
    System.out.println(i+" "+ id +"\n");
    }
    }
    
}
