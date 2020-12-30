package com.max.service;

import com.max.dao.category.CategoryDAO;
import com.max.entity.Category;
import com.max.entity.Good;
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

    @Override
    @Transactional
    public Map<Category, List<Good>> getAllGoodsWithCategories() {
        Map<Category, List<Good>> goods = new HashMap<>();
        List<Category> categories = categoryDAO.findAllWithGoods();
        for(Category category : categories) {
            goods.put(category, category.getGoods());
        }
        return goods;
    }
}
