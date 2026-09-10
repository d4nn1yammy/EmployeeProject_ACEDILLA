package version1;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;


    public CommissionEmployee() {
        this(0, "N/A");
    }

    public CommissionEmployee(int empID, String empName) {
        this(empID, empName, 0);
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empName = empName;
        this.empID = empID;
        this.totalSale = totalSale;
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

    public double computeSalary(){
        double Salary;

        if (totalSale < 50000) {
            Salary = 0.05 * totalSale;
        }
        else if (totalSale >= 100000 || totalSale < 500000){
            Salary = 0.15 * totalSale;
        }
        else{
            Salary = 0.20 * totalSale;
        }
        return Salary;
    }

    public void displayHourlyEmployee(){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Sales: " + this.totalSale);
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalSale=" + totalSale +
                "Salary = " + computeSalary() +
                '}';
    }
}

