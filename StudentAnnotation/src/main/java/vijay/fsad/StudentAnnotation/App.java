package vijay.fsad.StudentAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.Appconfig;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Appconfig.class);

        Student s = context.getBean(Student.class);
        s.display();
    }
}