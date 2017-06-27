package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.EasyUIDataType;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by syi on 2017-06-26.
 */
@Service
public class TbItemServiceImp implements TbItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(Long itemID) {
//        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemID);
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemID);
        List<TbItem> tbItemsList = tbItemMapper.selectByExample(example);
        if (tbItemsList != null && tbItemsList.size() > 0) {
            TbItem tbItem = tbItemsList.get(0);
            return tbItem;
        }
        return null;
    }

    @Override
    public EasyUIDataType getItemList(int page, int rows) {
        TbItemExample example=new TbItemExample();
        PageHelper.startPage(page,rows);
        List<TbItem> itemsList = tbItemMapper.selectByExample(example);
        EasyUIDataType easyUIDataType=new EasyUIDataType();
        easyUIDataType.setRows(itemsList);
        PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(itemsList);
        easyUIDataType.setTotal(pageInfo.getTotal());
        return easyUIDataType;
    }
}
