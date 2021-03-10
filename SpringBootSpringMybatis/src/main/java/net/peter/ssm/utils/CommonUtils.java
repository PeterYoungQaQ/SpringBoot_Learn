package net.peter.ssm.utils;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 11:26
 * @Description:
 */

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class CommonUtils {

    /**
     * MD5加密方式
     * @param data
     * @return
     */
    public static String MD5(String data) {

        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toUpperCase();
        } catch (Exception ignored) {

        }

        return null;
    }
}
