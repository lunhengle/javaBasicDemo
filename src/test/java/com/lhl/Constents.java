package com.lhl;

import java.util.Hashtable;

/**
 * Created by lenovo on 2016/3/30.
 */
public class Constents {
    //专家
    public final static int TYPE_NORMAL = 0x0002;//2
    public final static String TYPE_NAME_NORMAL = "艺术爱好者";
    public final static int TYPE_EXPERT = 0x0004;//4
    public final static String TYPE_NAME_EXPERT = "专家";
    public final static int TYPE_STAR = 0x0008;//8
    public final static String TYPE_NAME_STAR = "明星";
    public final static int TYPE_ARTIST = 0x0010;//16
    public final static String TYPE_NAME_ARTIST = "艺术家";
    public final static int TYPE_COMPANY = 0x1000;//4096
    public final static String TYPE_NAME_COMPANY = "机构";
    public final static int TYPE_COLLECTOR = 0x0020;//32
    public final static String TYPE_NAME_COLLECTOR = "收藏家";
    public final static int TYPE_CURATOR = 0x0040;//64
    public final static String TYPE_NAME_CURATOR = "策展人";
    public final static int TYPE_ARTCRITIC = 0x0080;  //128
    public final static String TYPE_NAME_ARTCRITIC = "艺评家";
    public final static int TYPE_BALLPLAYER   = 0x0400;  //1024
    public final static String TYPE_NAME_BALLPLAYER   = "参赛者";
    public final static int TYPE_EXPO_EVENT = 0x0100;//256
    public final static String TYPE_NAME_EXPO_EVENT = "活动赛事用户";
    public static Hashtable<Integer, String> TYPES = new Hashtable<Integer, String>();
    {
        TYPES.put(0, TYPE_NAME_NORMAL);
        TYPES.put(TYPE_EXPERT, TYPE_NAME_EXPERT);
        TYPES.put(TYPE_STAR, TYPE_NAME_STAR);
        TYPES.put(TYPE_ARTIST, TYPE_NAME_ARTIST);
        TYPES.put(TYPE_COMPANY, TYPE_NAME_COMPANY);
        TYPES.put(TYPE_COLLECTOR, TYPE_NAME_COLLECTOR);
        TYPES.put(TYPE_CURATOR, TYPE_NAME_CURATOR);
        TYPES.put(TYPE_EXPO_EVENT, TYPE_NAME_EXPO_EVENT);
        TYPES.put(TYPE_ARTCRITIC, TYPE_NAME_ARTCRITIC);
        TYPES.put(TYPE_EXPO_EVENT, TYPE_NAME_EXPO_EVENT);
        TYPES.put(TYPE_BALLPLAYER, TYPE_NAME_BALLPLAYER);
    }
    public static String getTypeName(int type){
        Constents constents=new Constents();
        if(type<3){
            type=2;
        }
        return TYPES.get(type-2);
    }
}
