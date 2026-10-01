
class Cal {
	int add(int a,int b) {
		return a+b;
		}
	int add(int a,int b,int c) {
		return a+b+c;
		}
}
public class Calculator{
	public static void main(String[] args) {
		Cal c = new Cal();
		System.out.println(c.add(5,6));
		System.out.println(c.add(2,3,4));
	}
}
