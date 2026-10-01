
public class Capacity {
	    public static void main(String[] args) {
	        StringBuffer sb = new StringBuffer("Hello");

	        System.out.println("Text: " + sb);                // Hello
	        System.out.println("Length: " + sb.length());     // 5
	        System.out.println("Capacity: " + sb.capacity()); // 21 (16 default + 5 for "Hello")

	        sb.append(" Java Programming"); // Adding more characters

	        System.out.println("\nAfter append:");
	        System.out.println("Text: " + sb);
	        System.out.println("Length: " + sb.length());     // New length
	        System.out.println("Capacity: " + sb.capacity()); // May increase if needed
	    }
	}
