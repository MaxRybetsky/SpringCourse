package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
//            Employee employee = new Employee("Misha", "Sidorov",
//                    "HR", 400);
//            Detail detail = new Detail("Kolomna", "56789",
//                    "mishaaa@ya.ru");
//            employee.setDetail(detail);
//            detail.setEmployee(employee);
//            session.save(detail);
            Detail d = session.get(Detail.class, 1);
            d.getEmployee().setDetail(null);
            session.delete(d);
            //System.out.println(d.getEmployee());
            session.getTransaction().commit();
        }
    }
}
