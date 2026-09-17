import version3.*;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("PAYROLL SYSTEM - VERSION 3: INHERITANCE & POLYMORPHISM");
        System.out.println("=".repeat(70));

        System.out.println("\n[TEST 1] POLYMORPHIC PAYROLL REPORT (Target Month: 9 - September)\n");

        HourlyEmployee emp1 = new HourlyEmployee(
                101,
                new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45,
                250.0
        );

        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(
                201,
                new Name("Bob", "C", "Jones", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                450,
                10.0
        );

        CommissionEmployee emp3 = new CommissionEmployee(
                301,
                new Name("Carol", "E", "Brown"),
                new MyDate(22, 9, 1995),
                new MyDate(10, 3, 2021),
                120000.0
        );

        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(
                401,
                new Name("David", "R", "Davis"),
                new MyDate(14, 12, 1992),
                new MyDate(20, 5, 2020),
                250000.0,
                30000.0
        );


        Employee[] employees = {emp1, emp2, emp3, emp4};
        int targetMonth = 9;


        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%d. %s%n", i + 1, employees[i]);
            double basePay = computeBasePay(employees[i]);
            double birthdayBonus = isBirthdayMonth(employees[i], targetMonth) ? 5000.0 : 0.0;
            double totalSalary = employees[i].computeSalary(targetMonth);

            System.out.printf("   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f %s%n",
                    basePay, birthdayBonus,
                    birthdayBonus > 0 ? "(Eligible)" : "(Ineligible)");
            System.out.printf("   Total Payout: ₱%.2f%n%n", totalSalary);
        }

        System.out.println("=".repeat(70));
        System.out.println("[TEST 2] DEEP CLONE VERIFICATION\n");

        try {
            HourlyEmployee empOriginal = emp1;
            HourlyEmployee empClone = (HourlyEmployee) emp1.clone();

            System.out.println("ORIGINAL EMPLOYEE:");
            System.out.printf("  Name: %s | DOB: %s%n", empOriginal.getEmpName(), empOriginal.getBirthDate());

            System.out.println("\nCLONE EMPLOYEE (before modification):");
            System.out.printf("  Name: %s | DOB: %s%n", empClone.getEmpName(), empClone.getBirthDate());

            Name cloneName = empClone.getEmpName();
            cloneName.setLastName("Taylor");
            cloneName.setFirstName("Alicia");

            MyDate cloneBirthDate = empClone.getBirthDate();
            cloneBirthDate.setMonth(5);

            System.out.println("\nCLONE EMPLOYEE (after modification):");
            System.out.printf("  Name: %s | DOB: %s%n", empClone.getEmpName(), empClone.getBirthDate());

            System.out.println("\nORIGINAL EMPLOYEE (after clone modification):");
            System.out.printf("  Name: %s | DOB: %s%n", empOriginal.getEmpName(), empOriginal.getBirthDate());

            if (empOriginal.getEmpName().getLastName().equals("Smith") &&
                    empOriginal.getBirthDate().getMonth() == 9) {
                System.out.println("\n✓ DEEP CLONE SUCCESSFUL! Original remained unaffected.");
            } else {
                System.out.println("\n✗ SHALLOW CLONE DETECTED! Original was modified.");
            }

        } catch (CloneNotSupportedException e) {
            System.out.println("Error during cloning: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("[TEST 3] OBJECT CONTRACT TESTS (equals & hashCode)\n");

        HourlyEmployee emp1Identical = new HourlyEmployee(
                101,
                new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45,
                250.0
        );

        HourlyEmployee emp2Different = new HourlyEmployee(
                102,
                new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45,
                250.0
        );

        System.out.println("Testing equals():");
        System.out.printf("emp1.equals(emp1): %s%n", emp1.equals(emp1));
        System.out.printf("emp1.equals(emp1Identical): %s%n", emp1.equals(emp1Identical));
        System.out.printf("emp1.equals(emp2Different): %s%n%n", emp1.equals(emp2Different));

        System.out.println("Testing hashCode():");
        int hash1 = emp1.hashCode();
        int hash1Identical = emp1Identical.hashCode();
        int hash2Different = emp2Different.hashCode();

        System.out.printf("emp1 hashCode: %d%n", hash1);
        System.out.printf("emp1Identical hashCode: %d%n", hash1Identical);
        System.out.printf("Hashes match: %s%n%n", hash1 == hash1Identical);

        System.out.printf("emp2Different hashCode: %d%n", hash2Different);
        System.out.printf("emp1 hashCode == emp2Different hashCode: %s%n", hash1 == hash2Different);


        System.out.println("\n" + "=".repeat(70));
        System.out.println("[TEST 4] ALL EMPLOYEE TYPES IN SINGLE POLYMORPHIC COLLECTION\n");

        Employee[] allTypes = {emp1, emp2, emp3, emp4};

        System.out.println("Employee Count by Type:");
        int hourly = 0, piece = 0, commission = 0, basePlus = 0;

        for (Employee emp : allTypes) {
            if (emp instanceof BasePlusCommissionEmployee) basePlus++;
            else if (emp instanceof CommissionEmployee) commission++;
            else if (emp instanceof PieceWorkerEmployee) piece++;
            else if (emp instanceof HourlyEmployee) hourly++;
        }

        System.out.printf("  HourlyEmployee: %d%n", hourly);
        System.out.printf("  PieceWorkerEmployee: %d%n", piece);
        System.out.printf("  CommissionEmployee: %d%n", commission);
        System.out.printf("  BasePlusCommissionEmployee: %d%n%n", basePlus);

        double totalPayroll = 0;
        System.out.println("Payroll Summary (without birthday bonus):");
        for (int i = 0; i < allTypes.length; i++) {
            double salary = allTypes[i].computeSalary();
            totalPayroll += salary;
            System.out.printf("  %d. %s - ₱%.2f%n", i + 1,
                    allTypes[i].getClass().getSimpleName(), salary);
        }
        System.out.printf("%nTotal Payroll: ₱%.2f%n", totalPayroll);

        System.out.println("\n" + "=".repeat(70));
        System.out.println("END OF TESTS");
        System.out.println("=".repeat(70));
    }

    private static double computeBasePay(Employee emp) {
        if (emp instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) emp;
            float hours = he.getTotalHoursWorked();
            double rate = he.getRatePerHour();
            return hours <= 40 ? hours * rate : (40 * rate) + ((hours - 40) * rate * 1.5);

        } else if (emp instanceof PieceWorkerEmployee) {
            PieceWorkerEmployee pe = (PieceWorkerEmployee) emp;
            double basePay = pe.getTotalPiecesFinished() * pe.getRatePerPiece();
            int bonusGroups = pe.getTotalPiecesFinished() / 100;
            return basePay + (bonusGroups * 10 * pe.getRatePerPiece());

        } else if (emp instanceof BasePlusCommissionEmployee) {
            BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
            double commission = getCommission(bpce.getTotalSale());
            return bpce.getBaseSalary() + commission;

        } else if (emp instanceof CommissionEmployee) {
            CommissionEmployee ce = (CommissionEmployee) emp;
            return getCommission(ce.getTotalSale());
        }
        return 0;
    }

    private static double getCommission(double totalSale) {
        if (totalSale <= 50000) {
            return totalSale * 0.05;
        } else if (totalSale <= 100000) {
            return totalSale * 0.10;
        } else if (totalSale <= 500000) {
            return totalSale * 0.15;
        } else {
            return totalSale * 0.20;
        }
    }

    private static boolean isBirthdayMonth(Employee emp, int targetMonth) {
        return emp.getBirthDate().isMonth(targetMonth);
    }
}