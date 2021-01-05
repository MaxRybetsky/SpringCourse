package com.max.converter;

import com.max.dao.category.CategoryDAO;
import com.max.entity.Category;
import com.max.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategoryConverter implements Converter<String, Category>{
    @Autowired
    ShopService shopService;

    @Override
    public Category convert(String s) {
        String[] data = s.split(":");
        int id = Integer.parseInt(data[0]);
        return shopService.getCategoryById(id);
    }
}
