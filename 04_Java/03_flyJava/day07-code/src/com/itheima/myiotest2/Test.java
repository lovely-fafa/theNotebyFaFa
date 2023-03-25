package com.itheima.myiotest2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    // 带权重的随机
    public static void main(String[] args) throws IOException {
        // 1. 读取数据到内存
        ArrayList<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("day07-code\\src\\com\\itheima\\myiotest6\\name.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("-");
            Student stu = new Student(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
            list.add(stu);
        }
        br.close();

        // 2. 计算权重总和
        double weight = 0;
        for (Student stu : list) {
            weight += stu.getWeight();
        }

        // 3. 计算每一个人的实际占比
        double[] arr = new double[list.size()];
        int index = 0;
        for (Student stu : list) {
            arr[index] = stu.getWeight() / weight;
            index++;
        }

        // 4. 计算每一个人的权重占比
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        // 5. 随机抽取
        double number = Math.random();
        // 判断 number 在 arr 中的位置：二分查找
        int index2 = Arrays.binarySearch(arr, number);  // 返回 - 插入点 - 1
        int index3 = - index2 - 1;
        Student stu = list.get(index3);
        System.out.println(stu);

        // 6. 修改权重
        double w = stu.getWeight() / 2;
        stu.setWeight(w);

        // 7. 保存数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("day07-code\\src\\com\\itheima\\myiotest6\\name.txt"));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }
}
