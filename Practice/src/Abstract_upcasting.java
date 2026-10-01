abstract class Shape {
    abstract void draw();

    void display() {
        System.out.println("This is a shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("This is drawing");
    }
}

public class Abstract_upcasting {
    public static void main(String[] args) {
        Shape s = new Circle();
        s.draw();
        s.display();
    }
}
