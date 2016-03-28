package com.lhl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/3/24.
 * 测试list 转换成json 对象
 */
public class TreeTest {
    private List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
    private List<Map<String, Object>> doubleTreeList = new ArrayList<Map<String, Object>>();

    @Before
    public void before() {
        //组装数据
        this.getTreeList();
    }

    /**
     * 测试树.
     */
    @Test
    public void treeTest() {
        TreeNode treeNode = this.treeNode(treeList);
        System.out.println(this.toJsonObject(treeNode));

    }

    /**
     * 测试list树.
     */
    @Test
    public void listTest() {
        List<TreeNode> tree = this.treeList(treeList);
        System.out.println(this.toJsonArray(tree));
    }

    /**
     * 组织两级树.
     */
    @Test
    public void doubleTreeTest() {
        this.getDoubleTreeList();
        List<TreeNode> tree = this.doubleTreeList(this.doubleTreeList);
        System.out.println(this.toJsonArray(tree));
    }


    /**
     * 排序.
     *
     * @param list 数据list
     * @return 返回tree
     */
    private TreeNode treeNode(List<Map<String, Object>> list) {
        TreeNode treeRoot = new TreeNode();
        treeRoot.setId(-1);
        treeRoot.setName("ROOT");
        Map<Long, TreeNode> tempMap = new HashMap<Long, TreeNode>();
        for (Map<String, Object> map : list) {
            //获取父id
            long fid = map.get("fid") == null ? -1 : Long.valueOf(String.valueOf(map.get("fid")));
            //获取id
            long id = Long.valueOf(String.valueOf(map.get("id")));
            //定义树
            TreeNode treeNode = new TreeNode();
            treeNode.setId(id);
            treeNode.setName(String.valueOf(map.get("name")));
            treeNode.setFid(fid);
            //添加根目录
            tempMap.put(id, treeNode);
            if (-1 == fid) {
                treeRoot.addChildList(treeNode);
            } else if (tempMap.containsKey(fid)) {
                TreeNode tempTree = tempMap.get(fid);
                tempTree.addChildList(treeNode);
            }
        }
        return treeRoot;
    }

    /**
     * 得到树形机构.
     *
     * @param list 数据来源
     * @return 返回treeList
     */
    private List<TreeNode> treeList(List<Map<String, Object>> list) {
        List<TreeNode> listTree = new ArrayList<TreeNode>();
        TreeNode treeRoot = null;
        Map<Long, TreeNode> tempMap = new HashMap<Long, TreeNode>();
        for (Map<String, Object> map : list) {
            //获取父id
            long fid = map.get("fid") == null ? -1 : Long.valueOf(String.valueOf(map.get("fid")));
            //获取id
            long id = Long.valueOf(String.valueOf(map.get("id")));
            //定义树
            TreeNode treeNode = new TreeNode();
            treeNode.setId(id);
            treeNode.setName(String.valueOf(map.get("name")));
            treeNode.setFid(fid);
            //添加根目录
            tempMap.put(id, treeNode);
            if (-1 == fid) {
                treeRoot = treeNode;
            } else if (tempMap.containsKey(fid)) {
                TreeNode tempTree = tempMap.get(fid);
                tempTree.addChildList(treeNode);
            }
            if (null != treeRoot && !listTree.contains(treeRoot)) {
                listTree.add(treeRoot);
            }
        }
        return listTree;
    }

    /*public List<TreeNode> doubleTreeList(List<Map<String, Object>> list) {
        List<TreeNode> listTree = new ArrayList<TreeNode>();
        List<Long> listId = new ArrayList<Long>();
        List<Long> listFid = new ArrayList<Long>();
        for (Map<String, Object> map : list) {
            long id = Long.valueOf(String.valueOf(map.get("id") == null ? -1 : map.get("id")));
            long fid = Long.valueOf(String.valueOf(map.get("fid") == null ? -1 : map.get("fid")));
            listId.add(id);
            listFid.add(fid);
        }
        TreeNode treeRoot = null;
        Map<Long, TreeNode> tempMap = new HashMap<Long, TreeNode>();
        for (Map<String, Object> map : list) {
            //封装对象start
            //获取父id
            long fid = map.get("fid") == null ? -1 : Long.valueOf(String.valueOf(map.get("fid")));
            //获取id
            long id = Long.valueOf(String.valueOf(map.get("id")));
            String name = String.valueOf(map.get("name"));
            //定义树
            TreeNode treeNode = new TreeNode();
            treeNode.setId(id);
            treeNode.setName(name);
            treeNode.setFid(fid);
            tempMap.put(id, treeNode);
            //封装对象end
            //有子节点
            //listFid.contains(id);
            //有父节点
            //listId.contains(fid);
            if (!listId.contains(fid) && !listFid.contains(id)) {//没有父节点也没有子节点
                treeRoot = treeNode;
            } else if (!listId.contains(fid) && listFid.contains(id)) {//没有父节点有子节点
                treeRoot = treeNode;
            } else if (listId.contains(fid) && !listFid.contains(id)) {//有父节点没有子节点
                //非空判断 判断父节点是否有值
                if (tempMap.containsKey(fid)) {
                    TreeNode fidNode = tempMap.get(fid);
                    //控制只添加两层
                    if (null == tempMap.get(fidNode.getFid())) {
                            fidNode.addChildList(treeNode);
                    }
                }
            } else if (listId.contains(fid) && listFid.contains(id)) {//有子节点也有父节点
                treeRoot = treeNode;
                //非空判断 判断父节点是否有值
                if (tempMap.containsKey(fid)) {
                    TreeNode fidNode = tempMap.get(fid);
                    //控制只添加两层
                    if (null == tempMap.get(fidNode.getFid())) {
                            fidNode.addChildList(treeNode);
                    }
                }
            }
            //判断去重
            if (null != treeRoot && !listTree.contains(treeRoot)) {
                listTree.add(treeRoot);
            }
        }
        return listTree;
    }*/

