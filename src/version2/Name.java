package version2;

public class Name {
    private String firstName;
    private String midName;
    private String lastName;
    private String suffix;

    public Name() {
        this("", "", "", "");
    }

    public Name(String lastName, String firstName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String midName, String lastName) {
        this(firstName, midName, lastName, "");
    }

    public Name(String firstName, String midName, String lastName, String suffix) {
        this.firstName = firstName == null ? "" : firstName;
        this.midName = midName == null ? "" : midName;
        this.lastName = lastName == null ? "" : lastName;
        this.suffix = suffix == null ? "" : suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName == null ? "" : midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? "" : suffix;
    }

    public void displayName() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String middle = midName.isEmpty() ? "" : " " + midName;
        String ending = suffix.isEmpty() ? "" : " " + suffix;
        return firstName + middle + (lastName.isEmpty() ? "" : " " + lastName) + ending;
    }
}
