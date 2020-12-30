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
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAllWithGoods() {
        String query = "select c from Category c left join fetch c.goods";
        return getCategoriesByQuery(query);
    }

    @Override
    public List<Category> findAll() {
        String query = "from Category";
        return getCategoriesByQuery(query);
    }

    private List<Category> getCategoriesByQuery(String query) {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> categoryQuery = session.createQuery(query, Category.class);
        return categoryQuery.getResultList();
    }
}