    public List<TreeNode> doubleTreeList(List<Map<String, Object>> list) {
        List<TreeNode> listTree = new ArrayList<TreeNode>();
        List<Long> listId = new ArrayList<Long>();
        List<Long> listFid = new ArrayList<Long>();
        for (Map<String, Object> map : list) {
            long id = Long.valueOf(String.valueOf(map.get("id") == null ? -1 : map.get("id")));
            long fid = Long.valueOf(String.valueOf(map.get("fid") == null ? -1 : map.get("fid")));
            listId.add(id);
            listFid.add(fid);
        }
        for (Map<String, Object> map : list) {
            //封装对象start
            //获取父id
            long fid = map.get("fid") == null ? -1 : Long.valueOf(String.valueOf(map.get("fid")));
            //获取id
            long id = Long.valueOf(String.valueOf(map.get("id")));
            String name = String.valueOf(map.get("name"));
            //定义树
            TreeNode treeNode = new TreeNode();
            treeNode.setId(id);
            treeNode.setName(name);
            treeNode.setFid(fid);
            //封装对象end
            //有子节点
            //listFid.contains(id);
            //有父节点
            //listId.contains(fid);
            if (listId.contains(fid) && !listFid.contains(id)) {//有父节点没有子节点

            } else {
                listTree.add(treeNode);
            }


        }
        List<TreeNode> newTreeList = new ArrayList<TreeNode>();
        for (TreeNode node : listTree) {
            for (Map<String, Object> map : list) {
                //封装对象start
                //获取父id
                long fid = map.get("fid") == null ? -1 : Long.valueOf(String.valueOf(map.get("fid")));
                //获取id
                long id = Long.valueOf(String.valueOf(map.get("id")));
                String name = String.valueOf(map.get("name"));
                //定义树
                TreeNode treeNode = new TreeNode();
                treeNode.setId(id);
                treeNode.setName(name);
                treeNode.setFid(fid);
                if (fid == node.getId()) {
                    if (null == node.getChildList()) {
                        node.addChildList(treeNode);
                    }
                }
            }
            if (null != node && !newTreeList.contains(node)) {
                newTreeList.add(node);
            }
        }

        return newTreeList;
    }

    /**
     * 转换成json 对象.
     *
     * @return 对象转换成json字符串
     */
    private String toJsonObject(TreeNode treeNode) {
        JSONObject jsonObject = JSONObject.fromObject(treeNode);
        return jsonObject.toString();
    }

    /**
     * 转换json数组.
     *
     * @param listNode list树对象
     * @return 对象转换成数组字符串
     */
    private String toJsonArray(List<TreeNode> listNode) {
        JSONArray jsonArray = JSONArray.fromObject(listNode);
        return jsonArray.toString();
    }

    /**
     * 组装数据.
     */
    private void getTreeList() {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", 1);
        map1.put("name", "测试1");
        map1.put("fid", -1);
        treeList.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 2);
        map2.put("name", "测试2");
        map2.put("fid", -1);
        treeList.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("id", 3);
        map3.put("name", "测试3");
        map3.put("fid", -1);
        treeList.add(map3);
        Map<String, Object> map11 = new HashMap<String, Object>();
        map11.put("id", 11);
        map11.put("name", "测试11");
        map11.put("fid", 1);
        treeList.add(map11);

        Map<String, Object> map12 = new HashMap<String, Object>();
        map12.put("id", 12);
        map12.put("name", "测试12");
        map12.put("fid", 1);
        treeList.add(map12);
        Map<String, Object> map21 = new HashMap<String, Object>();
        map21.put("id", 21);
        map21.put("name", "测试21");
        map21.put("fid", 2);
        treeList.add(map21);
        Map<String, Object> map111 = new HashMap<String, Object>();
        map111.put("id", 111);
        map111.put("name", "测试111");
        map111.put("fid", 11);
        treeList.add(map111);

        Map<String, Object> map112 = new HashMap<String, Object>();
        map112.put("id", 112);
        map112.put("name", "测试112");
        map112.put("fid", 11);
        treeList.add(map112);

        Map<String, Object> map121 = new HashMap<String, Object>();
        map121.put("id", 121);
        map121.put("name", "测试121");
        map121.put("fid", 12);
        treeList.add(map121);
    }

    /**
     * 组装double 树结构.
     */
    public void getDoubleTreeList() {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", 1);
        map1.put("name", "张三评论");
        map1.put("fid", -1);
        doubleTreeList.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id", 2);
        map2.put("name", "李四评论>>>>张三评论");
        map2.put("fid", 1);
        doubleTreeList.add(map2);
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("id", 3);
        map3.put("name", "王五评论");
        map3.put("fid", -1);
        doubleTreeList.add(map3);
        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("id", 4);
        map4.put("name", "赵六评论>>>>>>李四评论");
        map4.put("fid", 2);
        doubleTreeList.add(map4);
        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("id", 5);
        map5.put("name", "钱七评论>>>>>>>>张三评论");
        map5.put("fid", 1);
        doubleTreeList.add(map5);
        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("id", 6);
        map6.put("name", "钱七评论>>>>>>>>王五评论");
        map6.put("fid", 3);
        doubleTreeList.add(map6);
        Map<String, Object> map7 = new HashMap<String, Object>();
        map7.put("id", 7);
        map7.put("name", "王五评论>>>>>>>>钱七评论");
        map7.put("fid", 6);
        doubleTreeList.add(map7);
    }
}
