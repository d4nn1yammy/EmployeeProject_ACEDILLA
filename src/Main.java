import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;
import version1.CommissionEmployee;
import version1.BasePlusCommissionEmployee;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Hourly Employee Test ---\n");
        HourlyEmployee h1= new HourlyEmployee(101, "Alice Smith", 45, 200);
        PieceWorkerEmployee h2= new PieceWorkerEmployee(101, "Alice Smith", 30, 500);
        CommissionEmployee h3= new CommissionEmployee(101, "Alice Smith", 500);
        BasePlusCommissionEmployee h4= new BasePlusCommissionEmployee(101, "Alice Smith", 500, 200);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);


    }
}