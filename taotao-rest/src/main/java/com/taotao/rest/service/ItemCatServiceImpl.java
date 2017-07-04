package com.taotao.rest.service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syi on 2017-07-04.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Override
    public CatResult getItemCatList() {
        CatResult catResult=new CatResult();
        catResult.setData(getItemList(0));
        return catResult;
    }

    private List<?> getItemList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<TbItemCat> itemCatList = itemCatMapper.selectByExample(example);
        List catNodeList=new ArrayList();
        for (TbItemCat itemCat : itemCatList) {
            CatNode catNode = new CatNode();
            if (itemCat.getIsParent()) {
                if (itemCat.getParentId() == 0) {
                    catNode.setName("<a href='/products/" + itemCat.getId() + ".html'>" + itemCat.getName() + "</a>");
                } else {
                    catNode.setName(itemCat.getName());
                }
                catNode.setUrl("/products/" + itemCat.getId() + ".html");
                catNode.setItem(getItemList(itemCat.getId()));
                catNodeList.add(catNode);
            }else{
                catNodeList.add("/products/"+itemCat.getId()+".html|"+itemCat.getName());
            }
        }
        return catNodeList;
    }


}
