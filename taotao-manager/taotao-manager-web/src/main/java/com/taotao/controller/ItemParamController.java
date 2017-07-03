package com.taotao.controller;

import com.taotao.TaotaoResult;
import com.taotao.service.TbItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by syi on 2017-07-03.
 */
@RequestMapping("/item/param")
@Controller
public class ItemParamController {
    @Autowired
    private TbItemParamService itemParamService;

    /**
     * 判断是数据库是否存在类目，在类目选择时
     * @return
     */
    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult isHaveParam(@PathVariable Long itemCatId){
        TaotaoResult result = itemParamService.findItemParam(itemCatId);
        return result;
    }

    /**
     * 提交表单
     * @param paramData
     * @param cid
     * @return
     */
    @RequestMapping("save/{cid}")
    @ResponseBody
    public TaotaoResult saveItemParam(String paramData,@PathVariable Long cid){
        TaotaoResult result = itemParamService.saveItemParam(paramData, cid);
        return result;
    }
}

