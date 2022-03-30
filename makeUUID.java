import java.util.Random;
import java.util.UUID;
public class makeUUID extend {

    public  void run(){
       Random rand = new Random();
       System.out.print("\"dayRange\": [");
       int [] days = new int[rand.nextInt(364)];
       days[0] = 1;
       for(int i =1; i< days.length; ++i) {
            int add = rand.nextInt(365);
            days[i] = add; 
       }
       int temp =0;
       for(int i = 0; i < days.length; i++) {
           for(int ii = 1; ii < days.length-1; ++ii) {
               if(days[ii-1] > days[ii]){
                temp = days[ii-1];
                days[ii-1] = days[ii];
                days[ii] = temp;
               }
           }
        }
        
       for(int i = 0; i < days.length-1; ++i){
        if(days[i] != days[i+1])   
           System.out.print(days[i]+",");
       }
       System.out.print("]");

       for(int i = 0; i < 25; i++){
        UUID id = UUID.randomUUID();

        System.out.println("\n"+id);
    }
       
    }
            
    
 public static void main(String[] args) {
   makeUUID temp  = new makeUUID();
    temp.run();
}  
    
}

    
}
