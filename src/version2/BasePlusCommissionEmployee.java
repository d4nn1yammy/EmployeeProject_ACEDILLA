package version2;

public class BasePlusCommissionEmployee {

    private static int bdayMonth = 3;

    private int empID;
    private Name name;
    private MyDate birthDate;
    private double totalSale;
    private double baseSalary;
    private MyDate dateHired;

    public BasePlusCommissionEmployee() {
        this(0, new Name(), new MyDate(), 0, 0, new MyDate());
    }

    public BasePlusCommissionEmployee(int empID, Name name, MyDate birthDate, MyDate dateHired) {
        this(empID, name, birthDate, 0, 0, dateHired);
    }

    public BasePlusCommissionEmployee(int empID, Name name, MyDate birthDate,
                                      double totalSale, double baseSalary, MyDate dateHired) {
        this.empID = empID;
        this.name = name == null ? new Name() : name;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public MyDate getDateHired(){
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
    }


    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double computeCommission() {
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
        double commission = computeCommission();
        double bdayBonus = 5000;
        double birthMonthBonus = birthDate.isMonth(bdayMonth)
                ? bdayBonus : 0;
        return baseSalary + commission + birthMonthBonus;
    }

    public void displayCommissionEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{\n" +
                "Employee ID: " + empID +
                ", \nEmployee Name: " + name +
                ", \nBirth Date: " + birthDate +
                ", \nTotal Sale: " + totalSale +
                ", \nBase Salary: " + baseSalary +
                ", \nDate Hired: " + dateHired +
                ", \nCommission: " + computeCommission() +
                ", \nSalary: " + computeSalary() +
                "\n}";
    }
}
