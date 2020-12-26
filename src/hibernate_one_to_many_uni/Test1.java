package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
//            Department dep = new Department("HR", 2000, 300);
//            Employee employee1 = new Employee("Max", "Rybetsky", 700);
//            Employee employee2 = new Employee("Ivan", "Ivanov", 900);
//            dep.addEmployeeToDepartment(employee1);
//            dep.addEmployeeToDepartment(employee2);
//            session.save(dep);

            Department department = session.get(Department.class, 2);
            session.delete(department);

//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);

            session.getTransaction().commit();
        }
    }
}
