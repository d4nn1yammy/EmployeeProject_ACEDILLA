package version2;

public class CommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0);
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0);
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        this.empID = empID;
        this.empName = empName == null ? new Name() : empName;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
        this.totalSale = totalSale;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName == null ? new Name() : empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
    }

    public MyDate getDateHiredDate() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
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

    public double computeSalary() {
        return computeSalary(-1);
    }

    public double computeSalary(int currentMonth) {
        double salary = computeCommission();

        // Add birthday bonus if month matches
        if (birthDate.isMonth(currentMonth)) {
            salary += 5000;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%.2f%n",
                empID, empName, birthDate, dateHired, totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Sales: ₱%.2f, Commission: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, birthDate, dateHired, totalSale, computeCommission(), computeSalary());
    }
}
