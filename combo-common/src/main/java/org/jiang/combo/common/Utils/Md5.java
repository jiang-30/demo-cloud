package org.jiang.combo.common.Utils;

import org.springframework.util.DigestUtils;

public class Md5 {
    public static void main(String[] args) {
        String s = "zhangjia";
        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes()));
    }
}
