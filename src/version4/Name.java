package version4;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String midName;
    private String lastName;
    private String suffix;

    public Name() {
        this("", "", "", "");
    }

    public Name(String firstName, String lastName) {
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
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        if (!firstName.isEmpty()) {
            sb.append(", ").append(firstName);
        }
        if (!midName.isEmpty()) {
            sb.append(" ").append(midName.charAt(0)).append(".");
        }
        if (!suffix.isEmpty()) {
            sb.append(" ").append(suffix);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Name name = (Name) obj;
        return firstName.equalsIgnoreCase(name.firstName) &&
                midName.equalsIgnoreCase(name.midName) &&
                lastName.equalsIgnoreCase(name.lastName) &&
                suffix.equalsIgnoreCase(name.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                firstName.toLowerCase(),
                midName.toLowerCase(),
                lastName.toLowerCase(),
                suffix.toLowerCase()
        );
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}