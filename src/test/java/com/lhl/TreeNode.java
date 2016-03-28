package com.lhl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/3/24.
 */
public class TreeNode implements Serializable {
    //id
    private long id;
    //名称
    private String name;
    //父id
    private long fid;
    //父对象
    private TreeNode father;
    //子对象
    private List<TreeNode> childList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public TreeNode getFather() {
        return father;
    }

    public void setFather(TreeNode father) {
        this.father = father;
    }

    public List<TreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }

    /**
     * 添加子节点.
     *
     * @param treeNode 要添加的节点
     */
    public void addChildList(TreeNode treeNode) {
        if (null == childList) {
            childList = new ArrayList<TreeNode>();
        }
        childList.add(treeNode);
    }

    /**
     * 清空节点.
     */
    public void clearChildlist() {
        childList = new ArrayList<TreeNode>();
    }
}
