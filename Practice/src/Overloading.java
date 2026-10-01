class Printer{
	void print(int number) {
		System.out.println("Integer: "+number);
	}
	void print(String text) {
		System.out.println("String: "+text);
	}
	void print(double value) {
		System.out.println("Double: "+value);
	}
}
public class Overloading {
	public static void main(String[] args) {
		Printer p = new Printer();
		p.print(10);
		p.print("HELLO");
		p.print(3.14);
	}
}
