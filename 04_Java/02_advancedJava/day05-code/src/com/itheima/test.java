package com.itheima;

import java.util.Random;
import java.util.Scanner;

public class test{
    public static void main(String[] args){
        //生成中奖号码
        int[] arr=createNumber();

        //用户输入彩票号码
        int[] userinputArr=userinputNumber();
        for(int i=0; i<userinputArr.length; i++){
            System.out.print(userinputArr[i]+" ");
        }
    }

    public static int[] userinputNumber(){
        int[] arr=new int[7];//创建数组，用于添加输入的号码
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<6;){
            System.out.println("请输入第"+(i+1)+"个红球号码");
            int redNumber=sc.nextInt();
            if(redNumber>=1 && redNumber<=33){
                boolean flag=contains(arr,redNumber);
                if(!flag){
                    arr[i]=redNumber;
                    i++;
                    break;
                }else{
                    System.out.println("当前红球号码已存在");
                }
            }else{
                System.out.println("号码超出范围！");
            }
        }
        while(true){
            int blueNumber=sc.nextInt();
            if(blueNumber>=1 && blueNumber<=16){
                arr[arr.length-1]=blueNumber;
                break;
            }else{
                System.out.println("当前蓝球超出范围");
            }
        }
        return arr;
    }

    public static int[] createNumber(){
        int[] arr=new int[7];//创建数组，用于添加中奖号码
        Random r=new Random();
        //红球
        for(int i=0; i<6;){
            int redNumber=r.nextInt(33)+1;
            boolean flag=contains(arr,redNumber);
            if(!flag){
                arr[i]=redNumber;
                i++;
            }
        }
        //蓝球
        int blueNumber=r.nextInt(16)+1;
        arr[arr.length-1]=blueNumber;

        return arr;
    }
    //用于判断数字在数组中是否存在
    public static boolean contains(int[] arr,int number){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==number){
                return true;
            }
        }
        return false;
    }
}