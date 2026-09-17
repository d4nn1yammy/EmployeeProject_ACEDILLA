package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = totalPiecesFinished >= 0 ? totalPiecesFinished : 0;
        this.ratePerPiece = ratePerPiece >= 0 ? ratePerPiece : 0;
    }

    public int getEmpID() {
        return super.getEmpID();
    }

    public void setEmpID(int empID) {
        super.setEmpID(empID);
    }

    public Name getName() {
        return super.getEmpName();
    }

    public void setEmpName(Name empName) {
        super.setEmpName(empName);
    }

    public MyDate getBirthDate() {
        return super.getBirthDate();
    }

    public void setBirthDate(MyDate birthDate) {
        super.setBirthDate(birthDate);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public MyDate getDateHired() {
        return super.getDateHired();
    }

    public void setDateHired(MyDate dateHired) {
        super.setDateHired(dateHired);
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished >= 0 ? totalPiecesFinished : 0;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece >= 0 ? ratePerPiece : 0;
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusGroups = totalPiecesFinished / 100;
        double salary = basePay + (bonusGroups * 10 * ratePerPiece);

        salary += super.computeSalary(currentMonth);
        return salary;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces: %d | Rate: ₱%.2f/piece%n",
                super.getEmpID(), super.getEmpName(), super.getBirthDate(), super.getDateHired(),
                totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, " +
                        "Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                super.getEmpID(), super.getEmpName(), super.getBirthDate(), super.getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;

        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished &&
                Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}