// import org.graalvm.compiler.nodes.virtual.EnsureVirtualizedNode;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

/**
 * A Criminal Application
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class CriminalApplication {
    
    private static CriminalApplication crapp;
    private ArrayList<Criminal> criminals;
    private ArrayList<Witness> witnesses;
    private ArrayList<Suspect> suspects;
    private ArrayList<Victim> victims;
    private ArrayList<PersonOfInterest> personsOfInterest;
    private ArrayList<Evidence> evidences;
    private ArrayList<Crime> crimes;
    private ArrayList<User> users;

    /**
     * Creates a Criminal Application
     */
    private CriminalApplication() {
        // criminals = new ArrayList<Criminal>();
        // witnesses = new ArrayList<Witness>();
        // suspects = new ArrayList<Suspect>();
        // victims = new ArrayList<Victim>();
        // personsOfInterest = new ArrayList<PersonOfInterest>();
        // evidences = new ArrayList<Evidence>();
        // crimes = new ArrayList<Crime>();
        // users = new ArrayList<User>();
        criminals = null;
        witnesses = null;
        suspects = null;
        victims = null;
        personsOfInterest = null;
        evidences = null;
        crimes = null;
        users = null;
    }

    /**
     * Returns an instance of the static Criminal Application
     * @return The Criminal Application
     */
    public static CriminalApplication getInstance() {
        if(crapp == null) {
            crapp = new CriminalApplication();
        }
        return crapp;
    }

    /**
     * Gets the crimes. Will make DataLoader methods work better
     */
    public ArrayList<Crime> loadCrimes() {
        crimes = DataLoader.getCrimes();
        return crimes;
    }

    /**
     * Loads the users
     */
    public ArrayList<User> loadUsers() {
        users = DataLoader.getUsers();
        return users;
    }

    /**
     * Loads the criminals
     */
    public ArrayList<Criminal> loadCriminals() {
        criminals = DataLoader.getCriminals();
        return criminals;
    }
    
    /**
     * Loads the Witnesses
     */
    public ArrayList<Witness> loadWitnesses() {
        witnesses = DataLoader.getWitnesses();
        return witnesses;
    }
    
    /**
     * Loads the Suspects
     */
    public ArrayList<Suspect> loadSuspects() {
        suspects = DataLoader.getSuspects();
        return suspects;
    }
    
    /**
     * Loads the Victims
     */
    public ArrayList<Victim> loadVictims() {
        victims = DataLoader.getVictims();
        return victims;
    }
    
    /**
     * Loads the Persons of Interest
     */
    public ArrayList<PersonOfInterest> loadPOIs() {
        personsOfInterest = DataLoader.getPOIs();
        return personsOfInterest;
    }
        
    /**
     * Loads the Evidence
     */
    public ArrayList<Evidence> loadEvidences() {
        evidences = DataLoader.getEvidences();
        return evidences;
    }

    /**
     * Gets the evidence
     * @return The evidence in the system
     */
    public ArrayList<Evidence> getEvidence() {
        if(evidences == null) {
            evidences = loadEvidences();
        }
        return evidences;
    }

    /**
     * Adds a criminal to the list of criminals
     * @param criminal Criminal for a crime
     */
    public void addCriminal(Criminal criminal) {
        criminals.add(criminal);
    }

    /**
     * Returns the criminals associated with a crime
     * @return The criminals
     */
    public ArrayList<Criminal> getCriminals() {
        if(criminals == null){
            criminals = loadCriminals();
        }
        return criminals;
    }

    /**
     * Returns a criminal associated with a crime given an id
     * @param id Identifier for the criminal
     * @return The criminal
     */
    public Criminal getCriminal(int id) {
        if(criminals == null){
            criminals = loadCriminals();
        }
        for(Criminal criminal: criminals) {
            if(criminal.getUuid() == id) {
                return criminal;
            }
        }
        return null;
    }

    /**
     * Removes a criminal from the list of criminals
     * @param criminal Criminal for a crime
     * @return Returns true if the criminal is succesfully removed and false otherwise
     */
    public boolean removeCriminal(Criminal criminal) {
       return criminals.remove(criminal);
    }

    /**
     * Returns the length of the criminal list
     * @return Length of the list
     */
    public int criminalLength() {
        return criminals.size();
    }

    /**
     * Searches for criminals
     * @param id UUID of the criminal
     * @return The criminal searched for
     */
    public Criminal searchCriminal(int id) {
        if(criminals == null) {
            criminals = loadCriminals();
        }
        for(Criminal criminal: criminals) {
            if(criminal.getUuid()==id) {
                return criminal;
            }
        }
        return null;
    }
    
    /**
     * Searches for criminals based on certain category
     * @param search is what you are searching for
     * @param category is the catergory to search for it under
     * @return The criminal searched for
     */
    public ArrayList<Criminal> searchCriminal() {
        if(criminals == null) {
            criminals = loadCriminals();
        }
		Scanner scanner = new Scanner(System.in);
        System.out.println("Please select category for search: (ID, Name, Age, Height, Skin Color, Hair Color, Tattoos)");
        String category = scanner.nextLine();
        ArrayList<Criminal> crims = new ArrayList<Criminal>();
        boolean done = false;
        while(!done){
            if(category.equalsIgnoreCase("ID")) {
                System.out.print("Search: ");
                String search = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getUuid() == Integer.parseInt(search)) {
                        crims.add(criminal);
                    }
                }
            }
            else if(category.equalsIgnoreCase("Name")) {
                System.out.print("Search: ");
                String search = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getName().equalsIgnoreCase(search)) {
                        crims.add(criminal);
                    }
                }
            }
            else if(category.equalsIgnoreCase("Age")) { //Age range would be better
                System.out.print("Lower Bound: ");
                String lower = scanner.nextLine();
                System.out.print("Upper Bound: ");
                String upper = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getAge() > Integer.parseInt(lower) && criminal.getAge() < Integer.parseInt(upper)) {
                        crims.add(criminal);
                    }
                }
            }
            else if(category.equalsIgnoreCase("Height")) {
                System.out.print("Search: ");
                String search = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getHeight() == Integer.parseInt(search)) {
                        crims.add(criminal);
                    }
                }
            }
            else if(category.equalsIgnoreCase("Skin Color")) {
                System.out.print("Search: ");
                String search = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getSkinColor().equalsIgnoreCase(search)) {
                        crims.add(criminal);
                    }
                }
            }
            else if(category.equalsIgnoreCase("Hair Color")) {
                System.out.print("Search: ");
                String search = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getHairColor().equalsIgnoreCase(search)) {
                        crims.add(criminal);
                    }
                }
            }
            else if(category.equalsIgnoreCase("Tattoos")) {
                System.out.print("Search: ");
                String search = scanner.nextLine();
                for(Criminal criminal: criminals) {
                    if(criminal.getTattoo().equalsIgnoreCase(search)) {
                        crims.add(criminal);
                    }
                }
            }
            else {
                System.out.println("Invalid Response. Try again");
                System.out.println("Please select a category for search: (ID, Name, Age, Height, Skin Color, Hair Color, Tattoos");
                category = scanner.nextLine();
                searchCriminal();                
            }
            for(int i = 0; i < crims.size(); i++) {
                for(int j = i + 1; j < crims.size(); j++) {
                    if(crims.get(i) == crims.get(j)) {
                        crims.remove(j);
                    }
                }
            }
            if(crims.size() == 0) {
                System.out.println("No match. Would you like to do another search? (y/n)");
                String answer = scanner.nextLine();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Please select a category for search: (ID, Name, Age, Height, Skin Color, Hair Color, Tattoos");
                    category = scanner.nextLine();
                    searchCriminal();
                }
                else {
                    done = true;
                }
            }
            else {
                System.out.println("We found " + crims.size() + " results. Would you like to narrow your search? (y/n)");
                String answer = scanner.nextLine();
                if(answer.equalsIgnoreCase("y")) {
                    System.out.println("Please select a new category for search: (ID, Name, Age, Height, Skin Color, Hair Color, Tattoos");
                    category = scanner.nextLine();
                }
                else {
                    done = true;
                }
            }
        }
        return crims;
    }

    /**
     * Adds a witness to the list of witnesses
     * @param witness Witness for a crime
     */
    public void addWitness(Witness witness) {
        witnesses.add(witness);
    }

    /**
     * Gets the list of Witnesses
     * @return The witnesses in the system
     */
    public ArrayList<Witness> getWitnesses() {
        if(witnesses == null);  {
            witnesses = loadWitnesses();
        }
        return witnesses;
    }

    /**
     * Returns the witnesses of a crime
     * @param id Identifier for the witness
     * @return The witnesses
     */
    public Witness getWitness(int id) {
        if(witnesses == null);  {
            witnesses = loadWitnesses();
        }
        for(Witness witness: witnesses) {
            if(witness.getUuid() == id) {
                return witness;
            }
        }
        return null;
    }

    /**
     * Gets the list of Suspects
     * @return The suspects in the system.
     */
    public ArrayList<Suspect> getSuspects() {
        if(suspects == null) {
            suspects = loadSuspects();
        }
        return suspects;
    }

    /**
     * Adds a suspect to the list of suspect
     * @param suspect suspect for a crime
     */
    public void addSuspect(Suspect suspect) {
        suspects.add(suspect);
    }

    /**
     * Returns the suspects of a crime
     * @param id Identifier for the suspect
     * @return The suspects
     */
    public Suspect getSuspect(int id) {
        if(suspects == null) {
            suspects = loadSuspects();
        }
        for(Suspect suspect: suspects) {
            if(suspect.getUuid() == id) {
                return suspect;
            }
        }
        return null;
    }

    /**
     * Gets the list of Victims
     * @return The victims in the system
     */
    public ArrayList<Victim> getVictims() {
        if(victims == null) {
            victims = loadVictims();
        }
        return victims;
    }

    /**
     * Adds a victim to the list of victims
     * @param victim Victim for a crime
     */
    public void addVictim(Victim victim) {
        victims.add(victim);
    }   

    /**
     * Returns the victims of a crime
     * @param id Identifier for the victim
     * @return The victims
     */
    public Victim getVictim(int id) {
        if(victims == null) {
            victims = loadVictims();
        }
        for(Victim victim: victims) {
            if(victim.getUuid() == id) {
                return victim;
            }
        }
        return null;
    }

    /**
     * Adds a person of interest to the list of people of interest
     * @param personOfInterest Person of interest for a crime
     */
    public void addPersonOfInterest(PersonOfInterest personOfInterest) {
        this.personsOfInterest.add(personOfInterest);
    }
    
    /**
     * Returns the people of interest for a crime
     * @return The people of interest
     */
    public ArrayList<PersonOfInterest> getPersonsOfInterest() {
        if(personsOfInterest == null) {
            personsOfInterest = loadPOIs();
        }
        return personsOfInterest;
    }

    /**
     * Returns a person of interest for a crime given an id
     * @param id Identifier for the person of interest
     * @return The person of interest
     */
    public PersonOfInterest getPersonOfInterest(int id) {
        if(personsOfInterest == null) {
            personsOfInterest = loadPOIs();
        }
        for(PersonOfInterest personOfInterest: personsOfInterest) {
            if(personOfInterest.getUuid() == id) {
                return personOfInterest;
            }
        }
        return null;
    }

    /**
     * Adds a piece of evidence to the list of evidence
     * @param evidence Evidence for a crime
     */
    public void addEvidence(Evidence evidence) {
        evidences.add(evidence);
    }

    /**
     * Returns the evidence for a crime given an id
     * @param id Identifier for the evidence
     * @return The evidence
     */
    public Evidence getEvidence(int id) {
        if(evidences == null) {
            evidences = loadEvidences();
        }
        for(Evidence evidence: evidences) {
            if(evidence.getUuid() == id) {
                return evidence;
            }
        }
        return null;
    }

    /**
     * Adds a crime to the list of crimes
     * @param crime A crime
     */
    public void addCrime(Crime crime) {
        crimes.add(crime);
    }

    /**
     * Returns a list of crimes
     * @return The crimes
     */
    public ArrayList<Crime> getCrimes() {
        if(crimes == null) {
            crimes = loadCrimes();
        }
        return crimes;
    }

    /**
     * Returns a crime given an id
     * @param id Identifier for the crime
     * @return The crime
     */
    public Crime getCrime(int id) {
        if(crimes == null) {
            crimes = loadCrimes();
        }
        for(Crime crime: crimes) {
            if(crime.getUuid() == id) {
                return crime;
            }
        }
        return null;
    }

    /**
     * Returns the length of the list of crimes
     * @return The length of the list
     */
    public int crimeLength() {
        return crimes.size();
    }

    /**
     * Adds a user to the list of users
     * @param user A user
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Returns a list of users
     * @return The users
     */
    public ArrayList<User> getUsers() {
        if(users == null) {
            users = loadUsers();
        }
        return users;
    }

    /**
     * Returns a user given an id
     * @param id Identifier for the user
     * @return The user
     */
    public User getUser(int id) {
        if(users == null) {
            users = loadUsers();
        }
        for(User user: users) {
            if(user.getUuid() == id) {
                return user;
            }
        }
        return null;
    }

    /**
     * Searches for crime
     * @param id UUID for the crime
     * @return The crime searched for
     */
    public Crime searchCrime(int id) {
        if(crimes == null) {
            crimes = loadCrimes();
        }
        for(Crime crime: crimes) {
            if(crime.getUuid()==id) {
                return crime;
            }
        }
        return null;
    }

    /**
     * Returns a list of criminals ranked
     * @return The list of criminals
     */    
    public ArrayList<Criminal> rankCriminals() {
        for(Criminal criminal : criminals) {
            criminal.getSeverity();
        }
        return criminals;
    }

}
