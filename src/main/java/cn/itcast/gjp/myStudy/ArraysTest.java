package cn.itcast.gjp.myStudy;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        returnArraysSort();
        returnArraysBinarySerch();
        returnArrayToString();
        returnArrayFill();
        returnArraysEquals();
        returnArraysAsList();
        returnArrayListCopyOf();
    }

    /**
     * Arrays.copyOf() :数组的拷贝
     */
    public static void returnArrayListCopyOf() {
        int[] numGroup = {25,12,68,78,33,55};
        int[] numGroup02=null;
        numGroup02=Arrays.copyOf(numGroup, 9);
        System.out.println(Arrays.toString(numGroup02));
    }

    /**
     * Arrays.asList() 查看数组中的特定值
     */
    public static void returnArraysAsList() {
        int[] numGroup = {25,12,68,78,33,55};
        int[] num1 = {25,12};
        Boolean judge=Arrays.asList(numGroup).contains(numGroup);
        System.out.println("查看数组中的特定值:"+judge);
    }

    /**
     * Arrays.asList() 判断两个数组是否相等
     */
    public static void returnArraysEquals() {
        int[] numGroup = {25,12,68,78,33,55};
        int[] numGroup02 = {35,12,68,78,33,55};
        Boolean judge=Arrays.equals(numGroup, numGroup02);
        System.out.println("判断两个数组是否相等:"+judge);
    }

    /**
     * Arrays.fill() 数组的填充
     */
    public static void returnArrayFill() {
        int[] numGroup = {25,12,68,78,33,55};
        Arrays.fill(numGroup, 13);
        System.out.println("数组的填充:"+Arrays.toString(numGroup));
    }

    /**
     * Arrays.toString() 打印数组内容
     */
    public static void returnArrayToString() {
        int[] numGroup = {25,12,68,78,33,55};
        System.out.println("输出数组内容为:"+Arrays.toString(numGroup));
    }

    /**
     * Arrays.binarySerch() 二分查找，找到则定位元素下标
     */
    public static void returnArraysBinarySerch() {
        int[] numGroup = {25,12,68,78,33,55};
        Arrays.sort(numGroup);
        int index=Arrays.binarySearch(numGroup, 78);
        System.out.println("该元素下标为:"+index);
    }

    /**
     * Arrays.sort():对数组进行排序(由小到大)
     */
    public static void returnArraysSort() {
        int[] numGroup = {25,12,68,78,33,55};
        Arrays.sort(numGroup);
        for (int i : numGroup) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

}
