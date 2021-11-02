//Connor Downey
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {
    
    @Test
    public void paramConstructorTest() {
        int id = 0;
        String firstName ="0", lastName ="0", phoneNumber ="0", email = "0", precinct = "0", department = "0", badgeNumber = "0", rank = "0", password = "0";
        ArrayList<Crime> crimesWorking = new ArrayList<Crime>();
        User u = new User(id, firstName, lastName, email, phoneNumber, precinct, department, badgeNumber, rank, password, crimesWorking);
        assertEquals(id, u.getUuid());
        assertEquals(firstName, u.getFirstName());
        assertEquals(lastName, u.getLastName());
        assertEquals(email, u.getEmail());
        assertEquals(phoneNumber, u.getPhoneNumber());
        assertEquals(precinct, u.getPrecinct());
        assertEquals(department, u.getDepartment());
        assertEquals(badgeNumber, u.getBadgeNumber());
        assertEquals(rank, u.getRank());
        assertEquals(password, u.getPassword());
        assertNotNull(u.getCrimesWorking());
    }

    @Test
    public void addCrimeTest() {
        int id = 0;
        String firstName ="0", lastName ="0", phoneNumber ="0", email = "0", precinct = "0", department = "0", badgeNumber = "0", rank = "0", password = "0";
        ArrayList<Crime> crimesWorking = new ArrayList<Crime>();
        User u = new User(id, firstName, lastName, email, phoneNumber, precinct, department, badgeNumber, rank, password, crimesWorking);
        Crime crime = new Crime();
        crimesWorking.add(crime);
        u.addCrime(crime);
        assertEquals(crimesWorking, u.getCrimesWorking());
    }

    @Test
    public void toStringTest() {
        int id = 0;
        String firstName ="0", lastName ="0", phoneNumber ="0", email = "0", precinct = "0", department = "0", badgeNumber = "0", rank = "0", password = "0";
        ArrayList<Crime> crimesWorking = new ArrayList<Crime>();
        User u = new User(id, firstName, lastName, email, phoneNumber, precinct, department, badgeNumber, rank, password, crimesWorking);
        assertEquals(id + "\n" + firstName + "\n" + lastName + "\n" + email + "\n" + phoneNumber + "\n" + precinct + "\n" + department + "\n" + badgeNumber + "\n" + rank + "\n" + password + "\n", u.toString());
    }
}
