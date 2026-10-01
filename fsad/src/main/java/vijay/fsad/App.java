 package vijay.fsad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // STEP 3: Insert (only 2 records)

        Sekhar sk1 = new Sekhar();
        sk1.setName("Mobile");
        sk1.setDes("Electronic Product");
        sk1.setPrice(1500);
        sk1.setQuant(20);

        Sekhar sk2 = new Sekhar();
        sk2.setName("Laptop");
        sk2.setDes("Computer Device");
        sk2.setPrice(55000);
        sk2.setQuant(5);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Sekhar.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(sk1);
        session.persist(sk2);

        // STEP 4: Retrieve by ID (simple)

        Sekhar sk = session.get(Sekhar.class, 1);
        System.out.println(sk.getName());

        // STEP 5: Update (simple)

        Sekhar updateProduct = session.get(Sekhar.class, 2);
        updateProduct.setPrice(52000);

        // STEP 6: Delete (simple)

        Sekhar deleteProduct = session.get(Sekhar.class, 1);
        session.delete(deleteProduct);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("CRUD done");
    }
}
