package version2;

public class HourlyEmployee {
    private int empID;
    private Name name;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;
    public MyDate dateHired;

    public HourlyEmployee() {
        this(0, new Name(), new MyDate(), 0, 0, new MyDate());
    }

    public HourlyEmployee(int empID, Name name, MyDate birthDate, MyDate dateHired) {
        this(empID, name, birthDate, 0, 0, dateHired);
    }

    public HourlyEmployee(int empID, Name name, MyDate birthDate,
                          float totalHoursWorked, double ratePerHour, MyDate dateHired) {
        this.empID = empID;
        this.name = name == null ? new Name() : name;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
        this.dateHired = dateHired;
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

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
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
                ", \nDate Hired: " + dateHired +
                ", \nSalary: " + computeSalary() +
                "\n}";
    }
}
