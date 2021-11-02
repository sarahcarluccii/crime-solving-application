import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A CrappUI
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class CrappUI {

    private static final String WELCOME_MESSAGE = "Welcome to CRAPP";
    private static final String ACTION = "The action was successful!";
	private String[] mainMenuOptions = {"MAIN MENU", "Make an Addition", "Make a Removal", "Search the Database", "Logout"};
    private String[] loginOptions = {"LOGIN OR REGISTER", "Login", "Register"};
    private String[] additionOptions = {"ADD TO THE DATABASE", "Add Crime", "Add Criminal", "Add Suspect", "Add Witness", "Add Person of Interest", "Add Victim"};
    private String[] removalOptions = {"REMOVE FROM THE DATABASE", "Remove Crime", "Remove Criminal", "Remove Suspect", "Remove Witness", "Remove Person of Interest", "Remove Victim"};
    private String[] searchOptions = {"SEARCH", "Search for a Crime", "Search for a Criminal"};
	private Scanner scanner;
	private CriminalApplication crapp;
    private boolean loginAttempt = false;
    private boolean loggedOut = false;

    /**
     * Creates a CrappUI
     */
    public CrappUI(){
		scanner = new Scanner(System.in);
		crapp = CriminalApplication.getInstance();
	}
    
    /**
     * Runs the front end of the application
     */
    public void run() {
        System.out.println(WELCOME_MESSAGE);

        while(!loginAttempt) {
            loginScreen();
        }

        while(!loggedOut) {
			mainMenu();
		}

        logOut();
    }

    /**
     * Displays and performs main menu operators for user
     */
    public void mainMenu() {
        menuOptions(mainMenuOptions);
			
        int input = promptUser(mainMenuOptions.length-1);
        
        if(input == -1) {
            System.out.println("Not a valid command");
        }

        if(input == mainMenuOptions.length-1) {
            System.out.println("Good bye, and have a nice day");
            loggedOut = true; //I think we need to create a logout method to save whatever is inputted
        }

        switch(input) {
            case(1):
                addition();
                break;
            case(2):
                removal();
                break;
            case(3):
                search();
                break;
        }
    }

    /**
     * Displays and performs addition operators for user
     */
    public void addition() {
        menuOptions(additionOptions);
        int input = promptUser(additionOptions.length-1);
        
        if(input == -1) {
            System.out.println("Not a valid command");
        }

        switch(input) {
            case(1):
                addCrime();
                break;
            case(2):
                addCriminal();
                break;
            case(3):
                addSuspect();
                break;
            case(4):
                addWitness();
                break;
            case(5):
                addPersonOfInterest();
                break;
            case(6):
                addVictim();
                break;
        }
    }
    
    public void addCrime() {
        System.out.println("Enter the Location: ");
        String location = scanner.nextLine();
        System.out.println("Enter the Date: ");
        String date = scanner.nextLine();
        System.out.println("Enter the Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the Type of Crime: ");
        String crimeType = scanner.nextLine();
        System.out.println("Enter the Severity: ");
        String severityInput = scanner.nextLine();
        int severity = Integer.parseInt(severityInput);
        System.out.println("Enter the Jurisdiction: ");
        String jurisdiction = scanner.nextLine();
        User userTemp= new User();
        ArrayList<User> detectives = new ArrayList<User>();
        int size = crapp.getCrimes().size();
        int id = crapp.getCrimes().get(size-1).getUuid()+1;
        for(User user : crapp.getUsers())
        {
            if(user.getUuid()==id){
                userTemp = user;
                detectives.add(user);
            }
        }    
        Crime temp = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, userTemp);
        crapp.addCrime(temp);
        System.out.println(ACTION);
    }

    public void addCriminal() {
        System.out.println("Enter the criminal's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the criminal's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the criminal's age: ");
        String ageInput = scanner.nextLine();
        int age = Integer.parseInt(ageInput);
        System.out.println("Enter the criminal's height (in inches): ");
        String heightInput = scanner.nextLine();
        int height = Integer.parseInt(heightInput);
        System.out.println("Enter the criminal's weight (in pounds): ");
        String weightInput = scanner.nextLine();
        int weight = Integer.parseInt(weightInput);
        System.out.println("Enter the criminal's skin color: ");
        String skinColor = scanner.nextLine();
        System.out.println("Enter the criminal's hair color: ");
        String hairColor = scanner.nextLine();
        System.out.println("Enter the criminal's eye color: ");
        String eyeColor = scanner.nextLine();
        System.out.println("Enter the criminal's address: ");
        String address = scanner.nextLine();
        User userTemp= new User();
        int size = crapp.getCriminals().size();
        int id = crapp.getCriminals().get(size-1).getUuid()+1;
        for(User user : crapp.getUsers())
        {
            if(user.getUuid()==id){
                userTemp = user;
                // add(user);
            }
        }    
        Criminal temp = new Criminal(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, userTemp);
        crapp.addCriminal(temp);
        System.out.println(ACTION);
    }

    public void addSuspect() {
        System.out.println("Enter the suspect's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the suspect's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter suspect's the age: ");
        String ageInput = scanner.nextLine();
        int age = Integer.parseInt(ageInput);
        System.out.println("Enter the suspect's height (in inches): ");
        String heightInput = scanner.nextLine();
        int height = Integer.parseInt(heightInput);
        System.out.println("Enter the suspect's weight (in pounds): ");
        String weightInput = scanner.nextLine();
        int weight = Integer.parseInt(weightInput);
        System.out.println("Enter the suspect's skin color: ");
        String skinColor = scanner.nextLine();
        System.out.println("Enter the suspect's hair color: ");
        String hairColor = scanner.nextLine();
        System.out.println("Enter the suspect's eye color: ");
        String eyeColor = scanner.nextLine();
        System.out.println("Enter the suspect's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the suspect's alibi: ");
        String alibi = scanner.nextLine();
        int size = crapp.getSuspects().size();
        int id = crapp.getSuspects().get(size-1).getUuid()+1;
        Suspect sus = new Suspect(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, alibi);
        crapp.getSuspects().add(sus);
        System.out.println(ACTION);
    }

    public void addWitness() {
        System.out.println("Enter witness first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter witness last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter witness age: ");
        String ageInput = scanner.nextLine();
        int age = Integer.parseInt(ageInput);
        System.out.println("Enter witness height (in inches): ");
        String heightInput = scanner.nextLine();
        int height = Integer.parseInt(heightInput);
        System.out.println("Enter witnesses weight (in pounds): ");
        String weightInput = scanner.nextLine();
        int weight = Integer.parseInt(weightInput);
        System.out.println("Enter witness skin color: ");
        String skinColor = scanner.nextLine();
        System.out.println("Enter witness hair color: ");
        String hairColor = scanner.nextLine();
        System.out.println("Enter witness eye color: ");
        String eyeColor = scanner.nextLine();
        System.out.println("Enter witness address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the witnesses phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter witness email: ");
        String email = scanner.nextLine();
        System.out.println("Enter witness story: ");
        String story = scanner.nextLine();
        int size = crapp.getWitnesses().size();
        int id = crapp.getWitnesses().get(size-1).getUuid()+1;
        Witness temp = new Witness(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email);
        temp.addStory(story);
        crapp.getWitnesses().add(temp);
        System.out.println(ACTION);
    }

    public void addPersonOfInterest() {
        System.out.println("Enter the person of interest's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the person of interest's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter person of interest's age: ");
        String ageInput = scanner.nextLine();
        int age = Integer.parseInt(ageInput);
        System.out.println("Enter the person of interest's height (in inches): ");
        String heightInput = scanner.nextLine();
        int height = Integer.parseInt(heightInput);
        System.out.println("Enter the person of interest's weight (in pounds): ");
        String weightInput = scanner.nextLine();
        int weight = Integer.parseInt(weightInput);
        System.out.println("Enter the person of interest's skin color: ");
        String skinColor = scanner.nextLine();
        System.out.println("Enter the person of interest's hair color: ");
        String hairColor = scanner.nextLine();
        System.out.println("Enter the person of interest's eye color: ");
        String eyeColor = scanner.nextLine();
        System.out.println("Enter the person of interest's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the person of interest's phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the person of interest's email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the person of interest's personal associations: ");
        //TODO fix this
        System.out.println("Enter the person of interest's association to the case: ");
        String associationToCase = scanner.nextLine();
        System.out.println("Enter the person of interest's association to suspect: ");
        String associationToSuspect = scanner.nextLine();
        int size = crapp.getPersonsOfInterest().size();
        int id = crapp.getPersonsOfInterest().get(size-1).getUuid()+1;
        Suspect suspectAssociatedTo = new Suspect(id);
        PersonOfInterest p = new PersonOfInterest(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, suspectAssociatedTo, associationToCase, associationToSuspect);
        crapp.getPersonsOfInterest().add(p);
        System.out.println(ACTION);
    }

    public void addVictim() {
        System.out.println("Enter the victim's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the victim's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter victim's age: ");
        String ageInput = scanner.nextLine();
        int age = Integer.parseInt(ageInput);
        System.out.println("Enter the victim's height (in inches): ");
        String heightInput = scanner.nextLine();
        int height = Integer.parseInt(heightInput);
        System.out.println("Enter the victim's weight (in pounds): ");
        String weightInput = scanner.nextLine();
        int weight = Integer.parseInt(weightInput);
        System.out.println("Enter the victim's skin color: ");
        String skinColor = scanner.nextLine();
        System.out.println("Enter the victim's hair color: ");
        String hairColor = scanner.nextLine();
        System.out.println("Enter the victim's eye color: ");
        String eyeColor = scanner.nextLine();
        System.out.println("Enter the victim's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the victim's phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the victim's email: ");
        String email = scanner.nextLine();
        System.out.println("Enter the victim's association to suspect: ");
        String associationToSuspect = scanner.nextLine();
        int size = crapp.getVictims().size();
        int id = crapp.getVictims().get(size-1).getUuid()+1;
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        crapp.getVictims().add(v);
        System.out.println(ACTION);
    }

    /**
     * Displays and performs removal operators for user
     */
    public void removal() {
        menuOptions(removalOptions);
        int input = promptUser(removalOptions.length-1);
        
        if(input == -1) {
            System.out.println("Not a valid command");
        }

        switch(input) {
            case(1):
                removeCrime();
                break;
            case(2):
                removeCriminal();
                break;
            case(3):
                removeSuspect();
                break;
            case(4):
                removeWitness();
                break;
            case(5):
                removePersonOfInterest();
                break;
            case(6):
                removeVictim();
                break;
        }
    }

    public void removeCrime() {
        int id = idPrompt("crime");
        Crime temp = crapp.getCrime(id);
        crapp.getCrimes().remove(temp);
        System.out.println(ACTION);
    }

    public void removeCriminal() {
        int id = idPrompt("criminal");
        Criminal temp = crapp.getCriminal(id);
        crapp.removeCriminal(temp);
        System.out.println(ACTION);
    }

    public void removeSuspect() {
        int id = idPrompt("suspect");
        Suspect temp = crapp.getSuspect(id);
        crapp.getSuspects().remove(temp);
        System.out.println(ACTION);
    }

    public void removeWitness() {
        int id = idPrompt("witness");
        Witness temp = crapp.getWitness(id);
        crapp.getWitnesses().remove(temp);
        System.out.println(ACTION);
    }

    public void removePersonOfInterest() {
        int id = idPrompt("person of interest");
        PersonOfInterest temp = crapp.getPersonOfInterest(id);
        crapp.getPersonsOfInterest().remove(temp);
        System.out.println(ACTION);
    }

    public void removeVictim() {
        int id = idPrompt("victim");
        Victim temp = crapp.getVictim(id);
        crapp.getVictims().remove(temp);
        System.out.println(ACTION);
    }

    /**
     * Displays and performs search operators for user
     */
    public void search() {
        menuOptions(searchOptions);
        int input = promptUser(searchOptions.length-1);
        
        if(input == -1) {
            System.out.println("Not a valid command");
        }

        // switch(input) {
        //     case(1):
        //         searchCrime();
        //     case(2):
        //         searchCriminal();
        // }
        if(input == 1) {
            searchCrime();
        } else {
            searchCriminal();
        }
    }

    public int idPrompt(String name) {
        System.out.println("Enter the ID for the " + name);
        String input = scanner.nextLine();
        int id = Integer.parseInt(input);
        return id;
    }

    public void searchCrime() {
        int id = idPrompt("crime");
        Crime temp = crapp.searchCrime(id);
        System.out.println(temp);
        writeToFile(temp);
        System.out.println(ACTION);
    }

    public void searchCriminal() {
        // int id = idPrompt("criminal");
        ArrayList<Criminal> temp = crapp.searchCriminal();
        System.out.println(temp);
        writeToFile(temp);
        System.out.println(ACTION);
    }

    /**
     * Prints the login/register screen
     * @return 
     */
    public void loginScreen() {
        menuOptions(loginOptions);
        int logOrReg = promptUser(2);
        if(logOrReg == 1)
        {
            login();
        }
        else if(logOrReg == 2)
        {
            register();
            login();
        }
        else {
            loginScreen();
        }
    }

    /**
     * Registers the user
     */
    public void register() {
        System.out.println("Enter your First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your Badge Number: ");
        String badgeNumber = scanner.nextLine();
        System.out.println("Enter your Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter your Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter your Precinct: ");
        String precinct = scanner.nextLine();
        System.out.println("Enter your Department: ");
        String department = scanner.nextLine();
        System.out.println("Enter your Rank: ");
        String rank = scanner.nextLine();
        System.out.println("Enter your Password: ");
        String password = scanner.nextLine();
        int size = crapp.getUsers().size();
        int id = crapp.getUsers().get(size-1).getUuid()+1;
        User user = new User(id, firstName, lastName, email, phoneNumber, precinct, department, badgeNumber, rank, password, null);
        crapp.addUser(user);
    }

    /**
     * The login for the user
     * @return Returns true if the login is successful and false otherwise
     */
    public void login() {
        System.out.println("Enter your Badge Number: ");
        String badgeNumber = scanner.nextLine();
        System.out.println("Enter your Password: ");
        String password = scanner.nextLine();
        for(User user : crapp.getUsers()) {
            if(user.getBadgeNumber().equals(badgeNumber) && user.getPassword().equals(password)) {
                loginAttempt = true;
                break;
            }
        }
        // loginAttempt = false;
    }

    /**
     * Displays the given menu
     */
    public void menuOptions(String[] arr) {
        System.out.println("******** "+arr[0]+" ********");
        for(int i=1;i<arr.length;i++) {
            System.out.println((i) + ". " + arr[i]);
        }
        System.out.println("\n");
    }

    /**
     * Asks the user to choose between a list of options
     * @param numOfCommands The size of the list of options
     * @return The choice if it is valid and -1 otherwise
     */
    public int promptUser(int numOfCommands) {
        System.out.println("Choose an option: ");
        String input = scanner.nextLine();
        int choice = Integer.parseInt(input);
        if(choice > 0 && choice <= numOfCommands) {
            return choice;
        }
        return -1;
    }

    public void writeToFile(Object o) {
        try {
            System.out.println("Would you like to print to a txt file? (y/n)");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("y")) {
                System.out.println("What would you like to name the file?");
                String fileName = "text/" + scanner.nextLine() + ".txt";
                FileWriter writer = new FileWriter(fileName, false);
                writer.write(o.toString());
                writer.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Will save the what ever was done to the json files
     */
    public void logOut() {
        DataWriter.saveUsers();
        DataWriter.saveCrimes();
        DataWriter.saveCriminals();
        DataWriter.saveEvidences();
        DataWriter.saveSuspects();
        DataWriter.saveVictims();
        DataWriter.saveWitnesses();
        DataWriter.savePOIs();
    }

    /**
     * Main method for the front end of the application
     * @param args Any arguments passed through the compiler
     */
    public static void main(String[] args) {
        CrappUI crappui = new CrappUI();
        crappui.run();
    }
}
