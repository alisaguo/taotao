package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by syi on 2017-06-27.
 */

public class TestPageHelp {
    @Test
    public void testPageHelp(){
//        实现容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//        得到sqlMapper的代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
//        分页查询
        PageHelper.startPage(1,10);
        TbItemExample example = new TbItemExample();
        example.createCriteria().andIdEqualTo(536563L);
        List<TbItem> tbItemList = itemMapper.selectByExample(example);
        for (TbItem item:tbItemList){
            System.out.println(item.getTitle());
        }
        PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(tbItemList);
        System.out.println(pageInfo.getTotal());

    }
}
