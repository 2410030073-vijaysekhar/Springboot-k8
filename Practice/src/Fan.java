public class Fan {
    int speed;
    boolean on;
    double radius;

    Fan(int speed, boolean on, double radius) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
    }

    void increaseSpeed() {
        if (on) {
            speed++;
        }
    }

    void display() {
        System.out.println("On: " + on);
        System.out.println("Speed: " + speed);
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Fan myFan = new Fan(2, true, 5.5);
        myFan.display();
        myFan.increaseSpeed();
        myFan.display();
    }
}