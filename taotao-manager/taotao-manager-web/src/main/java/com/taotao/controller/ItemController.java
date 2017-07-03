package com.taotao.controller;

import com.taotao.TaotaoResult;
import com.taotao.common.EasyUIDataType;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by syi on 2017-06-26.
 */
@Controller
public class ItemController {
    @Autowired
    private TbItemService tbItemService;

    /**
     * 测试框架搭建
     * @param itemID
     * @return
     */
    @RequestMapping("/item/{itemID}")
    @ResponseBody
    public TbItem getItem(@PathVariable Long itemID){
        TbItem item = tbItemService.getItemById(itemID);
        return item;
    }
    /*
        显示首页
     */
    @RequestMapping("/")
    public String showPage(){
        return "index";
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataType getItemList(int page,int rows){
        EasyUIDataType easyUIDataType = tbItemService.getItemList(page, rows);
        return easyUIDataType;
    }

    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult save(TbItem tbItem,String desc,String itemParams ){
        TaotaoResult result = tbItemService.createItem(tbItem,desc,itemParams);
        return result;
    }

}
