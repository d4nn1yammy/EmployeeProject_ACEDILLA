import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.MyDate;
import version2.Name;
import version2.PieceWorkerEmployee;

public class Main2 {

    public static void main(String[] args) {
        int bdayMonth = 3;

        Name n1 = new Name("Quitoras", "Jericho");
        MyDate d1 = new MyDate(bdayMonth, 11, 6, 2005);
        MyDate h1 = new MyDate(2023, 7, 9, 2023);
        HourlyEmployee he1 = new HourlyEmployee(1, n1, d1, 40, 5, h1);

        Name n2 = new Name("Ablay", "Clark Dale");
        MyDate d2 = new MyDate(bdayMonth, 11, 4, 2006);
        MyDate h2 = new MyDate(2024, 2, 12, 2024);
        PieceWorkerEmployee he2 = new PieceWorkerEmployee(2, n2, d2, 45, 5, h2);

        Name n3 = new Name("Arab", "Jamael");
        MyDate d3 = new MyDate(bdayMonth, 17, 9, 2006);
        MyDate h3 = new MyDate(2026, 3, 4, 2026);
        CommissionEmployee he3 = new CommissionEmployee(3, n3, d3, 45, h3);

        Name n4 = new Name("Junnel", "Paulo", "Uy", "Jr.");
        MyDate d4 = new MyDate(bdayMonth, 5, 3, 2007);
        MyDate h4 = new MyDate(6, 7,6, 2025);
        BasePlusCommissionEmployee he4 = new BasePlusCommissionEmployee(4, n4, d4, 1100, 200, h4);

        System.out.println(he1);
        System.out.println(he2);
        System.out.println(he3);
        System.out.println(he4);
    }
}
