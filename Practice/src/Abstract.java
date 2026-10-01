abstract class vehicle{
	abstract void start();
	void stop() {
		System.out.println("vehicle stooped");
	}
}
class Car extends vehicle{
	void start() {
		System.out.println("car started");
	}
}
class Bus{
	void start() {
		System.out.println("Bus started");
	}
}
public class Abstract {
public static void main(String[] args) {
	Car c = new Car();
	Bus b = new Bus();
	c.start();
	c.stop();
	b.start();
}
}
