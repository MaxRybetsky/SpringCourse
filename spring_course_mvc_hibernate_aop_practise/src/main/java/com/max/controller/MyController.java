package com.max.controller;

import com.max.entity.Category;
import com.max.entity.Good;
import com.max.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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

    @RequestMapping("/addNewGood")
    public String addGood(Model model) {
        Good good = new Good();
        model.addAttribute("good", good);
        addCategoriesToModel(model);
        return "edit-good-info";
    }

    @RequestMapping("/saveGood")
    public String saveGood(@Valid @ModelAttribute("good") Good good,
                           BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            addCategoriesToModel(model);
            return "edit-good-info";
        } else {
            shopService.saveGood(good);
            return "redirect:/";
        }
    }

    @RequestMapping("/deleteGood")
    public String deleteGood(@RequestParam("goodId")int id) {
        shopService.deleteGood(id);
        return "redirect:/";
    }

    @RequestMapping("/updateGoodInfo")
    public String updateGood(@RequestParam("goodId")int id,
                             Model model) {
        Good good = shopService.getGoodById(id);
        model.addAttribute("good", good);
        addCategoriesToModel(model);
        return "edit-good-info";
    }

    private void addCategoriesToModel(Model model) {
        Map<Category, String> categories = shopService.getCategoriesWithNames();
        model.addAttribute("categories", categories);
    }
}
