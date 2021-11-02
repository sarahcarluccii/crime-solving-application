/**
 * A piece of Evidence
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
import java.util.ArrayList;

public class Evidence {
    
    private int id;
    private String evidenceType;
    private String location;
    private String time;
    private User enteredEvidence;
    // private User handleEvidence;
    private ArrayList<String> comments;

    /**
     * Creates a piece of Evidence
     * @param id An identifier for the crime
     * @param evidenceType The type of the evidence
     * @param location Location of the crime
     * @param time The time the evidence was entered
     * @param enteredEvidence The user who entered the evidence
     * @param comment The comment
     */
    public Evidence(int id, String evidenceType, String location, String time, User enteredEvidence, ArrayList<String> comment) {
        this.id = id;
        this.evidenceType = evidenceType;
        this.location = location;
        this.time = time;
        this.enteredEvidence = enteredEvidence;
        this.comments = comment;
    }

    /**
     * Empty Evidence constructor
     */
    public Evidence() {

    }
    
    /**
     * Returns the identifier for the evidence
     * @return The id
     */
    public int getUuid() {
        return id;
    }

    /**
     * Returns the type of the evidence
     * @return The type
     */
    public String getEvidenceType() {
        return evidenceType;
    } 

    /**
     * Sets the location of the evidence
     * @param location Location of the evidence
     */
    public void setLocation(String location) {
        this.location = location ;
    } 

    /**
     * Returns the location of the evidence
     * @return The location
     */
    public String getLocation() {
        return location;
    } 

    // public String getLastLocation() {
    //     return locations.get(locations.size()-1);
    // } 

    /**
     * Sets the time the evidence was entered
     * @param time Time the evidence was entered
     */
    public void setTime(String time) {
        this.time = time;
    } 

    /**
     * Returns the time the evidence was entered
     * @return The time 
     */
    public String getTime() {
        return time;
    } 

    // public String getLastTime() {
    //     return times.get(times.size()-1);
    // } 

    /**
     * Returns the user who entered the evidence
     * @return The user
     */
    public User getEnteredEvidence() {
        return enteredEvidence;
    } 

    // public void addHandleEvidence(User user) {
    //     handleEvidence.add(user);
    // } 

    // public  ArrayList<User> getHandleEvidence() {
    //     return handleEvidence;
    // }

    // public User getLastHandleEvidence() {
    //     return handleEvidence.get(handleEvidence.size()-1);
    // }

    /**
     * Adds the passed comment to the list of comments
     * @param comment Comment about the evidence
     */
    public void addComment(String comment) {
        comments.add(comment);
    }

    /**
     * Returns the list of comments
     * @return The comments
     */
    public ArrayList<String> getComments() {
        return comments;
    } 

    /**
     * Returns the last comment
     * @return The comment
     */
    public String getLastComment() {
        return comments.get(comments.size()-1);
    }

    /**
     * Returns a string of the variables
     * @return The string of variables
     */
    public String toString() {
        String comm = "";
        for(String c: comments) {
            if(c.equals(comments.get(comments.size()-1))) {
                comm = comm + c;
            }
            else {
                comm = comm + c + ", ";           
            }
        }
        return "ID: " + id + "\n\tEvidence Type: " + evidenceType + "\n\tLocation: " + location + "\n\tTime: " + time + "\n\tEntered Evidence: " + enteredEvidence.getFirstName() + " " + enteredEvidence.getLastName() + "\n\tComments: " + comm + "\n";
    }
}
