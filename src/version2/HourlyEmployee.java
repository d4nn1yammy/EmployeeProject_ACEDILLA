package version2;

public class HourlyEmployee {
    private int empID;
    private Name name;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this(0, new Name(), new MyDate(), 0, 0);
    }

    public HourlyEmployee(int empID, Name name, MyDate birthDate) {
        this(empID, name, birthDate, 0, 0);
    }

    public HourlyEmployee(int empID, Name name, MyDate birthDate,
                          float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.name = name == null ? new Name() : name;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name == null ? new Name() : name;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }
        return (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
    }

    public void displayHourlyEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "HourlyEmployee{\n" +
                "Employee ID: " + empID +
                ", \nEmployee Name: " + name +
                ", \nBirth Date: " + birthDate +
                ", \nTotal Hours Worked: " + totalHoursWorked +
                ", \nRate Per Hour: " + ratePerHour +
                ", \nSalary: " + computeSalary() +
                "\n}";
    }
}
