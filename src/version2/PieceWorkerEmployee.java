package version2;

public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this(empID, empName, birthDate, dateHired, 0, 0);
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName == null ? new Name() : empName;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getName() {
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired == null ? new MyDate() : dateHired;
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

    // Compute salary without birthday bonus
    public double computeSalary() {
        return computeSalary(-1); // Pass -1 so it won't match any month
    }

    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusGroups = totalPiecesFinished / 100;
        double salary = basePay + (bonusGroups * 10 * ratePerPiece);

        if (birthDate.isMonth(currentMonth)) {
            salary += 5000;
        }

        return salary;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces: %d | Rate: ₱%.2f/piece%n",
                empID, empName, birthDate, dateHired, totalPiecesFinished, ratePerPiece);
    }
    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                empID, empName, birthDate, dateHired, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
