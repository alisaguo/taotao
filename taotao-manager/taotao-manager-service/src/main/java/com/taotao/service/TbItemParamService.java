package com.taotao.service;

import com.taotao.TaotaoResult;

/**
 * Created by syi on 2017-07-03.
 */
public interface TbItemParamService {

    public TaotaoResult findItemParam(Long cid);

    public TaotaoResult saveItemParam(String groupData,long cid);
}
