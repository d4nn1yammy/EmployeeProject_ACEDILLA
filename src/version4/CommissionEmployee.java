package version4;

import version3.Employee;
import version3.MyDate;
import version3.Name;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale >= 0 ? totalSale : 0;
    }

    public int getEmpID() {
        return super.getEmpID();
    }

    public void setEmpID(int empID) {
        super.setEmpID(empID);
    }

    public Name getEmpName() {
        return super.getEmpName();
    }

    public void setEmpName(Name empName) {
        super.setEmpName(empName);
    }

    public MyDate getBirthDate() {
        return super.getBirthDate();
    }

    public void setBirthDate(MyDate birthDate) {
        super.setBirthDate(birthDate);
    }

    public MyDate getDateHiredDate() {
        return super.getDateHired();
    }

    public void setDateHired(MyDate dateHired) {
        super.setDateHired(dateHired);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale >= 0 ? totalSale : 0;
    }

    private double computeCommission() {
        if (totalSale <= 50000) {
            return totalSale * 0.05;
        } else if (totalSale <= 100000) {
            return totalSale * 0.10;
        } else if (totalSale <= 500000) {
            return totalSale * 0.15;
        } else {
            return totalSale * 0.20;
        }
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = computeCommission();
        salary += super.computeSalary(currentMonth);
        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%.2f%n",
                super.getEmpID(), super.getEmpName(), super.getBirthDate(), super.getDateHired(), totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Sales: ₱%.2f, Commission: ₱%.2f, Total Salary: ₱%.2f]",
                super.getEmpID(), super.getEmpName(), super.getBirthDate(), super.getDateHired(),
                totalSale, computeCommission(), computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;

        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}