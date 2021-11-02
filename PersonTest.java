//Connor Downey
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
    
    @Test
    public void paramConstructorTest() {
        int id = 0, age = 0, height = 0, weight = 0;
        String firstName ="0", lastName ="0", skinColor ="0", hairColor ="0", eyeColor ="0", address ="0";
        Person p = new Person(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address);
        assertEquals(id, p.getUuid());
        assertEquals(firstName, p.getFirstName());
        assertEquals(lastName, p.getLastName());
        assertEquals(age, p.getAge());
        assertEquals(height, p.getHeight());
        assertEquals(weight, p.getWeight());
        assertEquals(skinColor, p.getSkinColor());
        assertEquals(hairColor, p.getHairColor());
        assertEquals(eyeColor, p.getEyeColor());
        assertEquals(address, p.getAddress());
    }
}
