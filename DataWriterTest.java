import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
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
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}
	
	@Test
	void testWritingZeroCrimes() {
		crimeList = DataLoader.getCrimes();
		assertEquals(0, crimeList.size());
	}
	
	@Test
	void testWritingZeroCriminals() {
		criminalList = DataLoader.getCriminals();
		assertEquals(0, criminalList.size());
	}
	
	@Test
	void testWritingZeroEvidence() {
		evidenceList = DataLoader.getEvidences();
		assertEquals(0, evidenceList.size());
	}
	
	@Test
	void testWritingZeroPOI() {
		poiList = DataLoader.getPOIs();
		assertEquals(0, poiList.size());
	}
	
	@Test
	void testWritingZeroSuspects() {
		suspectList = DataLoader.getSuspects();
		assertEquals(0, suspectList.size());
	}
	
	@Test
	void testWritingZeroVictims() {
		victimList = DataLoader.getVictims();
		assertEquals(0, victimList.size());
	}
	
	@Test
	void testWritingZeroWitnesses() {
		witnessList = DataLoader.getWitnesses();
		assertEquals(0, witnessList.size());
	}

	@Test
	void testWritingOneUserFirstName() {
		userList.add(new User(1, "Billy", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		DataWriter.saveUsers();
		assertEquals("Billy", DataLoader.getUsers().get(0).getFirstName());
    }	
	
	@Test
	void testWritingOneCrimeCrimeType() {
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Robbery", new ArrayList<User>(), 8, "USCPD", new User()));
        crimeList.get(0).addVictim(new Victim());
        crimeList.get(0).addWitness(new Witness());
        crimeList.get(0).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(0).addSuspect(new Suspect());
        crimeList.get(0).addEvidence(new Evidence());
        crimeList.get(0).addCriminal(new Criminal());
		DataWriter.saveCrimes();
		assertEquals("Robbery", DataLoader.getCrimes().get(0).getCrimeType());
	}

	@Test
	void testWritingOneCriminalFirstName() {
        criminalList.add(new Criminal(1, "Dick", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(0).addTattoo("Dog");
        criminalList.get(0).addAlias("Big Bill");
        criminalList.get(0).setJail(true);
        criminalList.get(0).setAlive(true);
        criminalList.get(0).setChargesDropped(false);
		DataWriter.saveCriminals();
		assertEquals("Dick", DataLoader.getCriminals().get(0).getFirstName());
    }

	@Test
	void testWritingOneEvidenceType() {
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "Gun", "Burger King", "8:56am", new User(), comments));
		DataWriter.saveEvidences();
		assertEquals("Gun", DataLoader.getEvidences().get(0).getEvidenceType());
    }

	@Test
	void testWritingOnePOIFirstName() {
        poiList.add(new PersonOfInterest(1, "Jackon", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", new Suspect(), "None", "Father"));
        poiList.get(0).addStory("Tammy was with husband all day");
		DataWriter.savePOIs();
		assertEquals("Jackon", DataLoader.getPOIs().get(0).getFirstName());
    }

	@Test
	void testWritingOneSuspectFirstName() {
		suspectList.add(new Suspect(1, "Tammy", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
        suspectList.get(0).addTattoo("");
        suspectList.get(0).addAlias("Crazy Tammy");
		DataWriter.saveSuspects();
		assertEquals("Tammy", DataLoader.getSuspects().get(0).getFirstName());
    }

	@Test
	void testWritingOneVictimFirstName() {
        victimList.add(new Victim(1, "Corey", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(0).setHospitalized(false);
        victimList.get(0).setAlive(true);
        victimList.get(0).setAssociationToSuspect("None");
        victimList.get(0).addStory("Saw man with gun barge in and start screaming");
		DataWriter.saveVictims();
		assertEquals("Corey", DataLoader.getVictims().get(0).getFirstName());
    }

	@Test
	void testWritingOneWitnessFirstName() {
        witnessList.add(new Witness(1, "Barbara", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(0).addStory("Saw man with run away from atm dropping a crowbar");
		DataWriter.saveWitnesses();
		assertEquals("Barbara", DataLoader.getWitnesses().get(0).getFirstName());
    }
    
	@Test
	void testWritingFiveUsers() {
		userList.add(new User(1, "Billy", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		userList.add(new User(1, "John", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		userList.add(new User(1, "Jim", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		userList.add(new User(1, "Josh", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		userList.add(new User(1, "Danny", "Gene", "billygene@gmail.com", "8035456321", "USC", "Homicide", "651231654", "Detective", "password", new ArrayList<Crime>()));
		DataWriter.saveUsers();
		assertEquals("Danny", DataLoader.getUsers().get(4).getFirstName());
	}
    
	@Test
	void testWritingFiveCrimes() {
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Robbery", new ArrayList<User>(), 8, "USCPD", new User()));
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Murder", new ArrayList<User>(), 8, "USCPD", new User()));
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Assault", new ArrayList<User>(), 8, "USCPD", new User()));
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Burglary", new ArrayList<User>(), 8, "USCPD", new User()));
        crimeList.add(new Crime(1, "Burger King", "March 23, 1998", "Burger King was robbed at gunpoint", "Theft", new ArrayList<User>(), 8, "USCPD", new User()));
        crimeList.get(0).addVictim(new Victim());
        crimeList.get(0).addWitness(new Witness());
        crimeList.get(0).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(0).addSuspect(new Suspect());
        crimeList.get(0).addEvidence(new Evidence());
        crimeList.get(0).addCriminal(new Criminal());
        crimeList.get(1).addVictim(new Victim());
        crimeList.get(1).addWitness(new Witness());
        crimeList.get(1).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(1).addSuspect(new Suspect());
        crimeList.get(1).addEvidence(new Evidence());
        crimeList.get(1).addCriminal(new Criminal());
        crimeList.get(2).addVictim(new Victim());
        crimeList.get(2).addWitness(new Witness());
        crimeList.get(2).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(2).addSuspect(new Suspect());
        crimeList.get(2).addEvidence(new Evidence());
        crimeList.get(2).addCriminal(new Criminal());
        crimeList.get(3).addVictim(new Victim());
        crimeList.get(3).addWitness(new Witness());
        crimeList.get(3).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(3).addSuspect(new Suspect());
        crimeList.get(3).addEvidence(new Evidence());
        crimeList.get(3).addCriminal(new Criminal());
        crimeList.get(4).addVictim(new Victim());
        crimeList.get(4).addWitness(new Witness());
        crimeList.get(4).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(4).addSuspect(new Suspect());
        crimeList.get(4).addEvidence(new Evidence());
        crimeList.get(4).addCriminal(new Criminal());
		DataWriter.saveCrimes();
		assertEquals("Theft", DataLoader.getCrimes().get(4).getCrimeType());
	}

	@Test
	void testWritingFiveCriminal() {
        criminalList.add(new Criminal(1, "Dick", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(0).addTattoo("Dog");
        criminalList.get(0).addAlias("Big Bill");
        criminalList.get(0).setJail(true);
        criminalList.get(0).setAlive(true);
        criminalList.get(0).setChargesDropped(false);
        criminalList.add(new Criminal(1, "Jim", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(1).addTattoo("Dog");
        criminalList.get(1).addAlias("Big Bill");
        criminalList.get(1).setJail(true);
        criminalList.get(1).setAlive(true);
        criminalList.get(1).setChargesDropped(false);
        criminalList.add(new Criminal(1, "Bill", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(2).addTattoo("Dog");
        criminalList.get(2).addAlias("Big Bill");
        criminalList.get(2).setJail(true);
        criminalList.get(2).setAlive(true);
        criminalList.get(2).setChargesDropped(false);
        criminalList.add(new Criminal(1, "Jack", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(3).addTattoo("Dog");
        criminalList.get(3).addAlias("Big Bill");
        criminalList.get(3).setJail(true);
        criminalList.get(3).setAlive(true);
        criminalList.get(3).setChargesDropped(false);
        criminalList.add(new Criminal(1, "Alston", "Willis", 35, 74, 187, "brown", "Black", "blue", "896 Gervais St", new User()));
        criminalList.get(4).addTattoo("Dog");
        criminalList.get(4).addAlias("Big Bill");
        criminalList.get(4).setJail(true);
        criminalList.get(4).setAlive(true);
        criminalList.get(4).setChargesDropped(false);
		DataWriter.saveCriminals();
		assertEquals("Alston", DataLoader.getCriminals().get(4).getFirstName());
    }

	@Test
	void testWritingFiveEvidence() {
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "Gun", "Burger King", "8:56am", new User(), comments));
        comments.remove(0);
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "Knife", "Burger King", "8:56am", new User(), comments));
        comments.remove(0);
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "Crowbar", "Burger King", "8:56am", new User(), comments));
        comments.remove(0);
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "Blood", "Burger King", "8:56am", new User(), comments));
        comments.remove(0);
        comments.add("Suspect dropped the gun at the burger king");
        evidenceList.add(new Evidence(1, "DNA", "Burger King", "8:56am", new User(), comments));
        comments.remove(0);
		DataWriter.saveEvidences();
		assertEquals("DNA", DataLoader.getEvidences().get(4).getEvidenceType());
    }

	@Test
	void testWritingFivePOI() {
        poiList.add(new PersonOfInterest(1, "Jackon", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", new Suspect(), "None", "Father"));
        poiList.get(0).addStory("Tammy was with husband all day");
        poiList.add(new PersonOfInterest(1, "Jackson", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", new Suspect(), "None", "Father"));
        poiList.get(1).addStory("Tammy was with husband all day");
        poiList.add(new PersonOfInterest(1, "Jackson1", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", new Suspect(), "None", "Father"));
        poiList.get(2).addStory("Tammy was with husband all day");
        poiList.add(new PersonOfInterest(1, "Jackon2", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", new Suspect(), "None", "Father"));
        poiList.get(3).addStory("Tammy was with husband all day");
        poiList.add(new PersonOfInterest(1, "Danny", "Pollock", 74, 63, 200, "white", "white", "brown", "6000 Lincoln St", "8036365456", "jackonpollock@gmail.com", new Suspect(), "None", "Father"));
        poiList.get(4).addStory("Tammy was with husband all day");
		DataWriter.savePOIs();
		assertEquals("Danny", DataLoader.getPOIs().get(4).getFirstName());
    }

	@Test
	void testWritingFiveSuspect() {
		suspectList.add(new Suspect(1, "Tammy", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
        suspectList.get(0).addTattoo("");
        suspectList.get(0).addAlias("Crazy Tammy");
		suspectList.add(new Suspect(1, "Tammy1", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
        suspectList.get(1).addTattoo("");
        suspectList.get(1).addAlias("Crazy Tammy");
		suspectList.add(new Suspect(1, "Tammy2", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
        suspectList.get(2).addTattoo("");
        suspectList.get(2).addAlias("Crazy Tammy");
		suspectList.add(new Suspect(1, "Tammy3", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
        suspectList.get(3).addTattoo("");
        suspectList.get(3).addAlias("Crazy Tammy");
		suspectList.add(new Suspect(1, "Tammy4", "Swanson", 46, 68, 140, "white", "red", "green", "5984 Lincoln St", "Was with husband at the time"));
        suspectList.get(4).addTattoo("");
        suspectList.get(4).addAlias("Crazy Tammy");
		DataWriter.saveSuspects();
		assertEquals("Tammy4", DataLoader.getSuspects().get(4).getFirstName());
    }

	@Test
	void testWritingFiveVictim() {
        victimList.add(new Victim(1, "Corey", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(0).setHospitalized(false);
        victimList.get(0).setAlive(true);
        victimList.get(0).setAssociationToSuspect("None");
        victimList.get(0).addStory("Saw man with gun barge in and start screaming");
        victimList.add(new Victim(1, "Corey1", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(1).setHospitalized(false);
        victimList.get(1).setAlive(true);
        victimList.get(1).setAssociationToSuspect("None");
        victimList.get(1).addStory("Saw man with gun barge in and start screaming");
        victimList.add(new Victim(1, "Corey2", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(2).setHospitalized(false);
        victimList.get(2).setAlive(true);
        victimList.get(2).setAssociationToSuspect("None");
        victimList.get(2).addStory("Saw man with gun barge in and start screaming");
        victimList.add(new Victim(1, "Corey3", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(3).setHospitalized(false);
        victimList.get(3).setAlive(true);
        victimList.get(3).setAssociationToSuspect("None");
        victimList.get(3).addStory("Saw man with gun barge in and start screaming");
        victimList.add(new Victim(1, "Corey4", "Sinclair", 55, 63, 130, "black", "black", "brown", "542 Lincoln St", "8036987452", "coreysinclair@gmail.com", "None"));
        victimList.get(4).setHospitalized(false);
        victimList.get(4).setAlive(true);
        victimList.get(4).setAssociationToSuspect("None");
        victimList.get(4).addStory("Saw man with gun barge in and start screaming");
		DataWriter.saveVictims();
		assertEquals("Corey4", DataLoader.getVictims().get(4).getFirstName());
    }

	@Test
	void testWritingFiveWitness() {
        witnessList.add(new Witness(1, "Barbara", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(0).addStory("Saw man with run away from atm dropping a crowbar");
        witnessList.add(new Witness(1, "Barbara1", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(1).addStory("Saw man with run away from atm dropping a crowbar");
        witnessList.add(new Witness(1, "Barbara2", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(2).addStory("Saw man with run away from atm dropping a crowbar");
        witnessList.add(new Witness(1, "Barbara3", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(3).addStory("Saw man with run away from atm dropping a crowbar");
        witnessList.add(new Witness(1, "Barbara4", "Seager", 40, 72, 150, "white", "brown", "brown", "585 Assembly St", "8035478542", "barbaraseager@gmailcom"));
        witnessList.get(4).addStory("Saw man with run away from atm dropping a crowbar");
		DataWriter.saveWitnesses();
		assertEquals("Barbara4", DataLoader.getWitnesses().get(4).getFirstName());
    }
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new User(0, "", "", "", "", "", "", "", "", "", new ArrayList<Crime>()));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getFirstName());
	}
    
    @Test
    void testWritingEmptyCrime() {
        crimeList.add(new Crime(1, "", "", "", "", new ArrayList<User>(), 0, "", new User()));
        crimeList.get(0).addVictim(new Victim());
        crimeList.get(0).addWitness(new Witness());
        crimeList.get(0).addPersonOfInterest(new PersonOfInterest());
        crimeList.get(0).addSuspect(new Suspect());
        crimeList.get(0).addEvidence(new Evidence());
        crimeList.get(0).addCriminal(new Criminal());
        DataWriter.saveCrimes();
        assertEquals("", DataLoader.getCrimes().get(0).getCrimeType());
    }

	@Test
	void testWritingEmptyCriminal() {
        criminalList.add(new Criminal(0, "", "", 0, 0, 0, "", "", "", "", new User()));
        criminalList.get(0).addTattoo("");
        criminalList.get(0).addAlias("");
        criminalList.get(0).setJail(false);
        criminalList.get(0).setAlive(false);
        criminalList.get(0).setChargesDropped(false);
		DataWriter.saveCriminals();
		assertEquals("", DataLoader.getCriminals().get(0).getFirstName());
    }

	@Test
	void testWritingEmptyEvidence() {
        ArrayList<String> comments = new ArrayList<String>();
        evidenceList.add(new Evidence(0, "", "", "", new User(), comments));
		DataWriter.saveEvidences();
		assertEquals("", DataLoader.getEvidences().get(0).getEvidenceType());
    }

	@Test
	void testWritingEmptyPOI() {
        poiList.add(new PersonOfInterest(0, "", "", 0, 0, 0, "", "", "", "", "", "", new Suspect(), "", ""));
        poiList.get(0).addStory("");
		DataWriter.savePOIs();
		assertEquals("", DataLoader.getPOIs().get(0).getFirstName());
    }

	@Test
	void testWritingEmptySuspect() {
		suspectList.add(new Suspect(0, "", "", 0, 0, 0, "", "", "", "", ""));
        suspectList.get(0).addTattoo("");
        suspectList.get(0).addAlias("");
		DataWriter.saveSuspects();
		assertEquals("", DataLoader.getSuspects().get(0).getFirstName());
    }

	@Test
	void testWritingEmptyVictim() {
        victimList.add(new Victim(0, "", "", 0, 0, 0, "", "", "", "", "", "", ""));
        victimList.get(0).setHospitalized(false);
        victimList.get(0).setAlive(false);
        victimList.get(0).setAssociationToSuspect("");
        victimList.get(0).addStory("");
		DataWriter.saveVictims();
		assertEquals("", DataLoader.getVictims().get(0).getFirstName());
    }

	@Test
	void testWritingEmptyWitness() {
        witnessList.add(new Witness(0, "", "", 0, 0, 0, "", "", "", "", "", ""));
        witnessList.get(0).addStory("");
		DataWriter.saveWitnesses();
		assertEquals("", DataLoader.getWitnesses().get(0).getFirstName());
    }
}
