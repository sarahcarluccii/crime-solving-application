/**
 * A Person
 * @author Connor Downey, Alex Santoro, Austin Stipo, and Sarah Carlucci
 */
public class Person {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected int height; //in inches
    protected int weight;
    protected String skinColor;
    protected String hairColor;
    protected String eyeColor;
    protected String address;
    // protected String image;

    /**
     * @param id An identifier for the person
     * @param firstName First name of the person
     * @param lastName Last name of the person
     * @param age Age of the person
     * @param height Height in inches of the person
     * @param weight Weight in pounds of the person
     * @param skinColor Skin color of the person
     * @param hairColor Hair color of the person
     * @param eyeColor Eye color of the person
     * @param address Address of the person
     */
    public Person(int id, String firstName, String lastName, int age, int height, int weight, String skinColor, String hairColor, String eyeColor, String address) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setSkinColor(skinColor);
        sethairColor(hairColor);
        setEyeColor(eyeColor);
        setAddress(address);
    }

    /**
     * Empty Person constuctor
     */
    public Person() {

    }

    /**
     * Returns the identifier for the person
     * @return The id
     */
    public int getUuid() {
        return id;
    }

    /**
     * Returns the first and last name of the person
     * @return The first name + last name
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the first name of the person
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the person
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the first name of the person
     * @param firstName first name of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } 

    /**
     * Sets the last name of the person
     * @param lastName first name of the person
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the age of the person
     * @return The age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets the age of the person
     * @param age age of the person
     */
    public void setAge(int age) {
        this.age = age;
    } 

    /**
     * Returns the address of the person
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the person
     * @param address address of the person
     */
    public void setAddress(String address) {
        this.address = address; 
    }

    // /**
    //  * Returns an image of the person
    //  * @return The image
    //  */
    // public String getImage() {
    //     return "Person looks like " + image;
    // }

    // /**
    //  * Sets the image for a person
    //  * @param image image of the person
    //  */
    // public void setImage(String image) {
    //     this.image = image;
    // } 

    /**
     * Sets the height of the person
     * @param height height of the person
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns the height of the person
     * @return The height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Sets the weight of the person
     * @param weight weight name of the person
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns the weight of the person
     * @return The weight
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Sets the skin color of the person
     * @param skinColor skin color of the person
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * Returns the skin color of the person
     * @return The skin color
     */
    public String getSkinColor() {
        return this.skinColor;
    }

    /**
     * Sets the hair color of the person
     * @param hairColor hair color of the person
     */
    public void sethairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Returns the hair color of the person
     * @return The hair color
     */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
     * Sets the eye color of the person
     * @param eyeColor eye color of the person
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Returns the eye color of the person
     * @return The eye color
     */
    public String getEyeColor() {
        return this.eyeColor;
    }
}
