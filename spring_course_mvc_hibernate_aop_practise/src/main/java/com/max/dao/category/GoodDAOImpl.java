package com.max.dao.category;

import com.max.entity.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodDAOImpl implements GoodDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "delete from Good where id=:id";
        Query<Good> goodQuery = session.createQuery(query);
        goodQuery.setParameter("id", id);
        goodQuery.executeUpdate();
    }

    @Override
    public void save(Good good) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(good);
    }

    @Override
    public Good get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Good.class, id);
    }
}
