package klh.edu.Lab3HibernateCRUD;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(new Product(1,"Pen","Stationery",10,50));
        session.persist(new Product(2,"Notebook","Stationery",50,30));
        session.persist(new Product(3,"Mouse","Electronics",500,10));

        tx.commit();
        session.close();

        Session session2 = factory.openSession();

        List<Product> list =
                session2.createQuery("FROM Product ORDER BY price ASC", Product.class).list();

        System.out.println("Sorted Products:");
        for(Product p : list)
            System.out.println(p.getName() + " " + p.getPrice());

        session2.close();
        factory.close();
    }
}
