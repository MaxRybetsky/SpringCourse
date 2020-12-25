package hibernate_one_to_many_bi.practise;

import hibernate_one_to_many_bi.practise.entity.School;
import hibernate_one_to_many_bi.practise.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Closeable;
import java.io.IOException;

@Component("session")
public class Session implements Closeable {
    @PersistenceContext
    private org.hibernate.Session session;
    @PersistenceContext
    private final SessionFactory factory;

    public Session() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(School.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        session = factory.getCurrentSession();
    }

    public void beginTransaction() {
        if (!session.isOpen()) {
            session = factory.getCurrentSession();
        }
        session.beginTransaction();
    }

    public Transaction getTransaction() {
        return session.getTransaction();
    }

    public void save(Object o) {
        session.save(o);
    }

    public void delete(Object o) {
        session.delete(o);
    }

    @Override
    public void close() {
        session.close();
        factory.close();
    }

    public <T> T get(Class<T> classObj, int id) {
        return session.get(classObj, id);
    }

    public Query createQuery(String query) {
        return session.createQuery(query);
    }
}
