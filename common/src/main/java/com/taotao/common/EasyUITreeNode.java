package com.taotao.common;

/**
 * Created by syi on 2017-06-27.
 * EasyUI 树节点 数据结构
 */
public class EasyUITreeNode {
    public long id ;
    public String text;
    //状态  closed :有自节点 open ：叶子节点
    public String state;

    public EasyUITreeNode(long id,String text,String state){
        this.setId(id);
        this.setText(text);
        this.setState(state);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
