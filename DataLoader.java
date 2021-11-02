import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    //May need to create ArrayLists for all attributes that only do Strings, ints and booleans.
    //Then need to fill them somehow after with other objects
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
            ArrayList<Crime> crimesWorking = new ArrayList<Crime>();

            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
				String firstName = (String)personJSON.get(FIRST_NAME);
				String lastName = (String)personJSON.get(LAST_NAME);
				String email = (String)personJSON.get(EMAIL);
				String phoneNumber = (String)personJSON.get(PHONE_NUMBER);
				String precinct = (String)personJSON.get(USER_PRECINCT);
				String department = (String)personJSON.get(USER_DEPARTMENT);
				String badgeNumber = (String)personJSON.get(USER_BADGE_NUMBER);
				String rank = (String)personJSON.get(USER_RANK);
				String password = (String)personJSON.get(USER_PASSWORD);
                //Need to search the crimes the user is working

                users.add(new User(id, firstName, lastName, email, phoneNumber, precinct, department, badgeNumber, rank, password, crimesWorking));
            }
            return users;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Crime> getCrimes() {
        ArrayList<Crime> crimes = new ArrayList<Crime>();
        
        try {
            FileReader reader = new FileReader(CRIME_FILE_NAME);
            JSONParser parser = new JSONParser();	
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                ArrayList<User> detectives = new ArrayList<User>();
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String location = (String)personJSON.get(LOCATION);
                String date = (String)personJSON.get(DATE);
                String description = (String)personJSON.get(DESCRIPTION);
                String crimeType = (String)personJSON.get(CRIME_TYPE);
                JSONArray users = (JSONArray)personJSON.get(USERS);
                for(int j = 0; j < users.size(); j++) {
                    JSONObject usersJSON = (JSONObject)users.get(j);
                    int uid = ((Long)usersJSON.get(ID)).intValue();
                    detectives.add(CriminalApplication.getInstance().getUser(uid));
                }
                int severity = ((Long)personJSON.get(CRIME_SEVERITY)).intValue();
                String jurisdiction = (String)personJSON.get(CRIME_JURISDICTION);
                int enteredCrimeID = ((Long)personJSON.get(CRIME_ENTERED_ID)).intValue();
                User enteredCrime = CriminalApplication.getInstance().getUser(enteredCrimeID);

                Crime crime = new Crime(id, location, date, description, crimeType, detectives, severity, jurisdiction, enteredCrime);

                JSONArray vics = (JSONArray)personJSON.get(VICTIMS);
                for(int j = 0; j < vics.size(); j++) {
                    JSONObject vicsJSON = (JSONObject)vics.get(j);
                    int vid = ((Long)vicsJSON.get(ID)).intValue();
                    crime.addVictim(CriminalApplication.getInstance().getVictim(vid)); // I think I need to create a new Victims class
                }

                JSONArray wits = (JSONArray)personJSON.get(WITNESSSES);
                for(int j = 0; j < wits.size(); j++) {
                    JSONObject witsJSON = (JSONObject)wits.get(j);
                    int wid = ((Long)witsJSON.get(ID)).intValue();
                    crime.addWitness(CriminalApplication.getInstance().getWitness(wid)); // I think I need to create a new Victims class
                }
                
                JSONArray pers = (JSONArray)personJSON.get(POI);
                for(int j = 0; j < pers.size(); j++) {
                    JSONObject persJSON = (JSONObject)pers.get(j);
                    int pid = ((Long)persJSON.get(ID)).intValue();
                    crime.addPersonOfInterest(CriminalApplication.getInstance().getPersonOfInterest(pid)); // I think I need to create a new Victims class
                }

                JSONArray susps = (JSONArray)personJSON.get(SUSPECTS);
                for(int j = 0; j < susps.size(); j++) {
                    JSONObject suspsJSON = (JSONObject)susps.get(j);
                    int sid = ((Long)suspsJSON.get(ID)).intValue();
                    crime.addSuspect(CriminalApplication.getInstance().getSuspect(sid)); // I think I need to create a new Victims class
                }

                JSONArray evids = (JSONArray)personJSON.get(EVIDENCE);
                for(int j = 0; j < evids.size(); j++) {
                    JSONObject evidsJSON = (JSONObject)evids.get(j);
                    int eid = ((Long)evidsJSON.get(ID)).intValue();
                    crime.addEvidence(CriminalApplication.getInstance().getEvidence(eid)); // I think I need to create a new Victims class
                }

                JSONArray crims = (JSONArray)personJSON.get(CRIMINALS);
                for(int j = 0; j < crims.size(); j++) {
                    JSONObject crimsJSON = (JSONObject)crims.get(j);
                    int cid = ((Long)crimsJSON.get(ID)).intValue();
                    crime.addCriminal(CriminalApplication.getInstance().getCriminal(cid)); // I think I need to create a new Victims class
                }
                
                boolean solved = ((Boolean)personJSON.get(CRIME_SOVLED)).booleanValue();
                crime.setSolved(solved);

                String extraInfo = (String)personJSON.get(EXTRA_INFO);
                crime.addInfo(extraInfo);

                crimes.add(crime);
    
            }
            return crimes;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Criminal> getCriminals() {
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();

        try {
            FileReader reader = new FileReader(CRIMINAL_FILE);
            JSONParser parser = new JSONParser();	
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String firstName = (String)personJSON.get(FIRST_NAME);
                String lastName = (String)personJSON.get(LAST_NAME);
                int age = ((Long)personJSON.get(AGE)).intValue();
                int weight = ((Long)personJSON.get(WEIGHT)).intValue();
                int height = ((Long)personJSON.get(HEIGHT)).intValue();
                String skinColor = (String)personJSON.get(SKIN);
                String hairColor = (String)personJSON.get(HAIR);
                String eyeColor = (String)personJSON.get(EYE);
                String address = (String)personJSON.get(ADDRESS);
                boolean hasTattoos = ((Boolean)personJSON.get(HAS_TATTOOS)).booleanValue();
                String tattoos = (String)personJSON.get(TATTOOS);
                String aliases = (String)personJSON.get(ALIASES);
                boolean jail = ((Boolean)personJSON.get(JAIL)).booleanValue();
                boolean alive = ((Boolean)personJSON.get(ALIVE)).booleanValue();
                boolean chargesDropped = ((Boolean)personJSON.get(CHARGES_DROPPED)).booleanValue();
                int severity = ((Long)personJSON.get(SEVERITY)).intValue();
                int enteredCriminalID = ((Long)personJSON.get(ENTERED_CRIMINAL)).intValue();
                User enteredCriminal = CriminalApplication.getInstance().getUser(enteredCriminalID);

                Criminal criminal = new Criminal(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, enteredCriminal);
                if(hasTattoos) {
                    criminal.addTattoo(tattoos);                    
                }
                if(aliases != null) {
                    criminal.addAlias(aliases);
                }
                // for(Crime crime: CriminalApplication.getInstance().getCrimes()) {
                //     for(Criminal crim: crime.getCriminals()) {
                //         if(crim.getUuid() == id) {
                //             criminal.addPastCrime(crime);
                //         }
                //     }
                // }
                // for(Crime crime: criminal.getPastCrimes()) {
                //     for(Criminal crim: crime.getCriminals()) {
                //         criminal.addAssociate(crim);
                //     }
                // }
                criminal.setJail(jail);
                criminal.setAlive(alive);
                criminal.setChargesDropped(chargesDropped);
                criminal.setSeverity(severity);
                //criminal.addingInfo(info, addedInfo); //Need info and person that added it
                
                criminals.add(criminal);
            }
            
            return criminals;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Evidence> getEvidences() {
        ArrayList<Evidence> evidences = new ArrayList<Evidence>();

        try {
            FileReader reader = new FileReader(EVIDENCE_FILE);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String evidenceType = (String)personJSON.get(EVIDENCE_TYPE);
                String location = (String)personJSON.get(LOCATION);
                String time = (String)personJSON.get(TIMES);
                int enteredEvidenceID = ((Long)personJSON.get(ENTERED_EVIDENCE)).intValue();
                User enteredEvidence = CriminalApplication.getInstance().getUser(enteredEvidenceID);
                JSONArray commentsJSON = (JSONArray)personJSON.get(COMMENTS);
                ArrayList<String> comments = new ArrayList<String>();
                for(int j = 0; j < commentsJSON.size(); j++) {
                    JSONObject commentJSON = (JSONObject)commentsJSON.get(j);
                    String comment = (String)commentJSON.get(COMMENT);
                    comments.add(comment);
                } //Need to read JSONArray

                evidences.add(new Evidence(id, evidenceType, location, time, enteredEvidence, comments));
            }
            return evidences;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<PersonOfInterest> getPOIs() {
        ArrayList<PersonOfInterest> personsofinterest = new ArrayList<PersonOfInterest>();

        try {
            FileReader reader = new FileReader(POI_FILE);
            JSONParser parser = new JSONParser();	
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String firstName = (String)personJSON.get(FIRST_NAME);
                String lastName = (String)personJSON.get(LAST_NAME);
                int age = ((Long)personJSON.get(AGE)).intValue();
                int height = ((Long)personJSON.get(HEIGHT)).intValue();
                int weight = ((Long)personJSON.get(WEIGHT)).intValue();
                String skinColor = (String)personJSON.get(SKIN);
                String hairColor = (String)personJSON.get(HAIR);
                String eyeColor = (String)personJSON.get(EYE);
                String address = (String)personJSON.get(ADDRESS);
                String image = (String)personJSON.get(IMAGE);
                String phoneNumber = (String)personJSON.get(PHONE_NUMBER);
                String email = (String)personJSON.get(EMAIL);
                int suspectAssociatedToID = ((Long)personJSON.get(SUSPECT_ASSOCIATED_TO)).intValue();
                Suspect suspectAssociatedTo = new Suspect(suspectAssociatedToID);
                String associationToSuspect = (String)personJSON.get(ASSOCIATION_TO_SUSPECT);
                String associationToCase = "";
                PersonOfInterest poi = new PersonOfInterest(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, suspectAssociatedTo, associationToCase, associationToSuspect);
                JSONArray storiesJSON = (JSONArray)personJSON.get(STORIES);
                for(int j = 0; j < storiesJSON.size(); j++) {
                    JSONObject storyJSON = (JSONObject)storiesJSON.get(j);
                    String story = (String)storyJSON.get(STORY);
                    poi.addStory(story);
                } //Need to read JSONArray
                personsofinterest.add(poi);
            }
            return personsofinterest;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Suspect> getSuspects() {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();

        try {
            FileReader reader = new FileReader(SUSPECT_FILE);
            JSONParser parser = new JSONParser();	
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String firstName = (String)personJSON.get(FIRST_NAME);
                String lastName = (String)personJSON.get(LAST_NAME);
                int age = ((Long)personJSON.get(AGE)).intValue();
                int height = ((Long)personJSON.get(HEIGHT)).intValue();
                int weight = ((Long)personJSON.get(WEIGHT)).intValue();
                String skinColor = (String)personJSON.get(SKIN);
                String hairColor = (String)personJSON.get(HAIR);
                String eyeColor = (String)personJSON.get(EYE);
                String address = (String)personJSON.get(ADDRESS);
                boolean hasTattoos = ((Boolean)personJSON.get(HAS_TATTOOS)).booleanValue();
                String tattoos = (String)personJSON.get(TATTOOS);
                String aliases = (String)personJSON.get(ALIASES);
                String alibi = (String)personJSON.get(ALIBI);

                Suspect suspect = new Suspect(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, alibi);

                // for(Crime crime: CriminalApplication.getInstance().loadCrimes()) {
                //     for(Criminal criminal: crime.getCriminals()) {
                //         if(criminal.getUuid() == id) {
                //             suspect.addCrime(crime);
                //         }
                //     }
                // }
                // for(Crime crime: suspect.getCrimes()) {
                //     for(Criminal criminal: crime.getCriminals()) {
                //         suspect.addAssociate(criminal);
                //     }
                //     for(Evidence evidence: crime.getEvidence()) {
                //         suspect.addEvidence(evidence);
                //     }
                // }
                if(hasTattoos) {
                    suspect.addTattoo(tattoos);
                }

                suspect.addAlias(aliases);

                suspects.add(suspect);
            }
            return suspects;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Victim> getVictims() {
        ArrayList<Victim> victims = new ArrayList<Victim>();

        try {
            FileReader reader = new FileReader(VICTIM_FILE);
            JSONParser parser = new JSONParser();	
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String firstName = (String)personJSON.get(FIRST_NAME);
                String lastName = (String)personJSON.get(LAST_NAME);
                int age = ((Long)personJSON.get(AGE)).intValue();
                int height = ((Long)personJSON.get(HEIGHT)).intValue();
                int weight = ((Long)personJSON.get(WEIGHT)).intValue();
                String skinColor = (String)personJSON.get(SKIN);
                String hairColor = (String)personJSON.get(HAIR);
                String eyeColor = (String)personJSON.get(EYE);
                String email = (String)personJSON.get(EMAIL);
                String address = (String)personJSON.get(ADDRESS);
                String phoneNumber = (String)personJSON.get(PHONE_NUMBER);
                boolean hospitalized = ((Boolean)personJSON.get(HOSPITALIZED)).booleanValue();
                boolean alive = ((Boolean)personJSON.get(ALIVE)).booleanValue();
                String associationToSuspect = (String)personJSON.get(ASSOCIATION_TO_SUSPECT);
                String story = (String)personJSON.get(STORIES);

                Victim victim = new Victim(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email, associationToSuspect);
                
                victim.addStory(story);
                victim.setAlive(alive);
                victim.setHospitalized(hospitalized);

                victims.add(victim);
            }
            return victims;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Witness> getWitnesses() {
        ArrayList<Witness> witnesses = new ArrayList<Witness>();

        try {
            FileReader reader = new FileReader(WITNESS_FILE);
            JSONParser parser = new JSONParser();	
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
    
            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                int id = ((Long)personJSON.get(ID)).intValue();
                String firstName = (String)personJSON.get(FIRST_NAME);
                String lastName = (String)personJSON.get(LAST_NAME);
                int age = ((Long)personJSON.get(AGE)).intValue();
                int height = ((Long)personJSON.get(HEIGHT)).intValue();
                int weight = ((Long)personJSON.get(WEIGHT)).intValue();
                String skinColor = (String)personJSON.get(SKIN);
                String hairColor = (String)personJSON.get(HAIR);
                String eyeColor = (String)personJSON.get(EYE);
                String email = (String)personJSON.get(EMAIL);
                String address = (String)personJSON.get(ADDRESS);
                String phoneNumber = (String)personJSON.get(PHONE_NUMBER);
                String stories = (String)personJSON.get(STORIES);

                Witness witness = new Witness(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address, phoneNumber, email);
                witness.addStory(stories);

                witnesses.add(witness);
            }
            return witnesses;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Crime> users =  DataLoader.getCrimes();
        for(Crime user: users) {
            System.out.println(user);
        }
    }
    
}
