public class Armstrong {

    public static boolean isArmstrong(int n) {
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }

        return sum == original;
    }

    public static void displayArmstrong(int n) {
        for (int i = 1; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int limit = 1000;
        System.out.println("Armstrong numbers up to " + limit + ":");
        displayArmstrong(limit);
    }
}
