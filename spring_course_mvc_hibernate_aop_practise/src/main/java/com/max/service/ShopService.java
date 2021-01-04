package com.max.service;

import com.max.entity.Category;
import com.max.entity.Good;

import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<Category, List<Good>> getAllGoodsWithCategories();

    void deleteGood(int id);


    Map<Category, String> getCategoriesWithNames();

    void saveGood(Good good);
}
