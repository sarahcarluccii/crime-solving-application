import java.util.ArrayList;

public class Criminal extends Person {
    private boolean hasTattoos;
    private ArrayList<String> tattoos;
    private ArrayList<String> aliases;
    private ArrayList<Person> associates;
    private ArrayList<Crime> pastCrimes;
    private boolean jail;
    private boolean alive;
    private boolean chargesDropped;
    private int severity;
    private User enteredCriminal;
    private ArrayList<User> addedInfo;
    private String birthDate;

    public Criminal(int id, String firstName, String lastName, int age, int height, int weight, String skinColor,
            String hairColor, String eyeColor, String address, User enteredCriminal) {
        super(id, firstName, lastName, age, height, weight, skinColor, hairColor, eyeColor, address);
        this.enteredCriminal = enteredCriminal;
        tattoos = new ArrayList<String>();
        aliases = new ArrayList<String>();
        associates = new ArrayList<Person>();
        pastCrimes = new ArrayList<Crime>();
        addedInfo = new ArrayList<User>();
    }

    /**
     * Empty Criminal Constructor
     */
    public Criminal() {

    }

    public User getEnteredCriminal() {
        return enteredCriminal;
    }

    public void addTattoo(String tattoo) {
        tattoos.add(tattoo);
    }

    public String getTattoo() {
        if(tattoos.size() == 0) {
            return "";
        }
        return tattoos.get(tattoos.size() - 1);
    }

    public boolean getHasTattoos() {
        if(tattoos.size() > 0) {
            hasTattoos = true;
        }
        return hasTattoos;
    }

    public void addAlias(String alias) {
        aliases.add(alias);
    }

    public String getAlias() {
        return aliases.get(aliases.size() - 1);
    }

    public void addAssociate(Person person) {
        associates.add(person);
    }

    public void addCrime(Crime crime) {
        pastCrimes.add(crime);
    }

    public void removeCrime(Crime crime){
        pastCrimes.remove(crime);
    }

    public boolean getJail() {
        return this.jail;
    }

    public ArrayList<Crime> getPastCrimes() {
        return pastCrimes;
    }

    public void loadPastCrimes() {
        if(pastCrimes.size() == 0) {            
            for(Crime crimes: CriminalApplication.getInstance().getCrimes()){
                for(Criminal criminals: crimes.getCriminals()) {
                    if(criminals.getUuid() == id) {
                        pastCrimes.add(crimes);
                    }
                }
            }
        }
    }

    public void setJail(boolean jailed) {
        jail = jailed;
    }

    public void changeJail() {
        jail = !jail;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void setAlive(boolean living) {
        alive = living;
    }

    public void changeAlive() {
        alive = !alive;
    }

    public void setChargesDropped(boolean dropped) {
        chargesDropped = dropped;
        if(pastCrimes.size() > 0) {
            pastCrimes.remove(pastCrimes.size() - 1);
        }
    }

    public boolean getChargesDropped() {
        return this.chargesDropped;
    }

    public int getSeverity() {
        return this.severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    // public void addingInfo(String info, User user) {
    //     addedInfo.add(info);
    //     addedInfo.add(user);
    // } Do we even need this method. It doesn't seem to make a lot of sense

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Suspect convertToSuspect() {
        return new Suspect(this.getUuid(), this.getFirstName(), this.getLastName(), 
        this.getAge(), this.getHeight(), this.getWeight(), this.getSkinColor(), 
        this.getHairColor(), this.getEyeColor(), this.getAddress(), "no alibi");
    }

    /**
     * Returns a string of the variables
     * @return The string of variables
     */
    public String toString() {
        loadPastCrimes();
        String str = "ID: " + id + "\nName: " + firstName + " " + lastName + "\nAge: " + age + "\nHeight: " + height + " inches\nWeight: " + weight + " lbs.\nSkin Color: " + skinColor
        + "\nHair Color: " + hairColor + "\nEye Color: " + eyeColor + "\nAddress: " + address + "\nUser Entered: " + enteredCriminal.getFirstName()+ " " + enteredCriminal.getLastName();
        String tatt = "";
        String ali = "";
        String assoc = "";
        String crimes = "";
        for(String t: tattoos) {
            if(t.equals(tattoos.get(tattoos.size()-1))) {
                tatt = t + tatt;
            }
            else {
                tatt = t + ", " + tatt;
            }
        }
        for(String a: aliases) {
            if(a.equals(aliases.get(aliases.size()-1))) {
                ali = a + ali;
            }
            else {
                ali = a + ", " + ali;
            }
        }
        for(Person p: associates) {
            if(p.equals(associates.get(associates.size()-1))) {
                assoc = assoc + p.getFirstName() + " " + p.getLastName();
            }
            else {
                assoc = assoc + p.getFirstName() + " " + p.getLastName() + ", ";
            }
        }
        for(Crime c: pastCrimes) {
            if(c.equals(pastCrimes.get(pastCrimes.size()-1))) {
                crimes = crimes + c.getCrimeType();
            }
            else {
                crimes = crimes + c.getCrimeType() + ", ";
            }

        }
        if(!assoc.equals("")) {
            str = str + "\nAssociates: " + assoc;
        }
        if(!ali.equals("")) {
            str = str + "\nAliases: " + ali;
        }
        if(!tatt.equals("")) {
            str = str + "\nTattoos: " + tatt;
        }
        str = str + "\nCrimes Committed: " + crimes;
        if(jail) {
            str = str + "\nIn Jail";
        }
        if(!alive) {
            str = str + "\nDead";
        }
        if(chargesDropped) {
            str = str + "\nCharges Dropped";
        }
        str = str + "\nSeverity Ranking: " + severity;
        return str + "\n";
    }
}
