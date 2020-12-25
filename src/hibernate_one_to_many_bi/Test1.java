package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
             Session session = factory.getCurrentSession()
        ) {
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Max", "Rybetsky", 800);
//            Employee emp2 = new Employee("Olga", "Moskalik", 1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();
            //session.save(dep);

//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmployees());

            Employee emp = session.get(Employee.class, 1);
            //System.out.println(emp);
            //System.out.println(emp.getDepartment());
            session.delete(emp);
            session.getTransaction().commit();
        }
    }
}
