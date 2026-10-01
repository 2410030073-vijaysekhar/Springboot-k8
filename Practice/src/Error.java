public class Error {
    public static void main(String[] args) {
        int a = 10, b = 5, c = 5;

        try {
            int x = a / (b + c);
            System.out.println("x= " + x);

            int y = a / (b - c);   
            System.out.println("y= " + y);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
