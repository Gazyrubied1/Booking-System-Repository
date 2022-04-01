import java.util.*;
import java.io.*;

public class SystemUI {
    private static final String WELCOME_MESSAGE_SYSTEM = "Welcome to our flight booking system!\n\n*********** Main Menu **************";
    private static final String WELCOME_MESSAGE_ACCOUNT = "********* Account Menu ************";
    private static final String WELCOME_MESSAGE_USER = "********** User's Menu *************";
    public String[] states = {"AL", "MT", "AK", "NE", "AZ", "NV", "AR", "NH", "CA", "NJ", "CO", "NM", "CT", "NY", "DE", "NC", "FL", "ND", "GA", "OH", "HI", "OK", "ID", "OR", "IL", "PA", "IN", "RI", "IA", "SC", "KS", "SD", "KY", "TN", "LA", "TX", "ME", "UT", "MD", "VT", "MA", "VA", "MI", "WA", "MN", "WV", "MS", "WI", "MO", "WY"};
    ArrayList<Account> accounts;
    BookHotel bookHotel;  // holds the hotels & rooms
    BookFlight bookFlight;  // holds the flighs

    /**
     * Constructor for the UI class
     */
    SystemUI() {
        accounts = new ArrayList(); // this should be loaded from the JSON here
        ArrayList<Flight> flights = new ArrayList<>();
        flights = GenerateFilght.Generateflight();
        ArrayList<Hotels> hotels = new ArrayList<>();
        hotels = GenerateHotel.GenerateRooms();
        // 
    }

