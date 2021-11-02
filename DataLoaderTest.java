import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private CriminalApplication crapp = CriminalApplication.getInstance();
	private ArrayList<User> userList = crapp.getUsers();
	private ArrayList<Crime> crimeList = crapp.getCrimes();
	private ArrayList<Criminal> criminalList = crapp.getCriminals();
	private ArrayList<Evidence> evidenceList = crapp.getEvidence();
	private ArrayList<PersonOfInterest> poiList = crapp.getPersonsOfInterest();
	private ArrayList<Suspect> suspectList = crapp.getSuspects();
	private ArrayList<Victim> victimList = crapp.getVictims();
	private ArrayList<Witness> witnessList = crapp.getWitnesses();
	
	@BeforeEach
	public void setup() {
		userList.clear();
        crimeList.clear();
        criminalList.clear();
        evidenceList.clear();
        poiList.clear();
        suspectList.clear();
        victimList.clear();
        witnessList.clear();
		userList.add(new User(1, "Billy", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		userList.add(new User(2, "Bob", "Burger", "bobburger@gmail.com", "8034782125", "USC", "Narcotics", "6549139654", "Officer", "bobiscool", new ArrayList<Crime>()));
        criminalList.add(new Criminal(1, "John", "Thompson", 26, 72, 165, "white", "black", "brown", "658 Assembly Rd", userList.get(0)));
        criminalList.add(new Criminal(2, "Dick", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", userList.get(1)));
        criminalList.get(0).addTattoo("Dog");
        criminalList.get(1).addTattoo("Truck");
        criminalList.get(0).addAlias("Big Bill");
        criminalList.get(1).addAlias("Belcher");
        criminalList.get(0).setJail(true);
        criminalList.get(1).setJail(false);
        criminalList.get(0).setAlive(true);
        criminalList.get(1).setAlive(true);
        criminalList.get(0).setChargesDropped(false);
        criminalList.get(1).setChargesDropped(true);
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "Gun", "Burger King", "8:56am", userList.get(0), comments));
        comments.remove(0);
        comments.add("Crowbar was found next to the atm");
        evidenceList.add(new Evidence(2, "Crowbar", "Wells Fargo", "11:35pm", userList.get(1), comments));
		suspectList.add(new Suspect(1, "Tammy", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
		suspectList.add(new Suspect(2, "Don", "Johnson", 32, 70, 170, "white", "black", "brown", "659 Main St", "Was in an interview"));
        suspectList.get(0).addTattoo("");
        suspectList.get(1).addTattoo("Flower");
        suspectList.get(0).addAlias("Crazy Tammy");
        suspectList.get(1).addAlias("");
        poiList.add(new PersonOfInterest(1, "Jackon", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", suspectList.get(0), "None", "Father"));
        poiList.add(new PersonOfInterest(2, "Janet", "Johnson", 30, 65, 143, "white", "blond", "blue", "659 Main St", "8038527145", "janetjohnson@gmail.com", suspectList.get(1), "None", "Wife"));
        poiList.get(0).addStory("Tammy was with husband all day");
        poiList.get(1).addStory("Don was missing all day");
        victimList.add(new Victim(1, "Corey", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(0).setHospitalized(false);
        victimList.get(0).setAlive(true);
        victimList.get(0).setAssociationToSuspect("None");
        victimList.get(0).addStory("Saw man with gun barge in and start screaming");
        witnessList.add(new Witness(1, "Barbara", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(0).addStory("Saw man with run away from atm dropping a crowbar");
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Robbery", userList, 8, "USCPD", userList.get(0)));
        crimeList.add(new Crime(2, "Wells Fargo", "April 8, 2021", "Wells fargo atm was broken into", "Breaking", userList, 6, "USCPD", userList.get(1)));
        crimeList.get(0).addVictim(victimList.get(0));
        crimeList.get(1).addWitness(witnessList.get(0));
        crimeList.get(0).addPersonOfInterest(poiList.get(0));
        crimeList.get(1).addPersonOfInterest(poiList.get(1));
        crimeList.get(0).addSuspect(suspectList.get(0));
        crimeList.get(1).addSuspect(suspectList.get(1));
        crimeList.get(0).addEvidence(evidenceList.get(0));
        crimeList.get(1).addEvidence(evidenceList.get(1));
        crimeList.get(0).addCriminal(criminalList.get(0));
        crimeList.get(1).addCriminal(criminalList.get(1));
        DataWriter.saveUsers();
        DataWriter.saveCrimes();
        DataWriter.saveCriminals();
        DataWriter.saveEvidences();
        DataWriter.savePOIs();
        DataWriter.saveSuspects();
        DataWriter.saveVictims();
        DataWriter.saveWitnesses();
	}
	
	@AfterEach
	public void tearDown() {
		CriminalApplication.getInstance().getUsers().clear();
		CriminalApplication.getInstance().getCrimes().clear();
		CriminalApplication.getInstance().getCriminals().clear();
		CriminalApplication.getInstance().getEvidence().clear();
		CriminalApplication.getInstance().getPersonsOfInterest().clear();
		CriminalApplication.getInstance().getSuspects().clear();
		CriminalApplication.getInstance().getVictims().clear();
		CriminalApplication.getInstance().getWitnesses().clear();
		DataWriter.saveUsers();
		DataWriter.saveCrimes();
		DataWriter.saveCriminals();
		DataWriter.saveEvidences();
		DataWriter.savePOIs();
		DataWriter.saveSuspects();
		DataWriter.saveVictims();
		DataWriter.saveWitnesses();
	}
	
	@Test
	void testGetUsersSize() {
		userList = DataLoader.getUsers();
		assertEquals(2, userList.size());
	}
	
	@Test
	void testGetCrimesSize() {
		crimeList = DataLoader.getCrimes();
		assertEquals(2, crimeList.size());
	}
	
	@Test
	void testGetCriminalsSize() {
		criminalList = DataLoader.getCriminals();
		assertEquals(2, criminalList.size());
	}
	
	@Test
	void testGetEvidenceSize() {
		evidenceList = DataLoader.getEvidences();
		assertEquals(2, evidenceList.size());
	}
	
	@Test
	void testGetVictimSize() {
		victimList = DataLoader.getVictims();
		assertEquals(1, victimList.size());
	}
	
	@Test
	void testGetSuspectSize() {
		suspectList = DataLoader.getSuspects();
		assertEquals(2, suspectList.size());
	}
	
	@Test
	void testGetPOISize() {
		poiList = DataLoader.getPOIs();
		assertEquals(2, poiList.size());
	}
	
	@Test
	void testGetWitnessSize() {
		witnessList = DataLoader.getWitnesses();
		assertEquals(1, witnessList.size());
	}
    
    @Test
    void testGetUserID() {
        userList = DataLoader.getUsers();
        assertEquals(1, userList.get(0).getUuid());
    }
    
    @Test
    void testGetUserFirstName() {
        userList = DataLoader.getUsers();
        assertEquals("Bob", userList.get(1).getFirstName());
    }
    
    @Test
    void testGetUserEmail() {
        userList = DataLoader.getUsers();
        assertEquals("bobburger@gmail.com", userList.get(1).getEmail());
    }
    
    @Test
    void testGetUserPassword() {
        userList = DataLoader.getUsers();
        assertEquals("bobiscool", userList.get(1).getPassword());
    }
    
    @Test
    void testGetCriminalAge() {
        criminalList = DataLoader.getCriminals();
        assertEquals(26, criminalList.get(0).getAge());
    }
    
    @Test
    void testGetCriminalDetective() {
        criminalList = DataLoader.getCriminals();
        userList = DataLoader.getUsers();
        assertEquals(userList.get(0).getUuid(), criminalList.get(0).getEnteredCriminal().getUuid());
    }
    
    @Test
    void testGetCriminaljail() {
        criminalList = DataLoader.getCriminals();
        assertEquals(true, criminalList.get(0).getJail());
    }
    
    @Test
    void testGetEvidenceTime() {
        evidenceList = DataLoader.getEvidences();
        assertEquals("11:35pm", evidenceList.get(1).getTime());
    }
    
    @Test
    void testGetSuspectWeight() {
        suspectList = DataLoader.getSuspects();
        assertEquals(140, suspectList.get(0).getWeight());
    }
    
    @Test
    void testGetSuspectTattooEmpty() {
        suspectList = DataLoader.getSuspects();
        assertEquals("", suspectList.get(0).getTattoo());
    }
    
    @Test
    void testGetPOIEmail() {
        poiList = DataLoader.getPOIs();
        assertEquals("jackonpollock@gmail.com", poiList.get(0).getEmail());
    }
    
    @Test
    void testGetPOISuspectAssociatedToID() {
        poiList = DataLoader.getPOIs();
        assertEquals(2, poiList.get(1).getSuspectAssociatedTo().getUuid());
    }
    
    @Test
    void testGetVictimPhoneNumber() {
        victimList = DataLoader.getVictims();
        assertEquals("8036987452", victimList.get(0).getPhoneNumber());
    }  
    
    @Test
    void testGetVictimHospitalized() {
        victimList = DataLoader.getVictims();
        assertEquals(false, victimList.get(0).getHospitalized());
    }  
    
    @Test
    void testGetWitnessLastName() {
        witnessList = DataLoader.getWitnesses();
        assertEquals("Seager", witnessList.get(0).getLastName());
    }  
    
    @Test
    void testGetWitnessStory() {
        witnessList = DataLoader.getWitnesses();
        assertEquals("Saw man with run away from atm dropping a crowbar", witnessList.get(0).getLastStory());
    }  
    
    @Test
    void testGetCrimeVictimFirstName() {
        crimeList = DataLoader.getCrimes();
        assertEquals("Corey", crimeList.get(0).getVictims().get(0).getFirstName());
    }  
    
    @Test
    void testGetCrimeVictimEmpty() {
        crimeList = DataLoader.getCrimes();
        assertEquals(new ArrayList<Victim>(), crimeList.get(1).getVictims());
    }  
    
    @Test
    void testGetCrimeWitnessAge() {
        crimeList = DataLoader.getCrimes();
        assertEquals(40, crimeList.get(1).getWitnesses().get(0).getAge());
    }  
    
    @Test
    void testGetCrimeWitnessEmpty() {
        crimeList = DataLoader.getCrimes();
        assertEquals(new ArrayList<Witness>(), crimeList.get(0).getWitnesses().get(0));
    }  
    
    @Test
    void testGetCrimePersonOfInterestAddress() {
        crimeList = DataLoader.getCrimes();
        assertEquals("6000 Lincoln St", crimeList.get(0).getPersonOfInterest().get(0).getAddress());
    }  
    
    @Test
    void testGetCrimeSuspectAlias() {
        crimeList = DataLoader.getCrimes();
        assertEquals("Crazy Tammy", crimeList.get(0).getSuspects().get(0).getAlias());
    }  
    
    @Test
    void testGetCrimeEvidenceType() {
        crimeList = DataLoader.getCrimes();
        assertEquals("Crowbar", crimeList.get(1).getEvidence().get(0).getEvidenceType());
    }  
    
    @Test
    void testGetCrimeCriminalHeight() {
        crimeList = DataLoader.getCrimes();
        assertEquals(72, crimeList.get(0).getCriminals().get(0).getHeight());
    }
    
}
