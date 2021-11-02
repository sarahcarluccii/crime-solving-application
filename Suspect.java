import java.util.ArrayList;

/**
 * A Suspect
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class Suspect extends Person{

    private static Suspect suspects;
    private ArrayList<Suspect> suspectList;


    private boolean hasTattoos;
    private ArrayList<String> tattoos;
    private ArrayList<String> aliases;
    private ArrayList<Person> associates;
    private ArrayList<Crime> pastCrimes;
    private ArrayList<Evidence> evidence;
    private String alibi;

    /**
     * @param id an identifier for the suspect
     * @param firstName first name of the suspect
     * @param lastName last name of the suspect
     * @param age age of the suspect
     * @param height height of the suspect
     * @param weight weight of the suspect
     * @param skinColor skin color of the suspect
     * @param hairColor hair color of the suspect
     * @param eyeColor eye color of the suspect
     * @param address address of the suspect
     * @param alibi alibi of the suspect
     */
    public Suspect(int id, String firstName, String lastName, int age, int height, int weight, String skinColor,
            String hairColor, String eyeColor, String address, String alibi) {
        super(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address);
        setAlibi(alibi);
        tattoos = new ArrayList<String>();
        aliases = new ArrayList<String>();
        associates = new ArrayList<Person>();
        pastCrimes = new ArrayList<Crime>();
        evidence = new ArrayList<Evidence>();
    }

    /**
     * Empty Suspect Constructor
     */
    public Suspect() {
        
    }

    public Suspect(int id) {
        this.id = id;
    }
    
    /**
     * Adds a tattoo to the list of tattoos
     * @param tattoos tattoos of the suspect
     */
    public void addTattoo(String tattoos) {
        this.tattoos.add(tattoos);
    }

    /**
     * Returns the tattoos of the suspect
     * @return The tattos
     */
    public String getTattoo() {
        if(tattoos.size() == 0) {
            return "";
        }
        return tattoos.get(tattoos.size() - 1);
    }

    /**
     * Returns true if tattos are present on the suspect
     * @return The tattos
     */
    public boolean getHasTattoos() {
        if(tattoos.size() > 0) {
            hasTattoos = true;
        }
        return hasTattoos;
    }

    /**
     * Adds an alias to the list of alias
     * @param aliases alias of the suspect
     */
    public void addAlias(String aliases) {
        this.aliases.add(aliases);
    }

    /**
     * Returns the aliases of the suspect
     * @return The alias
     */
    public String getAlias() {
        return aliases.get(aliases.size() - 1);
    }

    /**
     * Adds an associate to the list of associates
     * @param associates associate of the suspect
     */
    public void addAssociate(Person person) {
        associates.add(person);
    }

    /**
     * Adds a crime to the list of past crimes
     * @param crime past crimes of the suspect
     */
    public void addCrime(Crime crime) {
        pastCrimes.add(crime);
    }

    /**
     * Returns list of past crimes 
     * @param pastCrimes past crimes of the suspect
     */
    public ArrayList<Crime> getCrimes() {
        return pastCrimes;
    }

    /**
     * Loads the past Crimes that the Suspect has committed
     */
    public void loadPastCrimes() {
        for(Crime crimes: CriminalApplication.getInstance().getCrimes()){
            for(Criminal criminals: crimes.getCriminals()) {
                if(criminals.getUuid() == id) {
                    pastCrimes.add(crimes);
                }
            }
        }
    }

    /**
     * Removes a crime to the list of past crimes
     * @param pastCrimes crimes of the suspect
     */
    public void removeCrime(Crime crime){
        pastCrimes.remove(crime);
    }

    /**
     * Adds evidence to the list of evidence
     * @param evidence evidence related to suspect
     */
    public void addEvidence(Evidence evidence) {
        this.evidence.add(evidence);
    }

    /**
     * Returns the alibi of the suspect
     * @return The alibi
     */
    public String getAlibi() {
        return this.alibi;
    }

    /**
     * Sets the alibis of the suspect
     * @param alibi alibi of the suspect
     */
    public void setAlibi(String alibi) {
        this.alibi = alibi;
    }
    
    /**
     * Returns a string of the variables
     * @return The string of variables
     */
    public String toString() {
        loadPastCrimes();
        String str = "ID: " + id + "\n\tName: " + firstName + " " + lastName + "\n\tAge: " + age + "\n\tHeight: " + height + " inches\n\tWeight: " + weight + " lbs.\n\tSkin Color: " + skinColor
        + "\n\tHair Color: " + hairColor + "\n\tEye Color: " + eyeColor + "\n\tAddress: " + address;
        String tatt = "";
        String ali = "";
        String assoc = "";
        String crimes = "";
        String evid = "";
        for(String t: tattoos) {
            if(t.equals(tattoos.get(tattoos.size()-1))) {
                tatt = t + tatt;
            }
            else {
                tatt = t + ", " + tatt;
            }
        }
        for(String a: aliases) {
            if(a.equals(aliases.get(aliases.size()-1))) {
                ali = a + ali;
            }
            else {
                ali = a + ", " + ali;
            }
        }
        for(Person p: associates) {
            if(p.equals(associates.get(associates.size()-1))) {
                assoc = assoc + p.getFirstName() + " " + p.getLastName();
            }
            else {
                assoc = assoc + p.getFirstName() + " " + p.getLastName() + ", ";
            }
        }
        for(Crime c: pastCrimes) {
            if(c.equals(pastCrimes.get(pastCrimes.size()-1))) {
                crimes = crimes + c.getCrimeType();
            }
            else {
                crimes = crimes + c.getCrimeType() + ", ";
            }
        }
        for(Evidence e: evidence) {
            if(e.equals(evidence.get(evidence.size()-1))) {
                evid = evid + e.getEvidenceType();
            }
            else {
                evid = evid + e.getEvidenceType() + ", ";
            }
        }
        if(!assoc.equals("")) {
            str = str + "\n\tAssociates: " + assoc;
        }
        if(!ali.equals("")) {
            str = str + "\n\tAliases: " + ali;
        }
        if(!tatt.equals("")) {
            str = str + "\n\tTattoos: " + tatt;
        }
        str = str + "\n\tCrimes Committed: " + crimes;
        str = str + "\n\tEvidence Found: " + evid;
        str = str + "\n\tAlibi: " + alibi;
        return str;
    }
}
