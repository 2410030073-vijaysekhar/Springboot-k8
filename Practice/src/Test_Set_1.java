class Employee {
    int emp_id;
    String emp_name;
    double emp_salary;

    static int total_employees = 0;
    static double total_salary = 0;

    Employee(int emp_id, String emp_name, double emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;

        total_employees++;
        total_salary += emp_salary;
    }

    static double getAverageSalary() {
        if (total_employees == 0) return 0;
        return total_salary / total_employees;
    }

    void display() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary: " + emp_salary);
    }
}

public class Test_Set_1 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Vijay", 50000);
        Employee e2 = new Employee(2, "Sharan", 60000);

        e1.display();
        e2.display();

        System.out.println("Total Employees: " + Employee.total_employees);
        System.out.println("Average Salary: " + Employee.getAverageSalary());
    }
}
