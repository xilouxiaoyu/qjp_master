package cn.itcast.gjp.service;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.val;
import org.w3c.dom.NodeList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author apple
 * @date 2019/10/11 下午5:52
 */
public class Exercise1 {

    /**
     * 计算字符串中含有另一个字符串的个数
     */
    public static int  getCount(String str,String key){
        if(str == null || key == null || "".equals(str.trim()) || "".equals(key.trim())){
            return 0;
        }
        int count = 0;
        int index = 0;
        while((index=str.indexOf(key,index))!=-1){
            index = index+key.length();
            count++;
        }
        return count;
    }
    /**
     * 将两个链表合并
     */
       /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {

            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }*/


    /**
     * 判断字符串中括号是否匹配出现的
     */
    public static boolean isComplete(String s){
        Stack<String> left=new Stack<String>();
        while (!s.isEmpty()){
            //取字符串首字母
            String character=s.substring(0,1);
            //剩余的字符串
            s=s.substring(1);
            if(character.equals("{")||character.equals("[")||character.equals("(")){
                //如果是左括号，则压入栈
                left.push(character);
            }else if(character.equals(")")||character.equals("]")||character.equals("}")){
                //首先检查栈是否为空
                if(left.isEmpty())
                    return false;
                //弹出最后的左括号
                String leftChar=left.pop();
                //检查左右括号是否匹配
                if(character.equals(")")){
                    if(!leftChar.equals("("))
                        return false;
                }else if(character.equals("]")){
                    if(!leftChar.equals("["))
                        return false;
                }else if(character.equals("}")){
                    if(!leftChar.equals("{"))
                        return false;
                }
            }
        }
        //此时栈中不应该再有左括号
        return left.isEmpty();
    }


    /**
     * 用字符串模拟两个大数相加
     * @param n1 加数1
     * @param n2 加数2
     * @return   相加结果
     */

