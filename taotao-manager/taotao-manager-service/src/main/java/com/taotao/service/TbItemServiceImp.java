package com.taotao.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.TaotaoResult;
import com.taotao.common.EasyUIDataType;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by syi on 2017-06-26.
 */
@Service
public class TbItemServiceImp implements TbItemService {
    @Autowired
    TbItemMapper tbItemMapper;

    @Autowired
    TbItemDescMapper tbItemDescMapper;

    @Autowired
    TbItemParamItemMapper itemParamItemMapper;

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

    @Override
    public TaotaoResult createItem(TbItem tbItem, String desc,String paramData) {
        Long uid =IDUtils.genItemId();
        tbItem.setId(uid);
//        设置是否上架  1 上架  2 下架  3 删除
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItemMapper.insert(tbItem);
//    商品描述
        TbItemDesc tbItemDesc =new TbItemDesc();
        tbItemDesc.setItemId(uid);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        tbItemDescMapper.insert(tbItemDesc);
//       规格参数
        TbItemParamItem itemParamItem=new TbItemParamItem();
        itemParamItem.setItemId(uid);
        itemParamItem.setParamData(paramData);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        itemParamItemMapper.insert(itemParamItem);


//        事务交给spring处理 有异常直接报错 spring自动回滚
        return TaotaoResult.ok();
    }
}
