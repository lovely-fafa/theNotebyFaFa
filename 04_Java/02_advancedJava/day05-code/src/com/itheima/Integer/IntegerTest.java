package com.itheima.Integer;

public class IntegerTest {
    /*
        已知字符串 String s = "10,50,30,20,40"
        请将该字符串转换为整数并存入数组
        随后求出最大值打印在控制台
     */
    public static void main(String[] args) {
        String s = "10,50,30,20,40";

        String[] sArr = s.split(",");
        int[] nums = new int[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            nums[i] = Integer.parseInt(sArr[i]);
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        System.out.println(max);  // 50
    }
}
