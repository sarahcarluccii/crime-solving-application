import java.util.ArrayList;

/**
 * A Criminal Application
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class PersonOfInterest extends Person{
    
    private String phoneNumber;
    private String email;
    private Suspect suspectAssociatedTo;
    private String associationToSuspect;
    private String associationToCase;
    private ArrayList<String> stories;

    /**
     * @param id an identifier for the POI
     * @param firstName first name of the POI
     * @param lastName last name of the POI
     * @param age age of the POI 
     * @param height height of the POI
     * @param weight weight of the POI
     * @param skinColor skin color of the POI
     * @param hairColor hair color of the POI
     * @param eyeColor eye color of the POI
     * @param address address of the POI
     * @param phoneNumber phone number of the POI
     * @param email email of the POI
     * @param suspectAssociatedTo POI associations
     * @param associationToCase POI association with case
     * @param associationToSuspect POI associated with suspect
     */
    public PersonOfInterest(int id, String firstName, String lastName, int age, int height, int weight, String skinColor, String hairColor, String eyeColor, String address, String phoneNumber, String email, Suspect suspectAssociatedTo, String associationToCase, String associationToSuspect) {
        super(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAssociationToSuspect(associationToSuspect);
        this.suspectAssociatedTo = suspectAssociatedTo;
        setAssociationToCase(associationToCase);
        stories = new ArrayList<String>();
    }

    /**
     * Empty PersonOfInterest Constructor
     */
    public PersonOfInterest() {

    }
    /**
     * Returns the phone number of the POI
     * @return The phone number 
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    } 

    /**
     * Sets the phonenumber of the POI
     * @param phoneNumber phone number of the POI
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    } 

    /**
     * Returns the email of the POI
     * @return The email 
     */
    public String getEmail() {
        return this.email;
    } 

    /**
     * Sets the email of the POI
     * @param email email of the POI
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the association to suspect of the POI
     * @return The association to suspect 
     */
    public String getAssociationToSuspect() {
        return associationToSuspect;
    } 

    /**
     * Sets the association to suspect of the POI
     * @param associationToSuspect association to suspect of the POI
     */
    public void setAssociationToSuspect(String associationToSuspect) {
        this.associationToSuspect = associationToSuspect;
    }

    /**
     * Returns the POI's associations
     * @return The suspect associated to  
     */
    public Suspect getSuspectAssociatedTo() {
        return suspectAssociatedTo;
    }

    /**
     * Sets the POI associated to
     * @param suspectAssociatedTo suspect associated to the POI
     */
    public void setSuspectAssociatedTo() {
        for(Crime crimes: CriminalApplication.getInstance().getCrimes()){
            for(PersonOfInterest poi: crimes.getPersonOfInterest()) {
                if(poi.getUuid() == id) {
                    for(Suspect suspect: crimes.getSuspects()) {
                        if(suspect.getUuid() == suspectAssociatedTo.getUuid()) {
                            suspectAssociatedTo = suspect;
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the association to the case of the POI
     * @param associationToCase association to the case of the POI
     */
    public void setAssociationToCase(String associatoinToCase) {
        this.associationToCase = associatoinToCase;
    }

    /**
     * Returns the association to case of the POI
     * @return The association to case 
     */
    public String getAssociationToCase() {
        return associationToCase;
    }

    /**
     * Adds the story to the working list of stories
     */
    public void addStory(String story) {
        stories.add(story);
    } 

    /**
     * Returns the list of stories from the POI
     * @return The list of stories
     */
    public ArrayList<String> getStory() {
        return stories;
    }

    /**
     * Returns the last story from the POI
     * @return The last story
     */
    public String getLastStory() {
        return stories.get(stories.size()-1);
    }
    
    /**
     * Returns a string of the variables
     * @return The string of variables
     */
    public String toString() {
        setSuspectAssociatedTo();
        String stor = "";
        for(String s: stories) {
            if(s.equals(stories.get(stories.size()-1))) {
                stor = stor + s;
            }
            else {
                stor = stor + s + ", ";
            }
        }
        return "ID: " + id + "\nName: " + firstName + " " + lastName + "\nAge: " + age + "\nHeight: " + height + " inches\nWeight: " + weight + " lbs.\nSkin Color: " + skinColor
        + "\nHair Color: " + hairColor + "\nEye Color: " + eyeColor + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nSuspect Associated to: "
        + suspectAssociatedTo.getFirstName() + " " + suspectAssociatedTo.getLastName() + "\nAssociation To Suspect: " + associationToSuspect + "\nStories: " + stor;
    }
}
