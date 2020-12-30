package com.max.service;

import com.max.dao.category.CategoryDAO;
import com.max.entity.Category;
import com.max.entity.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Map<Category, List<Good>> getAllGoodsWithCategories() {
        Session session = sessionFactory.getCurrentSession();
        Map<Category, List<Good>> goods = new HashMap<>();
        List<Category> categories = categoryDAO.getAllCategories(session);
        for(Category category : categories) {
            goods.put(category, category.getGoods());
        }
        return goods;
    }
}
