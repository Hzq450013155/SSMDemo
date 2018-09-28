package com.ssm.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name MD5Util
 * @description
 * @date 2018-07-21
 */
public class MD5Util {
    //MD5加密
    public static String Encrypt(String data) {
        //获得java提供信息摘要算法加密功能类的一个实例
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        //将获取到的string转换成byte数组
        char[] chars = data.toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (byte) chars[i];
        }
        //获取MD5计算后的byte值
        byte[] md5byte = md5.digest(bytes);
        //将获取到的byte值转回string
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < md5byte.length; i++) {
            //使用0xff保持转值不出错
            int val = ((int) md5byte[i]) & 0xff;
            if (val < 16) {
                stringBuffer.append("0");
            } else {
                stringBuffer.append(Integer.toHexString(val));
            }
        }
        return stringBuffer.toString();
    }

    public static String md5Password(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }

    // 测试主函数
    public static void main(String args[]) {
        String s = new String("123");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + MD5Util.Encrypt(s));
        System.out.println("MD5后：" + MD5Util.md5Password(s));
        System.out.println("md5加密123:" + DigestUtils.md5Hex("jianggujin"));
        System.out.println("md5加密123:" + DigestUtils.sha256Hex("123"));

    }


}
