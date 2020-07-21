package com.itheima.controller;

import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description: No Description
 * User: Eric
 * RequestMapping: 路径映射，url请求将来找哪个controller中的哪个方法
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Items> all = itemsService.findAll();
        // 塞给页面
        model.addAttribute("items",all);
        return "items";
    }


    @RequestMapping(value = "/save")
    public String save(Items items){
        itemsService.save(items);
        //集合列表页跳转
        return "redirect:/items/list";
    }
}
