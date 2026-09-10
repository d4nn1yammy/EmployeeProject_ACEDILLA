package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0,"N/A");
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this(empID, empName, 0, 0);
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece){
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary(){
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusPay = 0;
        double Salary = 0;

        while (totalPiecesFinished >= 100){
            totalPiecesFinished = totalPiecesFinished - 100;
            bonusPay = bonusPay + (10 * ratePerPiece);
        }

        if (totalPiecesFinished < 100){
            Salary = basePay + bonusPay;
        }

        return Salary;
    }

    public void displayHourlyEmployee(){
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Employee Name: " + this.empName);
        System.out.println("Total Pieces Finished " + this.totalPiecesFinished);
        System.out.println("Rate Per Piece: " + this.ratePerPiece);
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalPiecesFinished=" + totalPiecesFinished +
                ", ratePerPiece=" + ratePerPiece +
                "Salary = " + computeSalary() +
                '}';
    }
}
