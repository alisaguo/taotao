package com.taotao.common;

import java.util.List;

/**
 * Created by syi on 2017-06-27.
 * 根据easyUI 的数据返格式 生成对应json
 */
public class EasyUIDataType {
    public long total;
    public List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
