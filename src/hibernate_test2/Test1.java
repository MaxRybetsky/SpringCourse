package hibernate_test2;

import hibernate_test2.entity.Detail;
import hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()
        ) {
            session.beginTransaction();
            Employee employee = new Employee("Oleg", "Volkoff",
                    "HR", 700);
            Detail detail = new Detail("Voronezh", "9123456789",
                    "olekh@ya.ru");
            employee.setDetail(detail);
            Employee emp = session.get(Employee.class, 3);
            System.out.println(emp.getDetail());
            session.delete(emp);
            //session.save(employee);
            session.getTransaction().commit();
        }
    }
}
