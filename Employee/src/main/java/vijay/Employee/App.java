package vijay.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Employee emp1 = new Employee();
        emp1.setName("Mobile");
        emp1.setDes("Electronic Product");
        emp1.setPrice(1500);
        emp1.setQuant(20);

        Employee emp2 = new Employee();
        emp2.setName("Laptop");
        emp2.setDes("Computer Device");
        emp2.setPrice(55000);
        emp2.setQuant(5);

        SessionFactory factory = new Configuration()
        		.configure("vijay/Employee/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(emp1);
        session.persist(emp2);

        Employee e = session.get(Employee.class, 1);
        System.out.println(e.getName());


        Employee update = session.get(Employee.class, 2);
        update.setPrice(52000);

        Employee delete = session.get(Employee.class, 1);
        session.delete(delete);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("CRUD done");
    }
}