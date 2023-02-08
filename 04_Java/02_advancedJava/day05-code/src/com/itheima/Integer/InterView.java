package com.itheima.Integer;

public class InterView {
    /*
        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high) {
                // 从底层的一个数组中取出一个提前创建好的 Integer 对象
                return IntegerCache.cache[i + (-IntegerCache.low)];
            }
            // 如果装箱的数据，不在 -128 ~ 127 之间，会重新创建新的对象
            return new Integer(i);
        }

        Integer类中，底层存在一个长度为 256 个大小的数组，Integer[] cache 在数组中，存储了 256 个 Integer 对象，分别是 -128 ~ 127
     */
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);  // true

        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i3 == i4);  // false

        Long i11 = 129L;
        Long i22 = 129L;
        System.out.println(i11 == i22);  // false
        System.out.println(i11.equals(i22));  // true 说明重写了 equals 比较的是内容而不是地址
    }
}
