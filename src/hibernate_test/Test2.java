package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Petrov",
                    "Manager", 700);
            session.beginTransaction();
            session.save(employee);
            int id = employee.getId();
            Employee employee1 = session.get(Employee.class, id);
            System.out.println(employee1);
            session.getTransaction().commit();
        }
    }
}
