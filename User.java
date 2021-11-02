import java.util.ArrayList;

/**
 * A User
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String precinct;
    private String department;
    private String badgeNumber;
    private String rank;
    private String password;
    private ArrayList<Crime> crimesWorking;

    /**
     * @param id an identifier for the user
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param email email of the user
     * @param phoneNumber phone number of the user
     * @param precinct precinct of the user
     * @param department department of the user
     * @param badgeNumber badge number of the user
     * @param rank rank of the user
     * @param password password of the user
     * @param crimesWorking crimes worked on by user
     */
    public User(int id, String firstName, String lastName, String email, String phoneNumber, String precinct, String department, String badgeNumber, String rank, String password, ArrayList<Crime> crimesWorking) {
        this.id = id;
        this.crimesWorking = crimesWorking;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setPrecinct(precinct);
        setDepartment(department);
        setBadgeNumber(badgeNumber);
        setRank(rank);
        setPassword(password);
    }

    /**
     * Empty User constructor
     */
    public User() {

    }
    
    /**
     * Returns the ID of the user
     * @return The ID
     */
    public int getUuid() {
        return id;
    }

    /**
     * Returns the first name of the user
     * @return The first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the  of the user
     * @param firstName first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the user
     * @return The last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name of the user
     * @param lastName last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email of the user
     * @return The email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the user
     * @param email email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the phone number of the user
     * @return The phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phone number of the user
     * @param phoneNumber phone number of the user
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the precinct of the user
     * @return The precinct 
     */
    public String getPrecinct() {
        return this.precinct;
    }

    /**
     * Sets the precinct of the user
     * @param precinct precinct of the user
     */
    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    /**
     * Returns the department of the user
     * @return The department 
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Sets the department of the user
     * @param firstName first of the user
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns the badge number of the user
     * @return The badge number
     */
    public String getBadgeNumber() {
        return this.badgeNumber;
    }

    /**
     * Sets the badge number of the user
     * @param badgeNumber first of the user
     */
    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    /**
     * Returns the rank of the user
     * @return The rank  
     */
    public String getRank() {
        return this.rank;
    }

    /**
     * Sets the rank of the user
     * @param rank rank of the user
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Returns the password of the user
     * @return The  
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the user
     * @param password password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the list of crimes working of the user
     * @return The crimes working
     */
    public ArrayList<Crime> getCrimesWorking() {
        return crimesWorking;
    }

    /**
     * Adds the crime to the list of working crimes
     * @param addCrime Comment about the evidence
     */
    public void addCrime(Crime crime) {
        crimesWorking.add(crime);
    }

    /**
     * Returns string of all user class variables 
     */
    public String toString() {
        return id + "\n" + firstName + "\n" + lastName + "\n" + email + "\n" + phoneNumber + "\n" + precinct + "\n" + department + "\n" + badgeNumber + "\n" + rank + "\n" + password + "\n";
    }
    
}
