package version2;

public class CommissionEmployee {

    private static int bdayMonth = 3;

    private int empID;
    private Name name;
    private MyDate birthDate;
    private double totalSale;
    private MyDate dateHired;

    public CommissionEmployee() {
        this(0, new Name(), new MyDate(), 0, new MyDate());
    }

    public CommissionEmployee(int empID, Name name, MyDate birthDate, MyDate dateHired) {
        this(empID, name, birthDate, 0, dateHired);
    }

    public CommissionEmployee(int empID, Name name, MyDate birthDate, double totalSale, MyDate dateHired) {
        this.empID = empID;
        this.name = name == null ? new Name() : name;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.totalSale = totalSale;
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

    public MyDate getDateHired(){
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
    }

    public double computeSalary() {
        double commission;
        if (totalSale <= 50000) {
            commission = totalSale * 0.05;
        } else if (totalSale <= 100000) {
            commission = totalSale * 0.10;
        } else if (totalSale <= 500000) {
            commission = totalSale * 0.15;
        } else {
            commission = totalSale * 0.20;
        }
        return commission + getBirthMonthBonus();
    }

    private double getBirthMonthBonus() {
        double bdayBonus = 5000;
        return birthDate.isMonth(bdayMonth) ? bdayBonus : 0;
    }

    public void displayCommissionEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CommissionEmployee{\n" +
                "Employee ID: " + empID +
                ", \nEmployee Name: " + name +
                ", \nBirth Date: " + birthDate +
                ", \nTotal Sale: " + totalSale +
                ", \nDate Hired: " + dateHired +
                ", \nSalary: " + computeSalary() +
                "\n}";
    }
}
