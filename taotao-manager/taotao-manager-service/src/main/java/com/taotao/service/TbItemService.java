package com.taotao.service;

import com.taotao.TaotaoResult;
import com.taotao.common.EasyUIDataType;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import org.springframework.stereotype.Repository;

/**
 * Created by syi on 2017-06-26.
 */
@Repository
public interface TbItemService {
    public TbItem getItemById(Long itemID);

    public EasyUIDataType getItemList(int page ,int rows);

    public TaotaoResult createItem(TbItem tbItem, String desc,String paramData);
}
