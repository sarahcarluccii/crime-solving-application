import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;


public class CrimeTest {

    @Test
    public void paramConstructorTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        assertEquals(id, c.getUuid());
        assertEquals(location, c.getLocation());
        assertEquals(date, c.getDate());
        assertEquals(description, c.getDescription());
        assertEquals(crimeType, c.getCrimeType());
        assertEquals(severity, c.getSeverity());
        assertEquals(jurisdiction, c.getJurisdiction());
        assertEquals(enteredCrime, c.getEnteredCrime());
    }

    @Test
    public void addVictimTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        Victim victim = new Victim();
        c.addVictim(victim);
        assertEquals(victim, c.getVictims().get(0));
    }
    
    @Test
    public void addWitnessTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        Witness witness = new Witness();
        c.addWitness(witness);
        assertEquals(witness, c.getWitnesses().get(0));
    }
    
    @Test
    public void addPersonOfInterestTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        PersonOfInterest personOfInterest = new PersonOfInterest();
        c.addPersonOfInterest(personOfInterest);
        assertEquals(personOfInterest, c.getPersonOfInterest().get(0));
    }
    
    @Test
    public void addUserTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        User user = new User();
        c.addUser(user);
        assertEquals(user, c.getUsers().get(0));
    }
    
    @Test
    public void addEvidenceTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        Evidence evidence = new Evidence();
        c.addEvidence(evidence);
        assertEquals(evidence, c.getEvidence().get(0));
    }
    
    @Test
    public void addCriminalTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0", extraInfo ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        Criminal criminal = new Criminal();
        c.addCriminal(criminal);
        assertEquals(criminal, c.getCriminals().get(0));
    }
    
    @Test
    public void toStringTest() {
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        assertEquals("ID: " + id + "\n\tLocation: " + location + "\n\tDate: " + date + "\n\tDescription: " + description +
        "\n\tCrime Type: " + crimeType + "\n\tSeverity:" + severity + "\n\tJurisdiction:" + jurisdiction + 
        "\n\tEntered Crime: " + enteredCrime, c.toString());
    }

    @Test
    public void addInfoTest() {
        String extraInfo = "test";
        int id = 0, severity = 0;
        String location ="0", date ="0", description ="0", crimeType ="0", jurisdiction ="0";
        User enteredCrime = new User();
        ArrayList<User> detectives = new ArrayList<User>();
        Crime c = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);
        c.addInfo(extraInfo);
        assertEquals("/n"+extraInfo, c.getInfo());
    }
}
