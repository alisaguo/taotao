package com.taotao.service;

import com.taotao.common.EasyUIDataType;
import com.taotao.pojo.TbItem;
import org.springframework.stereotype.Repository;

/**
 * Created by syi on 2017-06-26.
 */
@Repository
public interface TbItemService {
    public TbItem getItemById(Long itemID);

    public EasyUIDataType getItemList(int page ,int rows);
}
