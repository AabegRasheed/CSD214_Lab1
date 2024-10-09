package lab1;

public class Person {

    public enum Gender {
        M, F
    }

    private String firstname;
    private String lastname;
    private Gender gender;
    private int SIN;
    public static int COUNT = 0;

    public Person(String firstname, String lastname, Gender gender, int SIN) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.SIN = SIN;
        COUNT++;
    }

    public Person(String firstname, String lastname) {
        this(firstname, lastname, null, 0);
    }

    public Person(String firstname, String lastname, int SIN) {
        this(firstname, lastname, null, SIN);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getSIN() {
        return SIN;
    }

    public void setSIN(int SIN) {
        this.SIN = SIN;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        return SIN == person.SIN &&
                firstname.equals(person.firstname) &&
                lastname.equals(person.lastname) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + SIN;
        return result;
    }

    @Override
    public String toString() {
        return "{ " + firstname + " " + lastname + ", SIN=" + SIN + ", Gender=" + gender + " }";
    }

    @Override
    protected void finalize() throws Throwable {
        COUNT--;
        super.finalize();
    }
}