    /**
     * Opens the main System UI
     */
    public void run() {
        System.out.println(WELCOME_MESSAGE_SYSTEM);

        while (true) {
            System.out.println("1. Login to an existing account\n2. Create an account\n3. Search Flights\n4. Search hotels\n5. Logout\n");

            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();
            if (answer == 5) break;
            else if (answer == 4) { // search hotels
                // BookHotel hotels = new BookHotel(); old codt
                System.out.println("Do you want to search hotels by:\n1) Name of hotel\n2) State the hotel is in\n3)Both");
                int ans = scan.nextInt();
                switch(ans) {
                    case 1: // search hotels by brand
                        boolean cont = true;
                        String brand;
                        String temp;
                        while (cont) {
                            System.out.println("What hotel brand do you want to search for? (Choose from Marriott, Hilton, Wyndham, Hyatt)");
                            brand = scan.next();
                            if (brand.equals("Marriott") 
                            || brand.equals("Hilton")
                            || brand.equals("Wyndham")
                            || brand.equals("Hyatt")) {
                                bookHotel.SearchHotel(brand);
                            }
                            else {
                                System.out.println("The hotel brand that you entered is not one of our supported brands. Type \'1\' to retry or any other key to exit.");
                                temp = scan.next();
                                if (!temp.equals("1")) cont = false;
                            }
                        }
                        break;
                    case 2: // seach hotels by state (check over this)
                        System.out.println("What state do you want to search for hotels in? (Use state abbreviation)");
                        String state = scan.next();
                        System.out.println("Below are all hotels in " + state + ": ");
                        bookHotel.SearchHotel(state);
                        break;
                    case 3: // search hotels by state and brand
                        System.out.println("What state do you want to search for hotels in? (Use state abbreviation)");
                        state = scan.next();
                        System.out.println("What hotel brand do you want to search for? (brands: Marriott, Hilton, Wyndham, Hyatt)");
                        brand = scan.next();
                        System.out.println("Below are all " + brand + " hotels in " + state);
                        bookHotel.SearchHotel(state, brand);
                        break;
                }
            }
            else if (answer == 3) { // search flights
                //figure out how to search through existing flights using BookFlights
                System.out.println("What date do you want the flight to leave on? ");
                String date = scan.next(); // date is not used in calling searchLocation (Change that)
                System.out.println("What is your starting location? (Use state abbreviation)");
                String startLoc = scan.next();
                System.out.println("What is your preferred destination state? (Use state abbreviation)");
                String endLoc = scan.next();
                // BookFlight flights = new BookFlight(); old code
                bookFlight.searchLocation(startLoc, endLoc, new ArrayList<String>()); // check over this
            }
            else if (answer == 2) { // create account
                System.out.println("Please enter the following information to create an account:");
                System.out.println("Email Address: ");
                String email = scan.next();
                System.out.println("Password");
                String password = scan.next();
                accounts.add(new Account(UUID.randomUUID().toString(), email, password, new ArrayList<RegisteredUser>()));
                System.out.println("\nCongratulations!! You have created an account with email " + email + " and password " + password);
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

    /**
     * Runs the UI for each user that is logged into
     * @param account the account that the UI is accessing
     */
    void accountUI(Account account) {
        System.out.println("\nWelcome to your profile " + account.getEmail() + "!");
        System.out.println(WELCOME_MESSAGE_ACCOUNT);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n1. View this account's users\n2. Create user\n3. login to user\n4. Logout\n");
            int ans = scan.nextInt();
            if (ans == 1) { // view users
                if (account.getUsers().size() == 0) System.out.println("You currently have no users on this account."); // replace this with JSON
                for (RegisteredUser user : account.getUsers()) { 
                    System.out.println("User's name: " + user.getFirstName() + " " + user.getLastName() + " date of birth: " + user.getDateOfBirth());
                }
            }
            else if (ans == 2) { // create users
                System.out.println("Making a new User");
                System.out.println("What is the first name of your new user? ");
                String firstName = scan.next();
                System.out.println("What is the last name of your new user?");
                String lastName = scan.next();
                System.out.println("What is the DOB of your new user? Use format (MM/DD/YYYY)");
                String DOB = scan.next();
                System.out.println("What is the address of your new user?");
                String address = scan.nextLine(); // for some reason this gets skipped
                RegisteredUser user = new RegisteredUser(firstName, lastName, DOB, address, false, false, 0, 0.0 , new ArrayList<String>(), new ArrayList<Pet>(), UUID.randomUUID().toString());
                account.addUser(firstName, lastName, DOB, address); // add json to this
                while (true) {
                    System.out.println("Do you want to add any pets to this user? 1 = yes, 0 = no");
                    int temp = scan.nextInt();
                    if (temp == 1) {
                        System.out.println("What pet do you want to add? (dog, cat, lizzard, bird, fish, or rodent)");
                        String tempPet = scan.next();
                        boolean found = false;
                        while (!found) {
                            if (tempPet.equals("dog")
                            || tempPet.equals("cat")
                            || tempPet.equals("lizzard")
                            || tempPet.equals("bird")
                            || tempPet.equals("fish")
                            || tempPet.equals("rodent")) {
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

    /**
     * UI that allows the user to make descisions on their reservations
     * @param user the user that will be modified by the UI
     */
    public void userUI(RegisteredUser user) {
        boolean cont = true;
        while (cont) {
            System.out.println("\nHello " + user.getFirstName() + "  " + user.getLastName() + "!");
            System.out.println(WELCOME_MESSAGE_USER + "\n");
            System.out.println("1. Book Flight\n2. Book Hotel\n3. View previous flights\n4. Blacklist an airport\n5. Remove a flight from blacklisted list\n6. Cancel flight\n7. Change name\n8. Add pet\n9. View pets\n10. Logout\n");
            Scanner scan = new Scanner(System.in);
            int ans = scan.nextInt();
            switch(ans) {
                case 1: // book flight
                    // BookFlight flights = new BookFlight(); //old code
                    boolean conts = true;
                    ArrayList<Flight> usersFlights = new ArrayList();
                    while (conts) {
                        System.out.println("What is your starting location? (Please enter only the state's abbreviation)");
                        String startLoc = scan.next();
                        System.out.println("What is your destination? (Please enter only the state's abbreviation)");
                        String endLoc = scan.next();
                        // System.out.println("What is your preffered arrival date? "); // idk how im going to check this
                        // String date = scan.next();
                        System.out.println("These are the flights that match your specifications: ");
                        //usersFlights = bookFlight.searchLocation(startLoc, endLoc, user.getBlackList());
                        ArrayList<String> airports = new ArrayList();
                        airports.add("Columbia Metro Airport");
                        airports.add("Charlotte Douglas International Airport"); 
                        for (int i = 0; i < airports.size(); i++) {
                            System.out.print((i+1) + ". ");
                            System.out.println(airports.get(i));
                        }
                        // for (int i = 0; i < usersFlights.size(); i++) { works with JSON only
                        //     System.out.print((i+1) + ". "); 
                        //     usersFlights.get(i).print();
                        //     System.out.println();
                        // }
                        System.out.println("Do you want to change any of your specifications? 1 == yes, 0 == no");
                        String temp = scan.next();
                        System.out.println("Which flight do you want to book? ");
                        int answer = scan.nextInt();
                        if (!temp.equals("1")) {
                            //if (answer < usersFlights.size() && usersFlights.get(answer-1).getNumOfSeats() > 0) { // if the flight is not full needs JSON
                            if (true) {
                                ArrayList<RegisteredUser> tempUser = new ArrayList();
                                tempUser.add(user); 
                                //bookFlight.bookFlight(usersFlights.get(answer-1), tempUser); requires JSON bookFlight is never instantiated
                                ArrayList<seat> CurrSeats = new ArrayList();
                                CurrSeats.add(new seat('a',1));
                                CurrSeats.add(new seat('b', 1));
                                ArrayList<Flight> idkBro = new ArrayList<>();
                                idkBro.add(new Flight(airports, 60, "some random date", new seats(CurrSeats), 100, UUID.randomUUID().toString()));
                                BookFlight flights = new BookFlight(idkBro);
                                Ticket tik = flights.bookFlight(new Flight(airports, 60, "some random date", new seats(CurrSeats), 100, UUID.randomUUID().toString()), tempUser); 
                                conts = false;
                                System.out.println("Do you want to print an iternary of your flight in a .txt file? (1 == yes, 0 == no)");
                                int tempAns = scan.nextInt();
                                if (tempAns == 1) {
                                    tik.print();
                                }
                            }
                            else {
                                System.out.println("Sorry, this flight is full, please book another one.");
                            }
                        }
                    }
                    break;
                case 2: // book hotel
                    // BookHotel hotels = new BookHotel(); old code
                    cont = true;
                    while (cont) {
                        System.out.println("What state do you want to book a hotel in?");
                        String state = scan.next();
                        boolean contains = true; // temporary
                        //boolean contains = false;
                        // for (int i = 0; i < states.length; i++) { // idk if this runs an error
                        //     if (states[i].equals(state)) contains = true;
                        // }
                        if (contains) { // state is valid
                            bookHotel = new BookHotel(HotelList)
                            bookHotel.BookHotelRoom(bookHotel.SearchHotel(state), user);
                            cont = false;
                        }
                        else {
                            System.out.println("Invalid input. Do you want to retry? ( 1 == yes, any other key == no)");
                            int reponse = scan.nextInt();
                            if (reponse != 1) cont = false;
                        }
                    }
                    break;
                case 3: // view previous flights
                    System.out.println("Previous flights: ");
                    for (Ticket flight : user.getPastReservation()) {
                        System.out.print("Date: " + flight.getDepartDate() + " --- ");
                        for (int i = 0; i < flight.getLocations().size(); i++) {
                            System.out.print(flight.getLocations().get(i));
                            if (i < flight.getLocations().size()-1) {
                                System.out.print(" -> ");
                            }
                            else {
                                System.out.println();
                            }
                        }
                    }
                    break;
                case 4: // blacklist an airport
                    System.out.println("To blacklist airports, enter the state abbreviation of the state that you want to blacklist. (Enter \'-1\' to exit without blacklisting an airport)");
                    String state = scan.next();
                    if (state.equals("-1")) break;
                    user.blacklistAirport(state);
                    break;
                case 5:
                    System.out.println("These are your blacklisted flights: " + user.getBlackList());
                    break;
                case 6: // cancel flight
                    System.out.println("These are your future flights: ");
                    int cnt = 1;
                    for (int i = 0; i < user.getPastFlights().size(); i++) {
                        Ticket ticket = user.getPastFlights().get(i);
                        if (ticket.isFlight()) { // add parameter to check for date and make sure that the flight is booked for the future
                            System.out.print((cnt+1) + ". ");
                            ticket.printInfo();
                            cnt++;
                        }
                    }
                    System.out.print("Enter the number of the flight that you want to cancel. (Enter -1 to exit without canceling a flight.)");
                    int temps = scan.nextInt();
                    if (temps == -1) break;
                    cnt = 1;
                    for (int i = 0; i < user.getPastFlights().size(); i++) { // really inefficent way of retrieving the flight that the user wants, but it works
                        Ticket ticket = user.getPastFlights().get(i);
                        if (ticket.isFlight()) {
                            if (cnt == temps) {
                                user.cancelFlight(user.getPastFlights().get(temps-1));
                                break;
                            }
                            cnt++;
                        }
                    }
                    break;
                case 7: // change name
                    String temp;
                    System.out.print("Enter new first name: ");
                    temp = scan.next();
                    user.setfirstName(temp);
                    System.out.print("Enter new last name: ");
                    temp = scan.next();
                    user.setlastName(temp);
                    break;
                case 8: // add pet
                    System.out.println("What pet do you want to add? You can add a dog, cat, lizzard, bird, fish, or rodent");
                    String tempPet = scan.next();
                    boolean found = false;
                    while (!found) {
                        if (tempPet.equals("dog")
                        || tempPet.equals("cat")
                        || tempPet.equals("lizzard")
                        || tempPet.equals("bird")
                        || tempPet.equals("fish")
                        || tempPet.equals("rodent")) {
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
                    break;
                case 9: // view pets
                    user.printPets();
                    break;
                case 10: // logout
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