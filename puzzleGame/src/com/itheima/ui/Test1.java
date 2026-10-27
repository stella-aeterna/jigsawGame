package com.itheima.ui;

import java.util.Random;

public class Test1 {
    static void main() {
        //数组的打乱
        int[] tempArr = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int tem = tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i] = tem;
        }
        int[][] Arr = new int[4][4];
        //代码利于理解
//        int k = 0;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                Arr[i][j] = tempArr[k++];
//            }
//        }
        for (int i = 0; i < tempArr.length; i++) {
            //代码简洁
            Arr[i / 4][i % 4] = tempArr[i];
        }
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                System.out.print(Arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
