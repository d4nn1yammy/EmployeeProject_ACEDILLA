package version2;

public class PieceWorkerEmployee {
    private int empID;
    private Name name;
    private MyDate birthDate;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this(0, new Name(), new MyDate(), 0, 0);
    }

    public PieceWorkerEmployee(int empID, Name name, MyDate birthDate) {
        this(empID, name, birthDate, 0, 0);
    }

    public PieceWorkerEmployee(int empID, Name name, MyDate birthDate,
                               int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.name = name == null ? new Name() : name;
        this.birthDate = birthDate == null ? new MyDate() : birthDate;
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

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusGroups = totalPiecesFinished / 100;
        return basePay + (bonusGroups * 10 * ratePerPiece);
    }

    public void displayPieceWorkerEmployee() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{\n" +
                "Employee ID: " + empID +
                ", \nEmployee Name: " + name +
                ", \nBirth Date: " + birthDate +
                ", \nTotal Pieces Finished: " + totalPiecesFinished +
                ", \nRate Per Piece: " + ratePerPiece +
                ", \nSalary: " + computeSalary() +
                "\n}";
    }
}
