package version2;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0, 0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName == null ? new Name() : empName;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public MyDate getDateHired() {
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
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
        double commission = computeCommission();
        double salary = baseSalary + commission;

        if (birthDate.isMonth(currentMonth)) {
            salary += 5000;
        }

        return salary;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Sales: ₱%.2f | Base: ₱%.2f%n",
                empID, empName, birthDate, dateHired, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Sales: ₱%.2f, Base: ₱%.2f, Commission: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, birthDate, dateHired, totalSale, baseSalary, computeCommission(), computeSalary());
    }
}