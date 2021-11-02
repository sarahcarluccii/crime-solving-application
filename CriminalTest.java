  
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CriminalTest {
	private CriminalApplication crapp = CriminalApplication.getInstance();
	private ArrayList<Criminal> criminalList = crapp.getCriminals();
	
	@BeforeEach
	public void setup() {
		criminalList.clear();
        criminalList.add(new Criminal(1, "John", "Thompson", 26, 72, 165, "white", "black", "brown", "658 Assembly Rd", new User()));
        criminalList.add(new Criminal(2, "Dick", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(0).addTattoo("Dog");
        criminalList.get(0).addAlias("Big Bill");
        criminalList.get(1).addAlias("Belcher");
        criminalList.get(0).setJail(true);
        criminalList.get(1).setJail(false);
        criminalList.get(0).setAlive(true);
        criminalList.get(1).setAlive(true);
        criminalList.get(0).setChargesDropped(false);
        criminalList.get(1).setChargesDropped(true);
		DataWriter.saveCriminals();
	}
	
	@AfterEach
	public void tearDown() {
		crapp.getCriminals().clear();
		DataWriter.saveCriminals();
	}

    @Test
    void testGetCriminalID(){
        criminalList = DataLoader.getCriminals();
        assertEquals(1, criminalList.get(0).getUuid());
    }
    
    @Test
    void testCriminalGetHasTattooNone() {
        criminalList = DataLoader.getCriminals();
        assertEquals(false, criminalList.get(1).getHasTattoos());
    }

    @Test
    void testCriminalConvertToSuspect() {
        criminalList = DataLoader.getCriminals();
        Suspect suspect = criminalList.get(0).convertToSuspect();
        Suspect suspect1 = new Suspect(1, "John", "Thompson", 26, 72, 165, "white", "black", "brown", "658 Assembly Rd", "no alibi");
        boolean equals = suspect.getUuid() == suspect1.getUuid() && suspect.getFirstName().equals(suspect1.getFirstName()) && suspect.getLastName().equals(suspect1.getLastName()) && suspect.getAge() == suspect1.getAge() && suspect.getHeight() == suspect1.getHeight()
            && suspect.getWeight() == suspect1.getWeight() && suspect.getSkinColor().equals(suspect1.getSkinColor()) && suspect.getHairColor().equals(suspect1.getHairColor()) && suspect.getEyeColor().equals(suspect1.getEyeColor())
            && suspect.getAddress().equals(suspect1.getAddress()) && suspect.getAlibi().equals(suspect1.getAlibi());
        assertTrue(equals);
    }

    @Test
    void testCriminalConvertToSuspectEmpty() {
        Criminal criminal = new Criminal();
        Suspect suspect = criminal.convertToSuspect();
        Suspect suspect1 = new Suspect();
        boolean equals = suspect.getUuid() == suspect1.getUuid() && suspect.getFirstName().equals(suspect1.getFirstName()) && suspect.getLastName().equals(suspect1.getLastName()) && suspect.getAge() == suspect1.getAge() && suspect.getHeight() == suspect1.getHeight()
            && suspect.getWeight() == suspect1.getWeight() && suspect.getSkinColor().equals(suspect1.getSkinColor()) && suspect.getHairColor().equals(suspect1.getHairColor()) && suspect.getEyeColor().equals(suspect1.getEyeColor())
            && suspect.getAddress().equals(suspect1.getAddress()) && suspect.getAlibi().equals(suspect1.getAlibi());
        assertTrue(equals);
    }
}
