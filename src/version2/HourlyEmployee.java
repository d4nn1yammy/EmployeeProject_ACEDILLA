package version2;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this(0,"N/A");
    }

    public HourlyEmployee(int empID, String empName) {
        this(empID, empName, 0, 0);
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.ratePerHour = ratePerHour;
        this.totalHoursWorked = totalHoursWorked;
        this.empName = empName;
        this.empID = empID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public double computeSalary(){
        double Salary;

        if (totalHoursWorked <= 40) {
            Salary = totalHoursWorked * ratePerHour;
        }
        else{
            Salary = (40 * ratePerHour) + ((totalHoursWorked - 40) * (ratePerHour));
        }
        return Salary;
    }

    public void displayHourlyEmployee(){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Hours Worked: " + this.totalHoursWorked);
        System.out.println("Rate Per Hour: " + this.ratePerHour);
    }

    @Override
    public String toString() {
        return "HourlyEmployee:     " +
                "empID = " + empID +
                ", empName = " + empName + '\'' +
                ", totalHoursWorked = " + totalHoursWorked +
                ", ratePerHour = " + ratePerHour +
                "Salary = " + computeSalary() +
                '}';
    }
}