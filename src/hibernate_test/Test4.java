package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee e = session.get(Employee.class, 1);
//            e.setName("Maxim");
            session.createQuery("update Employee set salary=1000" +
                    "where name='Alex'").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
