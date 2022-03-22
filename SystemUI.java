import java.util.*;

public class SystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to our flight booking system";
    ArrayList<Account> accounts = new ArrayList();

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while () {
            System.out.println("1. Login to an existing account\n2. Create an account\n3. Logout");

            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();
            if (answer != 1 || answer != 2 || answer != 3) {
                System.out.println("Not a valid response");
                continue;
            }
            if (answer == 3) break;
            if (answer == 2) { // create account
                System.out.println("Please enter the following information to create an account:");
                System.out.println("Email Address: ");
                String email = scan.next();
                System.out.println("Password");
                String password = scan.next();
                accounts.add(Account(UUID.randomUUID()));
                System.out.println("Congratulations!! You have created an account with email " + email + " and password " + password);
            }
            else if (answer == 1) { // login to account
                System.out.println("Enter email: ");
                String email = scan.next();
                System.out.println("Enter Password: ");
                String password = scan.next();
                boolean found = false;
                for (Account account : accounts) {
                    if ((account.getEmail() + account.getPassword()).equals(email + password)) {
                        found = true;
                        UserUI user = new UserUI(account);
                    }
                }
                if (!found) System.out.println("The username/password combination does not exist");
            }
        }
    }
    
    public static void main(String[] args) {

    }
}

