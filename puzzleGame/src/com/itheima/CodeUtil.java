package com.itheima;

import java.util.Random;

public class CodeUtil {
    private CodeUtil(){
    }
    public static String generateCode(int n){
        Random r = new Random();
        String code = "";
        for (int i = 0; i < n; i++) {
            //生成三个数字
            int type = r.nextInt(3);
            switch (type){
                case 0:
                    //大写字母
                    char ch = (char)(r.nextInt(26) + 65);
                    code += ch;
                    break;
                case 1:
                    //小写字母
                    ch = (char)(r.nextInt(26) + 97);
                    code += ch;
                    break;
                case 2:
                    //数字
                    code += r.nextInt(10);
                    break;
            }
        }
        return code;
    }
}
