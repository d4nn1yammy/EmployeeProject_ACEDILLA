import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.MyDate;
import version2.Name;
import version2.PieceWorkerEmployee;

public class Main2 {

    public static void main(String[] args) {
        int bdayMonth = 9;

        Name n1 = new Name("Dasmarinas", "Chellsy");
        MyDate d1 = new MyDate(bdayMonth, 2006, 9, 11);
        HourlyEmployee he1 = new HourlyEmployee(1, n1, d1, 40, 5);

        Name n2 = new Name("Ablay", "Clark");
        MyDate d2 = new MyDate(bdayMonth, 2006, 9, 10);
        PieceWorkerEmployee he2 = new PieceWorkerEmployee(2, n2, d2, 45, 5);

        Name n3 = new Name("Griffiths", "Lloyd Thomas");
        MyDate d3 = new MyDate(bdayMonth, 2006, 9, 17);
        CommissionEmployee he3 = new CommissionEmployee(3, n3, d3, 45);

        Name n4 = new Name("Junnel", "Paolo", "Uy", "Jr.");
        MyDate d4 = new MyDate(bdayMonth, 2007, 3, 5);
        BasePlusCommissionEmployee he4 =
                new BasePlusCommissionEmployee(4, n4, d4, 1100, 200);

        System.out.println(he1);
        System.out.println(he2);
        System.out.println(he3);
        System.out.println(he4);
    }
}
