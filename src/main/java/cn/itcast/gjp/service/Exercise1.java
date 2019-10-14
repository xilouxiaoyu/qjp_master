package cn.itcast.gjp.service;

import lombok.val;
import org.w3c.dom.NodeList;

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
            int nSum = Integer.parseInt(n1.charAt(i) +"") + Integer.parseInt(n2.charAt(i) +"");
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


    public static void main(String[] args) {
        //System.out.println(getCount("akakkahaha","ha"));
        //System.out.println(isComplete("[][][]{}}{}{]]]]]"));
        System.out.println(add2("82344","829793"));

    }


}

