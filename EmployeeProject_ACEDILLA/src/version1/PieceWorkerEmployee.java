import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.MyDate;
import version2.Name;
import version2.PieceWorkerEmployee;

public class Main2 {

    public static void main(String[] args) {
        int bdayMonth = 3;

        Name n1 = new Name("Diluc", "Ragnvindr");
        MyDate d1 = new MyDate(bdayMonth, 2004, 4, 30);
        HourlyEmployee he1 = new HourlyEmployee(1, n1, d1, 40, 5);

        Name n2 = new Name("Clark", "Dale", "Ablay");
        MyDate d2 = new MyDate(bdayMonth, 2006, 9, 10);
        PieceWorkerEmployee he2 = new PieceWorkerEmployee(2, n2, d2, 45, 5);

        Name n3 = new Name("Junnel", "Paolo", "Aguipo", "Uy");
        MyDate d3 = new MyDate(bdayMonth, 2006, 3, 5);
        CommissionEmployee he3 = new CommissionEmployee(3, n3, d3, 45);

        Name n4 = new Name("Lloyd", "Thomas", "Plaza", "Griffiths");
        MyDate d4 = new MyDate(bdayMonth, 2007, 9, 17);
        BasePlusCommissionEmployee he4 =
                new BasePlusCommissionEmployee(4, n4, d4, 1100, 200);

        System.out.println(he1);
        System.out.println(he2);
        System.out.println(he3);
        System.out.println(he4);
    }
}
