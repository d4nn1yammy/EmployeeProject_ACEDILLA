package version2;

public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this(0, "N/A");
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this(empID, empName, 0, 0);
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empName = empName;
        this.empID = empID;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double computeSalary(){
        double Commission, Rate;

        if (totalSale < 50000) {
            Rate = 0.05;
        }
        else if (totalSale >= 100000 || totalSale < 500000){
            Rate = 0.15;
        }
        else{
            Rate = 0.20;
        }

        Commission = totalSale * Rate;
        return baseSalary + Commission;
    }

    public void displayHourlyEmployee(){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Sales: " + this.totalSale);
        System.out.println("Base Salary: " + this.baseSalary);
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalSale=" + totalSale +
                ", baseSalary=" + baseSalary +
                "Salary = " + computeSalary() +
                '}';
    }
}
