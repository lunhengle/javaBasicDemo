package com.lhl;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2016/4/5.
 * 正则表达式测试
 */
public class RegexTest {

    @Test
    public void regexTest() {
        String template = this.getTemplate();
        System.out.println("匹配之前：" + template);
        int i = this.getTemplateSize(template);
        String[] params = this.getParams();
        if (this.checkNumSize(params.length, i)) {
            template = this.repalceTemplate(params, template);
            System.out.println("匹配过后：" + template);
        }
    }

    /**
     * 参数数组.
     *
     * @return 参数数组
     */
    private String[] getParams() {
        return new String[]{"这是测试1", "这是测试2", "这是测试3", null, ""};
    }

    /**
     * 模板.
     *
     * @return 返回模板
     */
    private String getTemplate() {
        return "内容[${1}]内容[${2}${3}]内容内$$$$$$$$${$$}$$$${}容内容内容内容[${4}][${5}]";
    }

    /**
     * 校验 参数值和模板需要的值是否相等.
     *
     * @param paramsSize   参数值
     * @param templateSize 模板需要值
     * @return true 相等 false  不相等
     */
    private boolean checkNumSize(int paramsSize, int templateSize) {
        return paramsSize == templateSize;
    }

    /**
     * 获取模板中包含参数的个数.
     *
     * @param template 模板
     * @return 返回 参数个数
     */
    private int getTemplateSize(String template) {
        String strRegex = "\\$\\{([0-9]{1,9})\\}";
        Pattern pat = Pattern.compile(strRegex);
        Matcher mat = pat.matcher(template);
        int i = 0;
        while (mat.find()) {
            i++;
        }
        return i;
    }

    /**
     * 模板替换参数
     *
     * @param params   参数值
     * @param template 模板
     * @return 新的模板
     */
    private String repalceTemplate(String[] params, String template) {
        String strRegex = "\\$\\{([1-9]{1,9})\\}";
        Pattern pat = Pattern.compile(strRegex);
        Matcher mat = pat.matcher(template);
        String numRegex = "[1-9]";
        Pattern numPat = Pattern.compile(numRegex);
        StringBuffer sb = new StringBuffer();
        while (mat.find()) {
            Matcher numMat = numPat.matcher(mat.group());
            while (numMat.find()) {
                String param = params[Integer.parseInt(numMat.group()) - 1];
                param = StringUtils.isEmpty(param) ? "" : param;
                mat.appendReplacement(sb, param);
            }
        }
        mat.appendTail(sb);
        return sb.toString();
    }
}
