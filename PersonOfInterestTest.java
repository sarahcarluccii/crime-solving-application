//Connor Downey
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonOfInterestTest {
    
    @Test
    public void paramConstructorTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToCase = "0", associationToSuspect = "0";
        Suspect suspectAssociatedTo = new Suspect();
        PersonOfInterest poi = new PersonOfInterest(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, suspectAssociatedTo, associationToCase, associationToSuspect);
        assertEquals(0, poi.getUuid());
        assertEquals(firstName, poi.getFirstName());
        assertEquals(lastName, poi.getLastName());
        assertEquals(email, poi.getEmail());
        assertEquals(phoneNumber, poi.getPhoneNumber());
        assertEquals(age, poi.getAge());
        assertEquals(height, poi.getHeight());
        assertEquals(weight, poi.getWeight());
        assertEquals(skinColor, poi.getSkinColor());
        assertEquals(hairColor, poi.getHairColor());
        assertEquals(eyeColor, poi.getEyeColor());
        assertEquals(address, poi.getAddress());
        assertEquals(associationToSuspect, poi.getAssociationToSuspect());
        assertEquals(associationToCase, poi.getAssociationToCase());
        assertEquals(suspectAssociatedTo, poi.getSuspectAssociatedTo());
    }

    @Test
    public void addStoryTest() {
        String story = "hey";
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToCase = "0", associationToSuspect = "0";
        Suspect suspectAssociatedTo = new Suspect();
        PersonOfInterest poi = new PersonOfInterest(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, suspectAssociatedTo, associationToCase, associationToSuspect);
        poi.addStory(story);
        assertEquals(story, poi.getLastStory());
    }

    @Test
    public void getLastStory() {
        String story = "hey";
        String story2 = "heyy";
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToCase = "0", associationToSuspect = "0";
        Suspect suspectAssociatedTo = new Suspect();
        PersonOfInterest poi = new PersonOfInterest(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, suspectAssociatedTo, associationToCase, associationToSuspect);
        poi.addStory(story);
        poi.addStory(story2);
        assertEquals(story2, poi.getLastStory());
    }

    @Test
    public void toStringTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0", phoneNumber ="0", email = "0", associationToCase = "0", associationToSuspect = "0";
        Suspect suspectAssociatedTo = new Suspect();
        PersonOfInterest poi = new PersonOfInterest(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, suspectAssociatedTo, associationToCase, associationToSuspect);
        assertEquals("ID: " + id + "\nName: " + firstName + " " + lastName + "\nAge: " + age + "\nHeight: " + height + " inches\nWeight: " + weight + " lbs.\nSkin Color: " + skinColor
        + "\nHair Color: " + hairColor + "\nEye Color: " + eyeColor + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nSuspect Associated to: "
        + suspectAssociatedTo.getFirstName() + " " + suspectAssociatedTo.getLastName() + "\nAssociation To Suspect: " + associationToSuspect + "\nStories:  ", poi.toString());
    }
}
