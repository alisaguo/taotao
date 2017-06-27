package com.taotao.service;

import com.taotao.common.EasyUITreeNode;
import com.taotao.pojo.TbItemCat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by syi on 2017-06-27.
 */
@Repository
public interface ItemCatService {

    public List<EasyUITreeNode> getItemCatList(int parentID);
}
