import java.util.Scanner;
public class Employeedetails {
	public static class Student{
		String name;
		int id;
		//float marks;
		double salary;
		public void display(){
			System.out.println("The name of Employee is: "+name);
			System.out.println("The id of the Employee is: "+id);
			//System.out.println("The marks of the Employee: "+marks);
			System.out.println("The salary of the employee is: "+salary);
		}
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student();
		System.out.println("Enter the name of the employee: ");
		s1.name=sc.nextLine();
		System.out.println("Enter the id of the employee: ");
		s1.id=sc.nextInt();
		//s1.marks=sc.nextFloat();
		System.out.println("Enter the salary of the employee: ");
		s1.salary=sc.nextDouble();
		s1.display();
		sc.close();
	}
	
}
