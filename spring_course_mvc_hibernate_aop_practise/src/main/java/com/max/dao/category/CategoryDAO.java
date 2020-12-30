package com.max.dao.category;

import com.max.entity.Category;
import org.hibernate.Session;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAllWithGoods();
}
