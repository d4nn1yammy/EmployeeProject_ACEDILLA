package version4;

public class EmployeeRoster {
    private Employee[] empList = new Employee[10];
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.empList = new Employee[max];
        this.count = 0;
    }

    boolean addEmployee(Employee emp) {
        if (count > max || empList == null) {
            return false;
        }
        if (count < max) {
            empList[count] = emp;
            count++;
            return true;
        }
        return false;
    }

    Employee removeEmployee(int empID) {
        int found = 0;
        Employee removeEmployee = null;

        for (int i = 0; i < empList.length; i++) {
            if (empList[i].getEmpID() == empID) {
                removeEmployee = empList[i];
                found = i;
                break;
            }
        }

        if (found != 0) {
            for (int i = 0; i < empList.length - 1; i++) {
                Employee temp = empList[0];
                empList[i] = empList[i + 1];
                empList[max - 1] = temp;
            }

            empList[max - 1] = null;
            count--;
        }

        return removeEmployee;
    }

    Employee searchEmployee(int empID) {
        for (int i = 0; i < empList.length; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

}



