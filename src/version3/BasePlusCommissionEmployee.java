package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        this.baseSalary = baseSalary >= 0 ? baseSalary : 0;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary >= 0 ? baseSalary : 0;
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Sales: ₱%.2f | Base: ₱%.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), getTotalSale(), baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Sales: ₱%.2f, Base: ₱%.2f, Commission: ₱%.2f, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), getTotalSale(), baseSalary,
                computeCommission(), computeSalary());
    }

    private double computeCommission() {
        double totalSale = getTotalSale();
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
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;

        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}