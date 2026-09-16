import version2.*;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("--- Name & Date Output Verification ---");
        System.out.println("========================================\n");

        // Test Name class
        Name name1 = new Name("Alice", "M", "Smith", "Jr.");
        Name name2 = new Name("Bob", "Charlie", "Jones");
        Name name3 = new Name("Diana", "Prince");

        System.out.println("Name 1: " + name1);
        System.out.println("Name 2: " + name2);
        System.out.println("Name 3: " + name3);
        System.out.println();

        // Test MyDate class
        MyDate date1 = new MyDate(18, 9, 2000); // Sept 18, 2000
        MyDate date2 = new MyDate(15, 3, 2001); // March 15, 2001
        MyDate hireDate = new MyDate(1, 6, 2022); // June 1, 2022

        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);
        System.out.println("Hire Date: " + hireDate);
        System.out.println();

        System.out.println("========================================");
        System.out.println("--- Hourly Employee Payroll Test ---");
        System.out.println("========================================\n");

        // HourlyEmployee - 45 hours, rate ₱200/hr, DOB September 18
        HourlyEmployee he1 = new HourlyEmployee(101, name1, date1, hireDate, 45, 200);

        System.out.println("[Display Format]");
        he1.displayHourlyEmployee();
        System.out.println();

        System.out.println("[toString Format]");
        System.out.println(he1);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Oct) Salary: ₱%.2f%n", he1.computeSalary(10));
        System.out.printf("Birth Month (Sep) Salary (+₱5,000.00): ₱%.2f%n", he1.computeSalary(9));
        System.out.println();

        System.out.println("========================================");
        System.out.println("--- Commission Employee Payroll Test ---");
        System.out.println("========================================\n");

        // CommissionEmployee - Sales ₱75,000 (10% bracket), DOB March 15
        CommissionEmployee ce1 = new CommissionEmployee(102, name2, date2, hireDate, 75000);

        System.out.println("[Display Format]");
        ce1.displayCommissionEmployee();
        System.out.println();

        System.out.println("[toString Format]");
        System.out.println(ce1);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Jan) Salary: ₱%.2f%n", ce1.computeSalary(1));
        System.out.printf("Birth Month (Mar) Salary (+₱5,000.00): ₱%.2f%n", ce1.computeSalary(3));
        System.out.println();

        System.out.println("========================================");
        System.out.println("--- PieceWorker Employee Payroll Test ---");
        System.out.println("========================================\n");

        // PieceWorkerEmployee - 250 pieces, rate ₱50/piece, DOB June 10
        MyDate date3 = new MyDate(10, 6, 1998); // June 10, 1998
        Name name4 = new Name("Eve", "Garcia");
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(103, name4, date3, hireDate, 250, 50);

        System.out.println("[Display Format]");
        pwe1.displayPieceWorkerEmployee();
        System.out.println();

        System.out.println("[toString Format]");
        System.out.println(pwe1);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Feb) Salary: ₱%.2f%n", pwe1.computeSalary(2));
        System.out.printf("Birth Month (Jun) Salary (+₱5,000.00): ₱%.2f%n", pwe1.computeSalary(6));
        System.out.println();

        System.out.println("========================================");
        System.out.println("--- BasePlusCommission Employee Test ---");
        System.out.println("========================================\n");

        // BasePlusCommissionEmployee - Sales ₱250,000, Base ₱10,000, DOB December 25
        MyDate date4 = new MyDate(25, 12, 1999); // Dec 25, 1999
        Name name5 = new Name("Frank", "Henry", "Johnson");
        BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee(104, name5, date4, hireDate, 250000, 10000);

        System.out.println("[Display Format]");
        bpce1.displayBasePlusCommissionEmployee();
        System.out.println();

        System.out.println("[toString Format]");
        System.out.println(bpce1);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Nov) Salary: ₱%.2f%n", bpce1.computeSalary(11));
        System.out.printf("Birth Month (Dec) Salary (+₱5,000.00): ₱%.2f%n", bpce1.computeSalary(12));
        System.out.println();

        System.out.println("========================================");
        System.out.println("--- Additional Test Cases ---");
        System.out.println("========================================\n");

        // Test high-salary commission bracket
        CommissionEmployee ce2 = new CommissionEmployee(105, new Name("Grace", "Lee"),
                new MyDate(5, 8, 2000), hireDate, 600000);
        System.out.println("High Sales Commission (₱600k = 20% rate):");
        System.out.printf("Commission: ₱%.2f%n", ce2.computeSalary());
        System.out.println();

        // Test overtime for hourly employee
        HourlyEmployee he2 = new HourlyEmployee(106, new Name("Henry", "Martin"),
                new MyDate(12, 1, 1995), hireDate, 50, 300);
        System.out.println("Overtime Hours (50 hours at ₱300/hr):");
        System.out.printf("Regular: 40 * 300 = ₱12,000%n");
        System.out.printf("Overtime: 10 * 450 = ₱4,500%n");
        System.out.printf("Total: ₱%.2f%n", he2.computeSalary());
        System.out.println();

        // Test multiple 100-piece bonuses
        PieceWorkerEmployee pwe2 = new PieceWorkerEmployee(107, new Name("Iris", "Wong"),
                new MyDate(22, 11, 1997), hireDate, 450, 100);
        System.out.println("Multiple Piece Bonuses (450 pieces at ₱100/piece = 4 bonuses):");
        System.out.printf("Base pay: 450 * 100 = ₱45,000%n");
        System.out.printf("Bonuses: 4 * (10 * 100) = ₱4,000%n");
        System.out.printf("Total: ₱%.2f%n", pwe2.computeSalary());
    }
}