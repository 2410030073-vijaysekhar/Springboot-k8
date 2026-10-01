class Sample {
    int id;

    Sample(int id) {
        this.id = id;
        System.out.println("Object with id " + id);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object with id " + id + " is garbage collected");
    }
}

public class Finalise {
    public static void main(String[] args) {
        new Sample(101);
        new Sample(102);
        System.gc(); // Request JVM to run garbage collector

        System.out.println("End of the main method");
    }
}
