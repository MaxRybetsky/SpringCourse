package com.max.dao.category;

import com.max.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getAllCategories(Session session) {
        Query<Category> categoryQuery = session.createQuery("from Category",
                Category.class);
        return categoryQuery.getResultList();
    }
}
