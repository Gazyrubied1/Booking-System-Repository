import java.util.*;

public class SystemUI {
    private static final String WELCOME_MESSAGE_SYSTEM = "Welcome to our flight booking system!\n\n*********** Main Menu **************";
    private static final String WELCOME_MESSAGE_ACCOUNT = "********* Account Menu ************";
    private static final String WELCOME_MESSAGE_USER = "********** User's Menu *************";
    ArrayList<Account> accounts; // change this to JSON

    SystemUI() {
        accounts = new ArrayList();
    }
    public void run() {
        System.out.println(WELCOME_MESSAGE_SYSTEM);

        while (true) {
            System.out.println("1. Login to an Existing Account\n2. Create an Account\n3. Search Flights\n4. Search Hotels\n5. Logout\n");

            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();
            if (answer == 5) break;
            else if (answer == 4) { // search hotels
                //TODO Make sure that the four brands are the only choices the user can choose from
                //TODO Make sure that the user can input only a two letter State Abbreviation
                BookHotel hotels = new BookHotel();
                System.out.println("Would you like to search hotels by:\n1) Name of the Hotel\n2) State where the Hotel is at\n3) Both");
                int ans = scan.nextInt();
                switch(ans) {
                    case 1: // search hotels by brand
                        System.out.println("What hotel brand do you want to search for? (Choose from Marriott, Hilton, Wyndham, Hyatt)");
                        String brand = scan.next();
                        hotels.SearchHotel(brand);
                        break;
                    case 2: // seach hotels by state
                        System.out.println("What state do you want to search for hotels in? (Use the two-letter state abbreviation)");
                        String state = scan.next();
                        System.out.println("Below are all hotels in " + state + ": ");
                        hotels.SearchHotel(state);
                        break;
                    case 3: // search hotels by state and brand
                        System.out.println("What state do you want to search for hotels in? (Use the two-letter state abbreviation)");
                        state = scan.next();
                        System.out.println("What hotel brand do you want to search for? (Choose from Marriott, Hilton, Wyndham, Hyatt)");
                        brand = scan.next();
                        System.out.println("Below are all " + brand + " hotels in " + state);
                        hotels.SearchHotel(state, brand);
                        break;
                }
            }
            else if (answer == 3) { // search flights
                //figure out how to search through existing flights using BookFlights
            }
            else if (answer == 2) { // create account
                System.out.println("Please enter the following information to create an account:");
                System.out.println("Email Address: ");
                String email = scan.next();
                System.out.println("Password");
                String password = scan.next();
                accounts.add(new Account(UUID.randomUUID().toString(), email, password, new ArrayList<RegisteredUser>(), new HashMap<Flight, ArrayList<RegisteredUser>>()));
                System.out.println("\nCongratulations!! You have created an account with email " + email + " and password " + password + "\n");
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
                        accountUI(account);
                    }
                }
                if (!found) System.out.println("The username/password combination does not exist");
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }

    void accountUI(Account account) {
        System.out.println("\nWelcome to your profile " + account.getEmail() + "!");
        System.out.println(WELCOME_MESSAGE_ACCOUNT);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1. View this Account's Users\n2. Create New User\n3. Login to User\n4. Logout\n");
            int ans = scan.nextInt();
            if (ans == 1) { // view users
                // TODO Return "No other users are registered on this account" if the list is null
                // TODO This method does not return the list of users
                for (RegisteredUser user : account.getUsers()) {
                    System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
                }
            }
            else if (ans == 2) { // create users
                System.out.println("Making a new User");
                System.out.println("What is the first name of your new user? ");
                String firstName = scan.next();
                System.out.println("What is the last name of your new user?");
                String lastName = scan.next();
                System.out.println("What is the DOB of your new user? Use format (MM/DD/YYYY)"); //TODO make sure that the user inputs the DOB in this format (maybe a helper method)
                String DOB = scan.next();
                System.out.println("What is the address of your new user?");
                String address = scan.nextLine();
                RegisteredUser user = new RegisteredUser(firstName, lastName, DOB, address, false, false, 0, 0.0, new ArrayList<Ticket>(), new ArrayList<String>(), new ArrayList<Pet>(), UUID.randomUUID().toString());
                while (true) {
                    System.out.println("Do you want to add any pets to this user? 1 = yes, 0 = no");
                    int temp = scan.nextInt();
                    if (temp == 1) {
                        System.out.println("What pet would you like to add?");
                        // TODO display the list of pets for the user to pick from
                        // TODO Implement adding pets to the user's account
                        String tempPet = scan.next();
                        boolean found = false;
                        while (!found) {
                            if (tempPet.equals("Dog")
                            || tempPet.equals("Cat")
                            || tempPet.equals("Lizard")
                            || tempPet.equals("Bird")
                            || tempPet.equals("Fish")
                            || tempPet.equals("Rodent")) {
                                found = true;
                            }
                            if (found) {
                                user.addPet(Pet.valueOf("tempPet"));
                            }
                            else {
                                System.out.println("That is not a valid pet, if you want to retry typing your pet type, enter \"1\", enter any other key to continue without entering your pet");
                                int tempInt = scan.nextInt();
                                if (tempInt != 1) {
                                    found = true;
                                }
                            }
                        }  
                    }
                    else if (temp == 0) {
                        break;
                    }
                    else {
                        System.out.println("Invalid input");
                    }
                }
            } 
            else if (ans == 3) { // login to user
                System.out.print("First name of user: ");
                String first = scan.next();
                System.out.print("Last name of user: ");
                String last = scan.next();
                for (RegisteredUser user : account.getUsers()) {
                    if ((user.getFirstName() + user.getLastName()).equals(first + last)) {
                        userUI(user);
                    }
                    else {
                        System.out.println("Incorrect Email/Password combination");
                    }
                }
            }
            else if (ans == 4) {
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }

    public void userUI(RegisteredUser user) {
        System.out.println("Hello " + user.getFirstName() + "  " + user.getLastName() + "!");
        System.out.println(WELCOME_MESSAGE_USER);
        System.out.println("1. Book Flight\n2. Book Hotel\n3. View Previous flights\n4. Blacklist an Airport\n5. Cancel Flight\n6. Change Name\n7. Logout\n");
        Scanner scan = new Scanner(System.in);
        int ans = scan.nextInt();
        boolean cont = true;
        while (cont) {
            switch(ans) {
                case 1: // book flight

                    break;
                case 2: // book hotel
                
                    break;
                case 3: // view previous flights
                    System.out.println("Previous flights: ");
                    for (Ticket flight : user.getPastReservation()) {
                        System.out.print(" Date: " + flight.getDepartDate() + " --- ");
                        for (int i = 0; i < flight.getLocations().size(); i++) {
                            System.out.print(flight.getLocations().get(i));
                            if (i < flight.getLocations().size()) {
                                System.out.print(" -> ");
                            }
                            else {
                                System.out.println();
                            }
                        }
                    }
                    break;
                case 4: // TODO blacklist an airport
                    break;
                case 5: // TODO cancel flight
                    // fill in later
                    break;
                case 6: // change name
                    String temp;
                    System.out.print("Enter new first name: ");
                    temp = scan.next();
                    user.setfirstName(temp);
                    System.out.print("Enter new last name: ");
                    temp = scan.next();
                    user.setlastName(temp);
                    break;
                case 7:
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
    
    public static void main(String[] args) {
        SystemUI temp = new SystemUI();
        temp.run();
    }
}