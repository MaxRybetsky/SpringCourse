package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();

//            Section section1 = new Section("Football");
//            Child child1 = new Child("Max", 6);
//            Child child2 = new Child("Ivan", 4);
//            Child child3 = new Child("Masha", 7);
//            section1.addChild(child1);
//            section1.addChild(child2);
//            section1.addChild(child3);
//            session.persist(section1);

//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Olga", 6);
//            child1.addSection(section1);
//            child1.addSection(section2);
//            child1.addSection(section3);
//            session.save(child1);

//            Section section = session.get(Section.class, 1);
//            Child child = session.get(Child.class, 4);
//            section.addChild(child);

//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());

//            Child child = session.get(Child.class, 4);
//            System.out.println(child);
//            System.out.println(child.getSectionList());

            Section section = session.get(Section.class, 7);
            session.delete(section);

            session.getTransaction().commit();
        }
    }
}
