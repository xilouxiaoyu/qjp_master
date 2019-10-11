package cn.itcast.gjp.service;

import lombok.val;
import org.w3c.dom.NodeList;

import java.util.Stack;

/**
 * @author apple
 * @date 2019/10/11 下午5:52
 */
public class Exercise1 {

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


    public static void main(String[] args) {
        //System.out.println(getCount("akakkahaha","ha"));
        System.out.println(isComplete("[][][]{}}{}{]]]]]"));
    }
}

