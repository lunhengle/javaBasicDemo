package com.lhl;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2016/3/22.
 */
public class JsonTest {
    private static String token = "{\"access_token\":\"OezXcEiiBSKSxW0eoylIeJNJ0Ds8uuDQvyAnMMF5y5lYOV3e37dOO3WGQz1Uaoke2ap-wk1YDe7LVcQUjpEBZBWwtLSbcEMn6WZ6L4BuKAUvYIwGjPMI0Q2xRW8NjN3O2vVEOendscfpK_DRtGRn_g\",\"expires_in\":7200,\"refresh_token\":\"OezXcEiiBSKSxW0eoylIeJNJ0Ds8uuDQvyAnMMF5y5lYOV3e37dOO3WGQz1UaokeBTrseVRqOab-kFdfYuMk7sGcee1eP3eXfK6tjWBmLpuMT_Bc2bEM4vAdYUXsgFscSdwrHjt_f-1gVVa6ZcjnBA\",\"openid\":\"on5ExuM9JSWeGXULcBMKBDVzLkYw\",\"scope\":\"snsapi_userinfo\"}";
    private static String code = "{\"openid\":\"ja90dfij9adsf8jasd9fj9adfja\",\"nickname\":\"909-9-iiio\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"北京\",\"province\":\"北京\",\"country\":\"中国\",\"headimgurl\":\"http:www.baidu.com\"}";
    private static String url = "http://192.168.1.192:8080/dev/d/web/testUrl";
    private static String urlContent;

    /**
     * 测试json.
     */
    @Test
    public void testJson() {
        JSONObject jsonObject = JSONObject.fromObject(token);
        System.out.println(jsonObject.get("access_token"));

        JSONObject jsonObject1 = JSONObject.fromObject(code);
        System.out.println(jsonObject1.get("province"));
    }

    /**
     * 测试地址.
     */
    @Test
    public void testUrl() {
        try {
            URL u = new URL(url);
            InputStream in = u.openStream();
            StringBuilder sb = new StringBuilder();
            byte[] buff = new byte[1024];
            int len;
            while ((len = in.read(buff)) != -1) {
                //此处使用UTF-8编码，如果遇到像新浪这样的网站编码不是UTF-8的，就会乱，
                //此处我就不过细处理了
                sb.append(new String(buff, 0, len, "UTF-8"));
            }
            in.close();
            String content=removeHtmlTag(sb.toString());
            System.out.println(content);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String removeHtmlTag(String content){
        Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>");
        Matcher m = p.matcher(content);
        if (m.find()) {
            content = content.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
            content = removeHtmlTag(content);
        }
        return content;
    }
}
