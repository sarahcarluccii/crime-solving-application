//Connor Downey
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VictimTest {
    
    @Test
    public void paramConstructorTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToSuspect = "0";
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        assertEquals(0, v.getUuid());
        assertEquals(firstName, v.getFirstName());
        assertEquals(lastName, v.getLastName());
        assertEquals(email, v.getEmail());
        assertEquals(phoneNumber, v.getPhoneNumber());
        assertEquals(age, v.getAge());
        assertEquals(height, v.getHeight());
        assertEquals(weight, v.getWeight());
        assertEquals(skinColor, v.getSkinColor());
        assertEquals(hairColor, v.getHairColor());
        assertEquals(eyeColor, v.getEyeColor());
        assertEquals(address, v.getAddress());
        assertEquals(associationToSuspect, v.getAssociationToSuspect());
    }

    @Test
    public void addStoryTest() {
        String story = "hey";
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToSuspect = "0";
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        v.addStory(story);
        assertEquals(story, v.getLastStory());
    }

    @Test
    public void getLastStory() {
        String story = "hey";
        String story2 = "heyy";
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToSuspect = "0";
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        v.addStory(story);
        v.addStory(story2);
        assertEquals(story2, v.getLastStory());
    }

    @Test
    public void changeHospitalizedTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToSuspect = "0";
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        boolean hospitalized = false;
        v.setHospitalized(hospitalized);
        v.changeHospitalized();
        assertEquals(true, v.getHospitalized());
    }

    @Test
    public void changeAliveTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToSuspect = "0";
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        boolean alive = false;
        v.setAlive(alive);
        v.changeAlive();
        assertEquals(true, v.getAlive());
    }

    @Test
    public void toStringTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToSuspect = "0";
        Victim v = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
        assertEquals("ID: " + id + "\n\tName: " + firstName + " " + lastName + "\n\tAge: " + age + "\n\tHeight: " + height + " inches\n\tWeight: " + weight + " lbs.\n\tSkin Color: " + skinColor
        + "\n\tHair Color: " + hairColor + "\n\tEye Color: " + eyeColor + "\n\tAddress: " + address + "\n\tPhone Number: " + phoneNumber + "\n\tEmail: " + email 
        + "\n\tAssociation To Suspect: " + associationToSuspect + "\n\tStories: \n", v.toString());
    }
}
