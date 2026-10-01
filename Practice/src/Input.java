//student details
import java.util.Scanner;
public class Input {
	public static class Student{
		String name;
		int rollno;
		float marks;
		public void display(){
			System.out.println(name);
			System.out.println(rollno);
			System.out.println(marks);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student();
		s1.name="vijay sekhar";
		s1.rollno=73;
		s1.marks=9.4f;
		 s1.display();
		 sc.close();
	}
}
