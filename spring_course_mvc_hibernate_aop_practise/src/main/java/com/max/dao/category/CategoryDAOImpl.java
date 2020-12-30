package com.max.dao.category;

import com.max.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<Category> findAllWithGoods() {
        Session session = sessionFactory.getCurrentSession();
        String query = "select c from Category c left join fetch c.goods";
        Query<Category> categoryQuery = session.createQuery(query, Category.class);
        return categoryQuery.getResultList();
    }
}
