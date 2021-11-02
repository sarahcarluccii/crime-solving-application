import java.util.ArrayList;

/**
 * A Witness
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class Witness extends Person{
    private String phoneNumber;
    private String email;
    private ArrayList<String> stories;

    /**
     * @param id an identifier for the witness
     * @param firstName first name of the witness
     * @param lastName last name of the witness
     * @param age age of the witness
     * @param height height of the witness
     * @param weight weight of the witness
     * @param skinColor skin color of the witness
     * @param hairColor hair color of the witness
     * @param eyeColor eye color of the witness
     * @param address address of the witness
     * @param phoneNumber phone number of the witness
     * @param email email of the witness
     */
    public Witness(int id, String firstName, String lastName, int age, int height, int weight, String skinColor,
            String hairColor, String eyeColor, String address, String phoneNumber, String email) {
        super(id,firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address);
        stories = new ArrayList<String>();
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }
    
    /**
    *Empty Witness Constructor
    */
    public Witness() {

    }

    /**
     * Returns the phone number of the witness
     * @return The phone number 
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number of the witness
     * @param phoneNumber phone number of the witness
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the email of the witness
     * @return The email 
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the victim
     * @param email email of the victim
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adds a story from the witness
     * @param story story from the witness
     */
    public void addStory(String story) {
        stories.add(story);
    }

    /**
     * Returns the last story of the witness
     * @return The last story of the witness 
     */
    public String getLastStory() {
        return stories.get(stories.size()-1);
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
        + "\n\tHair Color: " + hairColor + "\n\tEye Color: " + eyeColor + "\n\tAddress: " + address + "\n\tPhone Number: " + phoneNumber + "\n\tEmail: " + email + "\n\tSuspect Associated to: "
        + "\n\tStories: " + stor + "\n";
        return str;
    }
}

