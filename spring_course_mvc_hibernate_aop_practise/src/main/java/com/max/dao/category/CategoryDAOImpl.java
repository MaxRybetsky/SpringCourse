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

    @Override
    public List<Category> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> categoryQuery = session.createQuery("from Category",
                Category.class);
        List<Category> categories = categoryQuery.getResultList();
//        This is for debugging
//        if(categories.size() != 0) {
//            System.out.println(categories.get(0).getGoods().get(0).getName());
//        }
        return categories;
    }
}