    public static String add2(String n1,String n2) {
        StringBuffer result = new StringBuffer();

        //1、反转字符串
        n1 = new StringBuffer(n1).reverse().toString();
        n2 = new StringBuffer(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n1.length();
        int maxLen = len1 > len2 ? len1 : len2;
        boolean nOverFlow = false; //是否越界
        int nTakeOver = 0 ; //溢出数量

        //2.把两个字符串补齐，即短字符串的高位用0补齐
        if(len1 < len2) {
            for(int i = len1 ; i < len2 ; i++) {
                n1 += "0";
            }
        }
        else if (len1 > len2) {
            for(int i = len2 ; i < len1 ; i++) {
                n2 += "0";
            }
        }

        //3.把两个正整数相加，一位一位的加并加上进位
        for(int i = 0 ; i < maxLen ; i++) {
            int nSum = Integer.parseInt(n1.charAt(i) +"") + Integer.parseInt(n2.charAt(i) +"")+nTakeOver;
            if(nSum >= 10) {
                if(i == (maxLen - 1)) {
                    nOverFlow  = true;
                }
                nTakeOver = 1;
                result.append(nSum - 10);
            }
            else {
                nTakeOver = 0;
                result.append(nSum);
            }
        }

        //如果溢出的话表示位增加了
        if(nOverFlow) {
            result.append(nTakeOver);
        }
        return result.reverse().toString();
    }
    public static int[] getTargetNums(int[] nums, int target) {
        int[] tartgetNum = new int[2];
        for(int i=0; i<nums.length -1; i++) {
            //优化，只考虑i位置后面的元素，前面的元素其实已经被过滤掉了
            for(int j= i+1; j<nums.length;j++) {
                if((nums[i] + nums[j]) == target) {
                    tartgetNum[0] = i;
                    tartgetNum[1] = j;
                    return tartgetNum;
                }
            }
        }
        return tartgetNum;
    }

    //冒泡排序
    public void BulleSort() {
        System.out.println("2、交换排序->冒泡排序");

    int[] a = {12,20,5,16,15,1,30,45,23,9};

    for(int i = 0; i < a.length -1; i++) {
        // 采用第一层循环来控制循环的次 数，一共循环a.length-1次
        // 这样会循环到倒数第二个元素
         for (int j = i + 1; j < a.length; j++) {
             // 第二层循环来交换位置，j在 i的基础上+1是因为当前的值要和他身后的元素比较大小，直至最后一个。
             //（ // 因为第二次循环直至最后一 个所以第一层循环才会a.length-1）
              if (a[i] > a[j]) {
                  int temp = a[i];
                  a[i] = a[j];
                  a[j] = temp;
              }
         }
    }
    }

    //快速排序
        private static void quickSort(int[] arr, int low, int high) {

            if (low < high) {
                // 找寻基准数据的正确索引
                int index = getIndex(arr, low, high);

                // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
                quickSort(arr, 0, index - 1);
                quickSort(arr, index + 1, high);
            }

        }

        private static int getIndex(int[] arr, int low, int high) {
            // 基准数据
            int tmp = arr[low];
            while (low < high) {
                // 当队尾的元素大于等于基准数据时,向前挪动high指针
                while (low < high && arr[high] >= tmp) {
                    high--;
                }
                // 如果队尾元素小于tmp了,需要将其赋值给low
                arr[low] = arr[high];
                // 当队首元素小于等于tmp时,向前挪动low指针
                while (low < high && arr[low] <= tmp) {
                    low++;
                }
                // 当队首元素大于tmp时,需要将其赋值给high
                arr[high] = arr[low];

            }
            // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
            // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
            arr[low] = tmp;
            return low; // 返回tmp的正确位置
        }
    //atoi实现方式1
    public static long atoi(String str) throws Exception {
        long value = 0;
        boolean negative = false;
        if(str == null || "".equals(str) ){
            throw new Exception("the str cannot be null!");
        }
        for(int i = 0; i<str.length() ; i++) {
            if(i==0 && (str.charAt(0)=='+' || str.charAt(0)=='-') ) {
                if(str.charAt(0)=='-') {
                    negative = true;
                }
            }else {
                if(str.charAt(i)>='0' && str.charAt(i)<='9') {
                    value = value*10 + str.charAt(i)-'0';
                    if (value > Integer.MAX_VALUE) {
                        throw new Exception("OUT OF INTEGER RANGE");
                    }
                }else {
                    throw new NumberFormatException("not an integer!");
                }
            }
        }

        return negative==true ? -1*value:value;
    }
    //atoi实现方式2
    public static long atoi2(String str) throws Exception {
        long value = 0;
        boolean negative = false;
        if(str == null || "".equals(str) ){
            throw new Exception("the str cannot be null!");
        }
        int num_lengths = str.length();
        if(str.charAt(0)=='+' || str.charAt(0)=='-') {
            if(str.charAt(0)=='-') {
                negative = true;
                num_lengths--;
            }
        }

        for(int i=(str.length() - num_lengths); i<str.length();i++ ,num_lengths--) {
            if(str.charAt(i)>='0' && str.charAt(i)<='9') {
                System.out.println(str.charAt(i)-'0');
                value +=  (str.charAt(i)-'0')*Math.pow(10, (num_lengths-1));
                if (value > Integer.MAX_VALUE) {
                    throw new Exception("OUT OF INTEGER RANGE");
                }
            }else {
                throw new NumberFormatException("not an integer!");
            }
        }
        return negative==true ? -1*value:value;
    }

    /**
     *字典排序
     */
    public static String[] arraySort(String[] input){
        for (int i=0;i<input.length-1;i++){
            for (int j=0;j<input.length-i-1;j++) {
                if(input[j].compareTo(input[j+1])>0){
                    String temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        return input;
    }
    //比较客户端版本大小
    public static int compareVersion(String v1,String v2)
    {
        if(v1.equals(v2))
        {
            return 0;
        }
        String[] version1=v1.split("\\.");
        String[] version2=v2.split("\\.");
        int index=0;
        int minLen=Math.min(version1.length, version2.length);
        long diff=0;
        while(index<minLen&&(diff=Long.parseLong(version1[index])-Long.parseLong(version2[index]))==0)
            index++;
        if(diff==0)
        {
            for(int i=index;i<version1.length;i++)
                if(Long.parseLong(version1[i])>0)
                    return 1;
            for(int i=index;i<version2.length;i++)
                if(Long.parseLong(version2[i])>0)
                    return -1;
            return 0;
        }else {
            return diff>0?1:-1;
        }
    }



    //上楼梯每次只需一步或者两步，有多少走法
    public static int ways(int n){
        if(n==1)
            return 1;
        if(n==2) return 2;
        return ways(n-1)+ways(n-2);
    }
    public static int compareVersion2(String v1,String v2){
        if(v1.equals(v2)){
            return 0;
        }

        String[] version1 = v1.split("\\.");
        String[] version2 = v2.split("\\.");

        long diff=0;
        int index=0;
        int minLen=Math.min(version1.length,version2.length);
        while(index<minLen&&(diff=Long.parseLong(version1[index])-Long.parseLong(version2[index]))==0)
            index++;
        if(diff==0){
            if((version1.length-version2.length)>0){
                return 1;
            }if((version1.length-version2.length)<0){
                return -1;
            }
        }

        return diff>0?1:-1;
    }

    public static void merge(int[] m,int[] n) {
        int i = 0, j = 0, count = 0;
        int msize = m.length;
        int nsize = n.length;
        int[] k = new int[m.length + n.length];
        while (i < msize && j < nsize) {
            if (m[i] < n[j]) {
                k[count++] = m[i++];
            } else {
                k[count++] = n[j++];
            }
        }
        if (i >= msize) {
            while (j < n.length) {
                k[count++] = n[j++];
            }
        }
        if (j >= nsize) {
            while (i < m.length) {
                k[count++] = m[i++];
            }
        }
        for(int w=0;w<count;w++){
            System.out.println(k[w]);
        }
    }

    public static boolean match(String s){

        Stack<String> leftStack1 = new Stack<>();
        Stack<String> leftStack2 = new Stack<>();
        Stack<String> leftStack3 = new Stack<>();
        while(!s.isEmpty()) {
            String character = s.substring(0, 1);
            s = s.substring(1);
            if (character.equals("(")) {
                leftStack1.push(character);
            }
            if (character.equals("[")) {
                leftStack2.push(character);
            }
            if (character.equals("{")) {
                leftStack3.push(character);
            }

            if (character.equals(")")) {
                if (leftStack1.empty()) {
                    return false;
                }
                String leftChar = leftStack1.pop();
            }
            if (character.equals("]")) {
                if (leftStack2.empty()) {
                    return false;
                }
                String leftChar = leftStack2.pop();
            }
            if (character.equals("}")) {
                if (leftStack3.empty()) {
                    return false;
                }
                String leftChar = leftStack3.pop();
            }

        }
            return leftStack1.isEmpty() && leftStack2.isEmpty() && leftStack3.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(getCount("akakkahaha","ha"));
        //System.out.println(isComplete("[][][]{}}{}{]]]]]"));
        //System.out.println(add2("34","198"));
        //hahhaajkja
        //System.out.println(atoi2("12137"));
        //System.out.println(ways(5));
        //System.out.println(compareVersion2("7.5.1.1","7.5.9"));
        /*int[] m={1,2,23};
        int[] n={7,23,44,34,44};
        merge(m,n);*/
        System.out.println(match("kaj({)}]"));
    }
}

