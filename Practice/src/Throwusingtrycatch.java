
public class Throwusingtrycatch {
	static void checkage(int age) {
		if(age<18) {
			throw new ArithmeticException("Access denied");
		} else {
			System.out.println("Accesss granted====");
		}
	}
	public static void main(String[] args) {
		try {
		checkage(15);
		} catch(ArithmeticException e){
			System.out.println("Exception Caught: "+e.getMessage());
		}
	}
}
