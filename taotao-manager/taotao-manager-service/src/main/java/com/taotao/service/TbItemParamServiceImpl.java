package com.taotao.service;

import com.taotao.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by syi on 2017-07-03.
 */
@Service
public class TbItemParamServiceImpl implements TbItemParamService {
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public TaotaoResult findItemParam(Long cid) {
        TbItemParamExample example=new TbItemParamExample();
        example.createCriteria().andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParamList = itemParamMapper.selectByExampleWithBLOBs(example);
        if(tbItemParamList!=null && tbItemParamList.size()>0){
          return  TaotaoResult.ok(tbItemParamList.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult saveItemParam(String groupData, long cid) {
        TbItemParam itemParam=new TbItemParam();
        itemParam.setParamData(groupData);
        itemParam.setItemCatId(cid);
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }


}
