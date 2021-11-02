import java.util.ArrayList;
/**
 * A Victim
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class Victim extends Person {
    private String phoneNumber;
    private String email;
    private String associationToSuspect;
    private ArrayList<String> stories;
    private boolean hospitalized;
    private boolean alive;

    /**
     * @param id an identifier for the victim
     * @param firstName first name of the victim
     * @param lastName last name of the victim
     * @param age age of the victim
     * @param height height of the victim
     * @param weight weight of the victim
     * @param skinColor skin color of the victim
     * @param hairColor hair color of the victim
     * @param eyeColor eye color of the victim
     * @param address address of the victim
     * @param phoneNumber phone number of the victim
     * @param email email of the victim
     * @param associationToSuspect victims association to the suspect
     */
    public Victim(int id, String firstName, String lastName, int age, int height, int weight, String skinColor,
            String hairColor, String eyeColor, String address, String phoneNumber, String email, String associationToSuspect) {
        super(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAssociationToSuspect(associationToSuspect);
        stories = new ArrayList<String>();
        alive = true;
    }

    /**
     * Empty Victim constructor
     */
    public Victim() {

    }

    /**
     * Returns the phone number of the victim
     * @return The phone number 
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number of the victim
     * @param alive phone number of the victim
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the email of the victim
     * @return The email 
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email  of the victim
     * @param email email of the victim
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the victims association to the suspect
     * @return The association to suspect 
     */
    public String getAssociationToSuspect() {
        return this.associationToSuspect;
    }

    /**
     * Sets the association to suspect of the victim
     * @param associationToSuspect association to suspect of the victim
     */
    public void setAssociationToSuspect(String associationToSuspect) {
        this.associationToSuspect = associationToSuspect;
    }

    /**
     * Adds a story from the victim
     * @param story story from the victim
     */
    public void addStory(String story) {
        stories.add(story);
    }
    
    /**
     * Returns the last story of the victim
     * @return The last story of the victim 
     */
    public String getLastStory() {
        return stories.get(stories.size()-1);
    }

    /**
     * Returns true if victim is hospitalized and false otherwise
     * @return The hospitalization status of the victim 
     */
    public boolean getHospitalized() {
        return this.hospitalized;
    }

    /**
     * Sets the hospitalization status of the victim
     * @param lastName first name of the person
     */
    public void setHospitalized(boolean hospitalized) {
        this.hospitalized = hospitalized;
    }

    /**
     * Changes hospitalization status of the victim
     * @param hospitalized status of the victim
     */
    public void changeHospitalized() {
        hospitalized = !hospitalized;
    }

    /**
     * Returns true if victim is alive and false otherwise
     * @return The living status of the victim 
     */
    public boolean getAlive() {
        return this.alive;
    }

    /**
     * Sets the living status of the victim
     * @param alive living status of the victim
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Changes living status of the victim
     * @param alive status of the victim
     */
    public void changeAlive() {
        alive = !alive;
    }

    public String toString() {
        String stor = "";
        for(String s: stories) {
            if(s.equals(stories.get(stories.size()-1))) {
                stor = stor + s;
            }
            else {
                stor = stor + s + ", ";
            }
        }
        String str = "ID: " + id + "\n\tName: " + firstName + " " + lastName + "\n\tAge: " + age + "\n\tHeight: " + height + " inches\n\tWeight: " + weight + " lbs.\n\tSkin Color: " + skinColor
        + "\n\tHair Color: " + hairColor + "\n\tEye Color: " + eyeColor + "\n\tAddress: " + address + "\n\tPhone Number: " + phoneNumber + "\n\tEmail: " + email 
        + "\n\tAssociation To Suspect: " + associationToSuspect + "\n\tStories: " + stor;
        if(hospitalized) {
            str = str + "\n\tHospitalized";
        }
        if(!alive) {
            str = str + "\n\tDead";
        }
        return str + "\n";
    }
}

