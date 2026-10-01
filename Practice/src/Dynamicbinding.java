class Animal{
	public void move() {
		System.out.println("Animal can move");
	}
}
class Dog extends Animal{
	public void move() {
		super.move();
		System.out.println("Dogs can run and walk");
	}
}
public class Dynamicbinding {
public static void main(String[] args) {
	Animal a = new Dog();
	a.move();
}
}
