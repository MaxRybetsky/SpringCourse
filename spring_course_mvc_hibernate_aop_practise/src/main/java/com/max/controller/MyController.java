package com.max.controller;

import com.max.entity.Category;
import com.max.entity.Good;
import com.max.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    ShopService shopService;

    @RequestMapping("/")
    public String showAllGoods(Model model) {
        Map<Category, List<Good>> goods = shopService.getAllGoodsWithCategories();
        model.addAttribute("allGoods", goods);
        return "all-goods";
    }
}
