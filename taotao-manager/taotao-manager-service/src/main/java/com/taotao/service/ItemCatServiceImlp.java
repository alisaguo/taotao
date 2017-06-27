package com.taotao.service;

import com.taotao.common.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syi on 2017-06-27.
 */
@Service
public class ItemCatServiceImlp implements ItemCatService {
    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(int parentId) {
//        根据parentid获得所有Itemcat 列表
        TbItemCatExample example = new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo((long) parentId);
        List<TbItemCat> tbItemCatsList = itemCatMapper.selectByExample(example);
//        吧列表存到node节点中，返回nodelist
        List<EasyUITreeNode> nodeList = new ArrayList<EasyUITreeNode>();
        for (TbItemCat itemCat : tbItemCatsList) {
            EasyUITreeNode node = new EasyUITreeNode(itemCat.getId(), itemCat.getName(),
                    itemCat.getIsParent() ? "closed" : "open");
            nodeList.add(node);
        }
        return nodeList;
    }
}
