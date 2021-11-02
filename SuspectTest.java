/**
 * @author Sarah Carlucci
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SuspectTest {
	
	private CriminalApplication crapp = CriminalApplication.getInstance();
    // private Suspect suspects = Suspect.getInstance();
    private ArrayList<Suspect> suspectList = crapp.getSuspects();
    
    @BeforeEach
	public void setup() {
		suspectList.clear();
		suspectList.add(new Suspect(1));
		suspectList.add(new Suspect(2));
		DataWriter.saveSuspects();
	}
	
	@AfterEach
	public void tearDown() {
		crapp.getSuspects().clear();
		DataWriter.saveUsers();
	}
    
    @Test
	void testHaveSuspectValidFirstItem() {
		int has1 = suspectList.get(1).getUuid();
		assertEquals(1, has1);
	}

	@Test
	void testHaveSuspectValidLastItem() {
		int has2 = suspectList.get(2).getUuid();
		assertEquals(2, has2);
	}

	@Test 
	public void paramConstructorTest() {
		int id = 0;
		String firstName = "0", lastName = "0", skinColor = "0", hairColor = "0", eyeColor = "0",
		address = "0", alibi = "0";
		int age = 0, height = 0, weight = 0;
		ArrayList<String> tattoos = new ArrayList<String>();
		ArrayList<String> aliases = new ArrayList<String>();
		ArrayList<Person> associates = new ArrayList<Person>();
		ArrayList<Crime> pastCrimes = new ArrayList<Crime>();
		ArrayList<Evidence> evidence = new ArrayList<Evidence>();

		Suspect s = new Suspect(id, firstName, lastName, age, height, weight,
		 skinColor, hairColor, eyeColor, address, alibi);

		assertEquals(id, s.getUuid());
        assertEquals(firstName, s.getFirstName());
        assertEquals(lastName, s.getLastName());
        assertEquals(age, s.getAge());
        assertEquals(height, s.getHeight());
        assertEquals(weight, s.getWeight());
        assertEquals(skinColor, s.getSkinColor());
        assertEquals(eyeColor, s.getEyeColor());
        assertEquals(address, s.getAddress());
        assertEquals(alibi, s.getAlibi());
		assertNotNull(s.getTattoo());
		assertNotNull(s.getAlias());
	}
	@Test
	public void addAliasTest() {
		int id = 0;
		String firstName = "0", lastName = "0", skinColor = "0", hairColor = "0", eyeColor = "0",
		address = "0", alibi = "0";
		int age = 0, height = 0, weight = 0;
		ArrayList<String> tattoos = new ArrayList<String>();
		ArrayList<String> aliases = new ArrayList<String>();
		ArrayList<Person> associates = new ArrayList<Person>();
		ArrayList<Crime> pastCrimes = new ArrayList<Crime>();
		ArrayList<Evidence> evidence = new ArrayList<Evidence>();

		Suspect s = new Suspect(id, firstName, lastName, age, height, weight,
		 skinColor, hairColor, eyeColor, address, alibi);

		String aliases1 = "test";
		aliases.add(aliases1);
		s.addAlias(aliases1);
		assertEquals(aliases, s.getAlias());

	}
}