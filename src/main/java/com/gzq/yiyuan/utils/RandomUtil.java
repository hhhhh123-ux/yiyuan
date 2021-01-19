package com.gzq.yiyuan.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by sugar on 2019/5/21.
 */
public class RandomUtil {
    /**
     * 生产24位随机数
     *
     * @return 17位时间+7位随机字母
     */
    public static String randomTime24() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date()) + RandomStringUtils.randomAlphabetic(7);
    }

    public static String random32() {
        return random36().replaceAll("-", "");
    }

    public static String random36() {
        return UUID.randomUUID().toString();
    }

    public static String random10() {
        String result = RandomStringUtils.randomNumeric(10);
        return result;
    }

    public static void main(String[] args) {
        String result = RandomStringUtils.randomNumeric(10);
        System.out.println(result);

    }
    /**
     * 生产6位短信验证码
     *
     * @return
     */
    public static String getSMS6() {
        String result = RandomStringUtils.randomNumeric(6);
        return result;
    }

    public static String getUUIDString() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getImageRandomCode(int n) {
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";// 保存数字0-9 和 大小写字母
        // String string = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大写字母
        char[] ch = new char[n]; // 声明一个字符数组对象ch 保存 验证码
        for (int i = 0; i < n; i++) {
            Random random = new Random();// 创建一个新的随机数生成器
            int index = random.nextInt(string.length());// 返回[0,string.length)范围的int值 作用：保存下标
            ch[i] = string.charAt(index);// charAt() : 返回指定索引处的 char 值 ==》保存到字符数组对象ch里面
        }
        // 将char数组类型转换为String类型保存到result
        // String result = new String(ch);//方法一：直接使用构造方法 String(char[] value) ：分配一个新的
        // String，使其表示字符数组参数中当前包含的字符序列。
        // 方法二： String方法 valueOf(char c) ：返回 char 参数的字符串表示形式。
        String result = String.valueOf(ch);
        return result;
    }
}
