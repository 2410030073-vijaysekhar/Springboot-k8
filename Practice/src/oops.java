//all datatypes 
import java.util.Scanner;

public class oops {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter a string: ");
			String str = sc.nextLine();
			System.out.println("You entered: " + str);

			System.out.print("Enter a character: ");
			char ch = sc.next().charAt(0);
			System.out.println("You entered: " + ch);

			System.out.print("Enter the first value: ");
			int a = sc.nextInt();

			System.out.print("Enter the second value: ");
			int b = sc.nextInt();

			System.out.println("The sum of two numbers is: " + (a + b));

			byte bytevalue = 100;
			short shortvalue = 3000;
			int intvalue = 123456;
			long longvalue = 123456789L;

			float f = 3.14f;
			double d = 1234.567;

			boolean bool = true;

			System.out.println("Byte: " + bytevalue);
			System.out.println("Short: " + shortvalue);
			System.out.println("Int: " + intvalue);
			System.out.println("Long: " + longvalue);
			System.out.println("Float: " + f);
			System.out.println("Double: " + d);
			System.out.println("Boolean: " + bool);
			System.out.println("Previously entered char: " + ch);
			System.out.println("Previously entered string: " + str);
		}
    }
}
