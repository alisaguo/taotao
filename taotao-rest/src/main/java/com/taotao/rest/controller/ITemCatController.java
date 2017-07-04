package com.taotao.rest.controller;

import com.taotao.JsonUtils;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by syi on 2017-07-04.
 */
@Controller
public class ITemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /*@RequestMapping(value = "/itemCat/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String showNavigator(String callback){
        CatResult itemCatList = itemCatService.getItemCatList();
        String list = JsonUtils.objectToJson(itemCatList);
        String result=callback+"("+list+");";
        return result;
    }*/

    /**
     * spring 4.2提供
     * @param callback
     * @return
     */
    @RequestMapping("/itemCat/list")
    @ResponseBody
    public Object showNavigator(String callback) {
        CatResult itemCatList = itemCatService.getItemCatList();
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(itemCatList);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
