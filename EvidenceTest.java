/**
 * @author Sarah Carlucci 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvidenceTest {
    
    @Test
    public void paramConstructorTest() {
        int id = 0;
        String evidenceType = "0", location = "0", time = "0";
        User enteredEvidence = new User();
        ArrayList<String> comments = new ArrayList<String>();
        Evidence e = new Evidence(id, evidenceType, location, time, enteredEvidence, comments);
        
        assertEquals(id, e.getUuid());
        assertEquals(evidenceType, e.getEvidenceType());
        assertEquals(location, e.getLocation());
        assertEquals(time, e.getTime());
        assertEquals(enteredEvidence, e.getEnteredEvidence());
        assertEquals(comments, e.getComments());
        assertNotNull(e.getComments());
    }

    @Test
    public void addCommentTest() {
        int id = 0;
        String evidenceType = "0", location = "0", time = "0";
        User enteredEvidence = new User();
        ArrayList<String> comments = new ArrayList<String>();
        Evidence e = new Evidence(id, evidenceType, location, time, enteredEvidence, comments);

        String comment = "test";
        comments.add(comment);
        e.addComment(comment);
        assertEquals(comments, e.getComments());
    }

    @Test 
    public void toStringTest() {
        int id = 0;
        String evidenceType = "0", location = "0", time = "0";
        User enteredEvidence = new User();
        ArrayList<String> comments = new ArrayList<String>();
        Evidence e = new Evidence(id, evidenceType, location, time, enteredEvidence, comments);

        assertEquals(id + "\n" + evidenceType  + "\n" + location + "\n" + time + "\n" +
        enteredEvidence + "\n" + comments + "\n", e.toString());
    }
}

