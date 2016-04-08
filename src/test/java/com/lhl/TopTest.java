package com.lhl;

import net.sf.json.JSONArray;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by lenovo on 2016/4/8.
 * 排行榜测试类
 */
public class TopTest<E> {
    @Test
    public void topTest() {
        List<Expo> list = this.getExpoList();
        List<Expo> listCus = new ArrayList<Expo>();
        long userId = 2;
        for (Expo expo : list) {
            long numView = expo.getNumView();
            long numPraise = expo.getNumPraise();
            long numTop = this.getTop(numView, numPraise);
            expo.setNumTop(numTop);
            listCus.add(expo);
        }
        //排序
        this.sort((List<E>) listCus, "getNumTop", "desc");
        List<Map<String, Object>> listNew = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < listCus.size(); i++) {
            Expo expo = listCus.get(i);
            System.out.println(expo.getUserId() + ":" + expo.getNumTop());
            long expoUserId = expo.getUserId();
            if (expoUserId == userId) {
                long riseTop;
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("top", i + 1);
                if (expo.getTop() == 0) {
                    riseTop = list.size() - i + 1;
                } else {
                    riseTop = expo.getTop() - i + 1;
                }
                map.put("rise", riseTop);
                listNew.add(map);
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(listNew);
        System.out.print(jsonArray.toString());

    }

    /**
     * 组织展览列表.
     *
     * @return 返回展览列表
     */
    private List<Expo> getExpoList() {
        List<Expo> list = new ArrayList<Expo>();
        Expo expo0 = new Expo();
        expo0.setUserId(1l);
        expo0.setNumView(10l);
        expo0.setNumPraise(10l);
        list.add(expo0);
        Expo expo2 = new Expo();
        expo2.setUserId(2l);
        expo2.setNumView(20l);
        expo2.setNumPraise(30l);
        list.add(expo2);
        Expo expo1 = new Expo();
        expo1.setUserId(2l);
        expo1.setNumView(20l);
        expo1.setNumPraise(20l);
        list.add(expo1);

        Expo expo3 = new Expo();
        expo3.setUserId(2l);
       // expo3.setNumView();
        expo3.setNumPraise(20l);
        list.add(expo3);
        return list;
    }

    /**
     * 计算结果.
     *
     * @param numView   浏览量
     * @param numPraise 点赞量
     * @return 返回计算结果
     */
    private long getTop(long numView, long numPraise) {
        return numView / 10 + numPraise;
    }

    private void sort(List<E> list, final String method, final String sort) {
        Collections.sort(list, new Comparator<E>() {
            public int compare(E a, E b) {
                int ret = 0;
                try {
                    // 获取m1的方法名
                    Method m1 = a.getClass().getMethod(method, null);
                    // 获取m2的方法名
                    Method m2 = b.getClass().getMethod(method, null);

                    if (sort != null && "desc".equals(sort)) {
                        //倒序排列
                        ret = m2.invoke(((E) b), null).toString().compareTo(m1.invoke(((E) a), null).toString());
                    } else {
                        // 正序排序
                        ret = m1.invoke(((E) a), null).toString().compareTo(m2.invoke(((E) b), null).toString());
                    }
                } catch (NoSuchMethodException ne) {
                    System.out.println(ne);
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return ret;
            }
        });
    }
}
