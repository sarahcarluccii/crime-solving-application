import java.util.ArrayList;
/**
 * A Crime
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class Crime {
    
    private String location;
    private String date;
    private String description;
    private String crimeType;
    private ArrayList<Victim> victims;
    private ArrayList<Witness> witnesses;
    private ArrayList<Suspect> suspects;
    private ArrayList<Criminal> criminals;
    private ArrayList<PersonOfInterest> personOfInterest;
    private ArrayList<Evidence> evidence;
    private ArrayList<User> users;
    private boolean solved;
    private int severity;
    private String jurisdiction;
    private User enteredCrime;
    private String extraInfo;
    private ArrayList<User> addedInfo;
    // private String image;
    private int id;

    /**
     * Creates a Crime
     * @param id An identifier for the crime
     * @param location Location of the crime
     * @param date Date of the crime
     * @param description Detailed description of the crime
     * @param crimeType Type of the crime e.g. 'assault'
     * @param detectives List of detectives on the case
     * @param severity The severity of the crime
     * @param jurisdiction Whichever station has jurisdiction over the case
     * @param enteredCrime Whichever user entered the crime
     */
    public Crime(int id, String location, String date, String description, String crimeType, ArrayList<User> detectives, int severity, String jurisdiction, User enteredCrime) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.description = description;
        this.crimeType = crimeType;
        this.users = detectives;
        this.severity = severity;
        this.jurisdiction = jurisdiction;
        this.enteredCrime = enteredCrime;
        victims = new ArrayList<Victim>();
        witnesses = new ArrayList<Witness>();
        suspects = new ArrayList<Suspect>();
        criminals = new ArrayList<Criminal>();
        personOfInterest = new ArrayList<PersonOfInterest>();
        evidence = new ArrayList<Evidence>();
        extraInfo = "";
    }

    /**
     * Empty Crime constructors
     */
    public Crime() {

    }
    
    /**
     * Returns the id of the crime
     * @return The id
     */
    public int getUuid() {
        return id;
    }

    /**
     * Returns the location of the crime
     * @return The location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location
     * @param location Location of the crime
     */
    public void setLocation(String location) {
        this.location = location;
    } 

    /**
     * Returns the date of the crime
     * @return The date
     */
    public String getDate() {
        return this.date;
    } 

    /**
     * Sets the date
     * @param date Date of the crime
     */
    public void setDate(String date){
        this.date = date;
    } 

    /**
     * Returns the description of the crime
     * @return The description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description
     * @param description Description of the crime
     */
    public void setDescription(String description){
        this.description = description;
    } 

    /**
     * Returns the type of crime
     * @return The type of crime
     */
    public String getCrimeType(){
        return this.crimeType;
    } 

    /**
     * Sets the type of crime
     * @param crimeType Type of the crime
     */
    public void setCrimeType(String crimeType){
        this.crimeType = crimeType;
    } 

    /**
     * Adds a victim to the list
     * @param vitcim Victim of the crime
     */
    public void addVictim(Victim victim){
        victims.add(victim);
    } 

    /**
     * Returns the victims of the crime
     * @return The victims
     */
    public ArrayList<Victim> getVictims(){
        return victims;
    } 

    /**
     * Adds a witness to the list
     * @param witness Witness of the crime
     */
    public void addWitness(Witness witness){
        witnesses.add(witness);
    } 

    /**
     * Returns the witnesses of the crime
     * @return The witnesses
     */
    public ArrayList<Witness> getWitnesses(){
        return witnesses;
    } 

    /**
     * Adds a person of interest to the list
     * @param person Person of interst of the crime
     */
    public void addPersonOfInterest(PersonOfInterest person){
        personOfInterest.add(person);
    } 

    /**
     * Returns the people of interest for the crime
     * @return The people of interest
     */
    public ArrayList<PersonOfInterest> getPersonOfInterest(){
        return personOfInterest;
    } 

    /**
     * Adds a suspect to the list
     * @param suspect Suspect of the crime
     */
    public void addSuspect(Suspect suspect){
        suspects.add(suspect);
    } 

    /**
     * Returns the suspects of the crime
     * @return The suspects
     */
    public ArrayList<Suspect> getSuspects() {
        return suspects;
    }

    /**
     * Adds a user to the list
     * @param user User of the crime
     */
    public void addUser(User user) {
        users.add(user);
    } 

    /**
     * Returns the users on this crime
     * @return The list of users
     */
    public ArrayList<User> getUsers() {
        return users;
    } 
    
    /**
     * Adds a piece of evidence to the list
     * @param evidence Evidence for the crime
     */
    public void addEvidence(Evidence evidence){
        this.evidence.add(evidence);
    } 

    /**
     * Returns the evidence for the crime
     * @return The evidence
     */
    public ArrayList<Evidence> getEvidence() {
        return evidence;
    } 

    /**
     * Returns true if the crime has been solved and false otherwise
     * @return The current outcome of the case
     */
    public boolean getSolved() {
        return solved;
    } 

    /**
     * Sets the variable for checking if the crime has been solved
     * @param solved Is the crime solved?
     */
    public void setSolved(boolean solved) {
        this.solved = solved;
    } 

    /**
     * Returns the severity of the crime
     * @return The severity
     */
    public int getSeverity() {
        return severity;
    } 

    /**
     * Sets the severity of the crime
     * @param severity Severity of the crime
     */
    public void setSeverity(int severity) {
        this.severity = severity;
    } 

    /**
     * Adds a criminal to the list
     * @param criminal Criminal for the crime
     */
    public void addCriminal (Criminal criminal) {
        criminals.add(criminal);
    } 

    /**
     * Returns the criminals associated with the crime
     * @return The criminals
     */
    public ArrayList<Criminal> getCriminals() {
        return criminals;
    }

    /**
     * Returns the jurisdiction where the crime happened
     * @return The jurisdiction
     */
    public String getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Sets the jurisdiction of the crime
     * @param jurisdiction Jurisdiction of the crime
     */
    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    } 

    /**
     * Returns the user of the case
     * @return The user
     */
    public User getEnteredCrime() {
        return enteredCrime;
    }
    
    /**
     * Returns a string of the variables
     * @return The string of variables
     */
    public String toString() {
        String userNames = "";
        String victs = "";
        String witns = "";
        String pois = "";
        String susps = "";
        String crims = "";
        String evids = "";
        for(User u: users) {
            if(users.size() == 0) {
                break;
            }
            if(u.equals(users.get(users.size()-1))) {
                userNames = userNames + u.getFirstName() + " " + u.getLastName();
            }
            else {
                userNames = userNames + u.getFirstName() + " " + u.getLastName() + ", ";           
            }
        }
        String str = "A " + crimeType + " happenned on " + date + " at " + location + "\nDescription: " + description + "\nCrime Number: " + id + "\nSolved?: " + solved + "\nSeverity: " + severity +
        "\nJurisdiction: " + jurisdiction + "\nOn the case: " + userNames;
        for(Victim v: victims) {
            if(victims.size() == 0) {
                break;
            }
            victs = victs + v;
            // if(v.equals(victims.get(victims.size()-1))) {
            //     victs = victs + v.getFirstName() + " " + v.getLastName();
            // }
            // else {
            //     victs = victs + v.getFirstName() + " " + v.getLastName() + ", ";
            // }
        }
        for(Witness w: witnesses) {
            if(witnesses.size() == 0) {
                break;
            }
            witns = witns + w;
            // if(w.equals(witnesses.get(witnesses.size()-1))) {
            //     witns = witns + w.getFirstName() + " " + w.getLastName();
            // }
            // else {
            //     witns = witns + w.getFirstName() + " " + w.getLastName() + ", ";
            // }
        }
        for(PersonOfInterest p: personOfInterest) {
            if(personOfInterest.size() == 0) {
                break;
            }
            pois = pois + p;
            // if(p.equals(personOfInterest.get(personOfInterest.size()-1))) {
            //     pois = pois + p.getFirstName() + " " + p.getLastName();
            // }
            // else {
            //     pois = pois + p.getFirstName() + " " + p.getLastName() + ", ";
            // }
        }
        for(Suspect s: suspects) {
            if(suspects.size() == 0) {
                break;
            }
            susps = susps + s;
            // if(s.equals(suspects.get(suspects.size()-1))) {
            //     susps = susps + s.getFirstName() + " " + s.getLastName();
            // }
            // else {
            //     susps = susps + s.getFirstName() + " " + s.getLastName() + ", ";
            // }
        }
        for(Criminal c: criminals) {
            if(criminals.size() == 0) {
                break;
            }
            crims = crims + c;
            // if(c.equals(criminals.get(criminals.size()-1))) {
            //     crims = crims + c.getFirstName() + " " + c.getLastName();
            // }
            // else {
            //     crims = crims + c.getFirstName() + " " + c.getLastName() + ", ";
            // }
        }
        for(Evidence e: evidence) {
            if(evidence.size() == 0) {
                break;
            }
            evids = evids + e;
            // if(e.equals(evidence.get(evidence.size()-1))) {
            //     evids = evids + e.getEvidenceType();
            // }
            // else {
            //     evids = evids + e.getEvidenceType() + ", ";
            // }
        }
        if(!victs.equals("")) {
            str = str + "\nVictims: " + victs;
        }
        if(!witns.equals("")) {
            str = str + "\nWitnesses: " + witns;
        }
        if(!pois.equals("")) {
            str = str + "\nPersons of Interest: " + pois;
        }
        if(!susps.equals("")) {
            str = str + "\nSuspects: " + susps;
        }
        if(!crims.equals("")) {
            str = str + "\nCriminals: " + crims;
        }
        if(!evids.equals("")) {
            str = str + "\nEvidence: " + evids;
        }
        if(!extraInfo.equals("")) {
            str = str + "\nExtra Info: " + extraInfo;
        }
        return str;
    }

    /**
     * Adds info and user to addedInfo
     * @param info Information on the crime
     * @param user User who entered information
     */
    public void addingInfo(String info, User user){
        addedInfo.add(user);
        extraInfo = extraInfo + "\n" + info;
    } 

    /**
     * Returns the info of the crime
     * @return The info
     */
    public void addInfo(String info){
        if(extraInfo == null) {
            extraInfo = info;
        }
        else {
            extraInfo = extraInfo + "\n" + info;
        }
    } 

    /**
     * Returns the information on the crime
     * @return The info
     */
    public String getInfo() {
        return extraInfo;
    }

    // /**
    //  * Returns the image of the crime
    //  * @return The image
    //  */
    // public String getImage() {
    //     return image;
    // } 

    // /**
    //  * Sets the image of the crime
    //  * @param image Image of the crime
    //  */
    // public void setImage(String image) {
    //     this.image = image;
    // } 


}
