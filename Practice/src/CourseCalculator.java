import java.util.Scanner;

class cc {
    int languages;

 
    cc(int languages) {
        this.languages = languages;
    }

    int getTotalCourses() {
        return languages * 2;
    }
}

public class CourseCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of languages: ");
        int n = sc.nextInt();

        cc c = new cc(n);
        int total = c.getTotalCourses();

        System.out.println("Total number of courses: " + total);
        
        sc.close();
    }
}
