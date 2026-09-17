package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        this.totalHoursWorked = totalHoursWorked >= 0 ? totalHoursWorked : 0;
        this.ratePerHour = ratePerHour >= 0 ? ratePerHour : 0;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked >= 0 ? totalHoursWorked : 0;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour >= 0 ? ratePerHour : 0;
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary;
        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            salary = (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
        }
        salary += super.computeSalary(currentMonth);
        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;

        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0 &&
                Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}