//Connor Downey
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class WitnessTest {

    @Test
    public void paramConstructorTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0";
        Witness w = new Witness(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email);
        assertEquals(0, w.getUuid());
        assertEquals(firstName, w.getFirstName());
        assertEquals(lastName, w.getLastName());
        assertEquals(email, w.getEmail());
        assertEquals(phoneNumber, w.getPhoneNumber());
        assertEquals(age, w.getAge());
        assertEquals(height, w.getHeight());
        assertEquals(weight, w.getWeight());
        assertEquals(skinColor, w.getSkinColor());
        assertEquals(hairColor, w.getHairColor());
        assertEquals(eyeColor, w.getEyeColor());
        assertEquals(address, w.getAddress());
    }

    @Test
    public void addStoryTest() {
        String story = "hey";
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0";
        Witness w = new Witness(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email);
        w.addStory(story);
        assertEquals(story, w.getLastStory());
    }

    @Test
    public void getLastStory() {
        String story = "hey";
        String story2 = "heyy";
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0";
        Witness w = new Witness(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email);
        w.addStory(story);
        w.addStory(story2);
        assertEquals(story2, w.getLastStory());
    }

    @Test
    public void toStringTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0";
        Witness w = new Witness(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email);
        assertEquals("ID: " + w.getUuid() + "\n\tName: " + w.getFirstName() + " " + w.getLastName() + "\n\tAge: " + w.getAge() + "\n\tHeight: " + w.getHeight() + " inches\n\tWeight: " + w.getWeight() + " lbs.\n\tSkin Color: " + w.getSkinColor()
        + "\n\tHair Color: " + w.getHairColor() + "\n\tEye Color: " + w.getEyeColor() + "\n\tAddress: " + w.getAddress() + "\n\tPhone Number: " + w.getPhoneNumber() + "\n\tEmail: " + w.getEmail() + "\n\tSuspect Associated to: "
        + "\n\tStories: " + "\n", w.toString());
    }
}
