public class Throw {
	static void checkage(int age) {
		if(age<18) {
			throw new ArithmeticException("Access denied");
		} else {
			System.out.println("Accesss granted====");
		}
	}
	public static void main(String[] args) {
		checkage(15);
	}
}
