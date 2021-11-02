import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveUsers() {
		ArrayList<User> userList = CriminalApplication.getInstance().getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCrimes() {
        ArrayList<Crime> crimeList = CriminalApplication.getInstance().getCrimes();
        JSONArray jsonCrimes = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< crimeList.size(); i++) {
			jsonCrimes.add(getCrimeJSON(crimeList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CRIME_FILE_NAME)) {
 
            file.write(jsonCrimes.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCriminals() {
        ArrayList<Criminal> criminalList = CriminalApplication.getInstance().getCriminals();
        JSONArray jsonCriminals = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< criminalList.size(); i++) {
			jsonCriminals.add(getCriminalJSON(criminalList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CRIMINAL_FILE)) {
 
            file.write(jsonCriminals.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveEvidences() {
        ArrayList<Evidence> evidenceList = CriminalApplication.getInstance().getEvidence();
        JSONArray jsonEvidences = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< evidenceList.size(); i++) {
			jsonEvidences.add(getEvidenceJSON(evidenceList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(EVIDENCE_FILE)) {
 
            file.write(jsonEvidences.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePOIs() {
        ArrayList<PersonOfInterest> poiList = CriminalApplication.getInstance().getPersonsOfInterest();
        JSONArray jsonPOIs = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< poiList.size(); i++) {
			jsonPOIs.add(getPOIJSON(poiList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(POI_FILE)) {
 
            file.write(jsonPOIs.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveSuspects() {
        ArrayList<Suspect> suspectsList = CriminalApplication.getInstance().getSuspects();
        JSONArray jsonSuspects = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< suspectsList.size(); i++) {
			jsonSuspects.add(getSuspectJSON(suspectsList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(SUSPECT_FILE)) {
 
            file.write(jsonSuspects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveVictims() {
        ArrayList<Victim> victimList = CriminalApplication.getInstance().getVictims();
        JSONArray jsonVictims = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< victimList.size(); i++) {
			jsonVictims.add(getVictimJSON(victimList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(VICTIM_FILE)) {
 
            file.write(jsonVictims.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveWitnesses() {
        ArrayList<Witness> witnessList = CriminalApplication.getInstance().getWitnesses();
        JSONArray jsonWitnesss = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< witnessList.size(); i++) {
			jsonWitnesss.add(getWitnessJSON(witnessList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(WITNESS_FILE)) {
 
            file.write(jsonWitnesss.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(ID, user.getUuid());
		userDetails.put(FIRST_NAME, user.getFirstName());
		userDetails.put(LAST_NAME, user.getLastName());
		userDetails.put(EMAIL, user.getEmail());
		userDetails.put(PHONE_NUMBER, user.getPhoneNumber());
		userDetails.put(USER_PRECINCT, user.getPrecinct());
		userDetails.put(USER_DEPARTMENT, user.getDepartment());
		userDetails.put(USER_BADGE_NUMBER, user.getBadgeNumber());
		userDetails.put(USER_RANK, user.getRank());
		userDetails.put(USER_PASSWORD, user.getPassword());

        return userDetails;
    }

    public static JSONObject getCrimeJSON(Crime crime) {
        JSONObject crimeDetails = new JSONObject();
        crimeDetails.put(ID, crime.getUuid());
        crimeDetails.put(LOCATION, crime.getLocation());
        crimeDetails.put(DATE, crime.getDate());
        crimeDetails.put(DESCRIPTION, crime.getDescription());
        crimeDetails.put(CRIME_TYPE, crime.getCrimeType());
        JSONArray users = new JSONArray();
        for(int j = 0; j < crime.getUsers().size(); j++) {
            JSONObject user = new JSONObject();
            user.put(ID, crime.getUsers().get(j).getUuid());
            users.add(user);
        }
        crimeDetails.put(USERS, users);
        crimeDetails.put(CRIME_SEVERITY, crime.getSeverity());
        crimeDetails.put(CRIME_JURISDICTION, crime.getJurisdiction());
        crimeDetails.put(CRIME_ENTERED_ID, crime.getEnteredCrime().getUuid());
        JSONArray vics = new JSONArray();
        for(int j = 0; j < crime.getVictims().size(); j++) {
            JSONObject vic = new JSONObject();
            vic.put(ID, crime.getVictims().get(j).getUuid());
            vics.add(vic);
        }
        crimeDetails.put(VICTIMS, vics);
        JSONArray wits = new JSONArray();
        for(int j = 0; j < crime.getWitnesses().size(); j++) {
            JSONObject wit = new JSONObject();
            wit.put(ID, crime.getWitnesses().get(j).getUuid());
            wits.add(wit);
        }
        crimeDetails.put(WITNESSSES, wits);
        JSONArray pers = new JSONArray();
        for(int j = 0; j < crime.getPersonOfInterest().size(); j++) {
            JSONObject per = new JSONObject();
            per.put(ID, crime.getPersonOfInterest().get(j).getUuid());
            pers.add(per);
        }
        crimeDetails.put(POI, pers);
        JSONArray susps = new JSONArray();
        for(int j = 0; j < crime.getSuspects().size(); j++) {
            JSONObject susp = new JSONObject();
            susp.put(ID, crime.getSuspects().get(j).getUuid());
            susps.add(susp);
        }
        crimeDetails.put(SUSPECTS, susps);
        JSONArray evids = new JSONArray();
        for(int j = 0; j < crime.getEvidence().size(); j++) {
            JSONObject evid = new JSONObject();
            evid.put(ID, crime.getEvidence().get(j).getUuid());
            evids.add(evid);
        }
        crimeDetails.put(EVIDENCE, evids);
        JSONArray crims = new JSONArray();
        for(int j = 0; j < crime.getCriminals().size(); j++) {
            JSONObject crim = new JSONObject();
            crim.put(ID, crime.getCriminals().get(j).getUuid());
            crims.add(crim);
        }
        crimeDetails.put(CRIMINALS, crims);        
        crimeDetails.put(CRIME_SOVLED, crime.getSolved());
        crimeDetails.put(EXTRA_INFO, crime.getInfo());
        return crimeDetails;
    }

    public static JSONObject getCriminalJSON(Criminal criminal) {
        JSONObject criminalDetails = new JSONObject();
        criminalDetails.put(ID, criminal.getUuid());
        criminalDetails.put(FIRST_NAME, criminal.getFirstName());
        criminalDetails.put(LAST_NAME, criminal.getLastName());
        criminalDetails.put(AGE, criminal.getAge());
        criminalDetails.put(WEIGHT, criminal.getWeight());
        criminalDetails.put(HEIGHT, criminal.getHeight());
        criminalDetails.put(SKIN, criminal.getSkinColor());
        criminalDetails.put(HAIR, criminal.getHairColor());
        criminalDetails.put(EYE, criminal.getEyeColor());
        criminalDetails.put(ADDRESS, criminal.getAddress());
        criminalDetails.put(HAS_TATTOOS, criminal.getHasTattoos());
        criminalDetails.put(TATTOOS, criminal.getTattoo());
        criminalDetails.put(ALIASES, criminal.getAlias());
        criminalDetails.put(JAIL, criminal.getJail());
        criminalDetails.put(ALIVE, criminal.getAlive());
        criminalDetails.put(CHARGES_DROPPED, criminal.getChargesDropped());
        criminalDetails.put(SEVERITY, criminal.getSeverity());
        criminalDetails.put(ENTERED_CRIMINAL, criminal.getEnteredCriminal().getUuid());
        return criminalDetails;
    }

    public static JSONObject getEvidenceJSON(Evidence evidence) {
        JSONObject evidenceDetails = new JSONObject();
        evidenceDetails.put(ID, evidence.getUuid());
        evidenceDetails.put(EVIDENCE_TYPE, evidence.getEvidenceType());
        evidenceDetails.put(LOCATION, evidence.getLocation());
        evidenceDetails.put(TIMES, evidence.getTime());
        evidenceDetails.put(ENTERED_EVIDENCE, evidence.getEnteredEvidence().getUuid());
        JSONArray comments = new JSONArray();
        for(int j = 0; j < evidence.getComments().size(); j++) {
            JSONObject comment = new JSONObject();
            comment.put(COMMENT, evidence.getComments().get(j));
            comments.add(comment);
        }
        evidenceDetails.put(COMMENTS, comments);
        return evidenceDetails;
    }

    public static JSONObject getPOIJSON(PersonOfInterest poi) {
        JSONObject poiDetails = new JSONObject();
        poiDetails.put(ID, poi.getUuid());
        poiDetails.put(FIRST_NAME, poi.getFirstName());
        poiDetails.put(LAST_NAME, poi.getLastName());
        poiDetails.put(AGE, poi.getAge());
        poiDetails.put(HEIGHT, poi.getHeight());
        poiDetails.put(WEIGHT, poi.getWeight());
        poiDetails.put(SKIN, poi.getSkinColor());
        poiDetails.put(HAIR, poi.getHairColor());
        poiDetails.put(EYE, poi.getEyeColor());
        poiDetails.put(ADDRESS, poi.getAddress());
        poiDetails.put(PHONE_NUMBER, poi.getPhoneNumber());
        poiDetails.put(EMAIL, poi.getEmail());
        poiDetails.put(SUSPECT_ASSOCIATED_TO, poi.getSuspectAssociatedTo().getUuid());
        poiDetails.put(ASSOCIATION_TO_SUSPECT, poi.getAssociationToSuspect());
        JSONArray stories = new JSONArray();
        for(int j = 0; j < poi.getStory().size(); j++) {
            JSONObject story = new JSONObject();
            story.put(STORY, poi.getStory().get(j));
            stories.add(story);
        }
        poiDetails.put(STORIES, stories);
        return poiDetails;
    }

    public static JSONObject getSuspectJSON(Suspect suspect) {
        JSONObject suspectDetails = new JSONObject();
        suspectDetails.put(ID, suspect.getUuid());
        suspectDetails.put(FIRST_NAME, suspect.getFirstName());
        suspectDetails.put(LAST_NAME, suspect.getLastName());
        suspectDetails.put(AGE, suspect.getAge());
        suspectDetails.put(HEIGHT, suspect.getHeight());
        suspectDetails.put(WEIGHT, suspect.getWeight());
        suspectDetails.put(SKIN, suspect.getSkinColor());
        suspectDetails.put(HAIR, suspect.getHairColor());
        suspectDetails.put(EYE, suspect.getEyeColor());
        suspectDetails.put(ADDRESS, suspect.getAddress());
        suspectDetails.put(HAS_TATTOOS, suspect.getHasTattoos());
        suspectDetails.put(TATTOOS, suspect.getTattoo());
        suspectDetails.put(ALIASES, suspect.getAlias());
        suspectDetails.put(ALIBI, suspect.getAlibi());
        return suspectDetails;
    }

    public static JSONObject getVictimJSON(Victim victim) {
        JSONObject victimDetails = new JSONObject();
        victimDetails.put(ID, victim.getUuid());
        victimDetails.put(FIRST_NAME, victim.getFirstName());
        victimDetails.put(LAST_NAME, victim.getLastName());
        victimDetails.put(AGE, victim.getAge());
        victimDetails.put(HEIGHT, victim.getHeight());
        victimDetails.put(WEIGHT, victim.getWeight());
        victimDetails.put(SKIN, victim.getSkinColor());
        victimDetails.put(HAIR, victim.getHairColor());
        victimDetails.put(EYE, victim.getEyeColor());
        victimDetails.put(ADDRESS, victim.getAddress());
        victimDetails.put(PHONE_NUMBER, victim.getPhoneNumber());
        victimDetails.put(HOSPITALIZED, victim.getHospitalized());
        victimDetails.put(ALIVE, victim.getAlive());
        victimDetails.put(EMAIL, victim.getEmail());
        victimDetails.put(ASSOCIATION_TO_SUSPECT, victim.getAssociationToSuspect());
        victimDetails.put(STORIES, victim.getLastStory());
        return victimDetails;
    }

    public static JSONObject getWitnessJSON(Witness witness) {
        JSONObject witnessDetails = new JSONObject();
        witnessDetails.put(ID, witness.getUuid());
        witnessDetails.put(FIRST_NAME, witness.getFirstName());
        witnessDetails.put(LAST_NAME, witness.getLastName());
        witnessDetails.put(AGE, witness.getAge());
        witnessDetails.put(HEIGHT, witness.getHeight());
        witnessDetails.put(WEIGHT, witness.getWeight());
        witnessDetails.put(SKIN, witness.getSkinColor());
        witnessDetails.put(HAIR, witness.getHairColor());
        witnessDetails.put(EYE, witness.getEyeColor());
        witnessDetails.put(ADDRESS, witness.getAddress());
        witnessDetails.put(PHONE_NUMBER, witness.getPhoneNumber());
        witnessDetails.put(STORIES, witness.getLastStory());
        return witnessDetails;
    }

    public static void main(String[] args) {
        CriminalApplication.getInstance().loadCriminals();
        saveCriminals();
    }

}
