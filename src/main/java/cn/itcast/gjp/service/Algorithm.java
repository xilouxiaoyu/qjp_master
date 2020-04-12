package cn.itcast.gjp.service;

import cn.itcast.gjp.domain.user;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.testng.annotations.Test;

import javax.mail.internet.MimeMessage;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author apple
 * @date 2019/10/11 下午5:52
 */
public class Algorithm {

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
    //两数相加
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
    @Test
    public void BulleSort() {

        int[] a = {2,1,3,5};

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0 ; j < a.length - i- 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
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
        while(index < minLen && (diff=Long.parseLong(version1[index])-Long.parseLong(version2[index]))==0)
            index++;
        if(diff==0) {
            for(int i=index;i<version1.length;i++)
                if(Long.parseLong(version1[i])>0)
                    return 1;
            for(int i=index;i<version2.length;i++)
                if(Long.parseLong(version2[i])>0)
                    return -1;
            return 0;
        }else {
            return diff > 0 ? 1 : -1;
        }
    }



    //上楼梯每次只需一步或者两步，有多少走法
    public static int ways(int n){
        if(n==1)
            return 1;
        if(n==2) return 2;
        return ways(n-1)+ways(n-2);
    }

    //
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
        for(int w=0 ; w<count; w++){
            System.out.println( k[w] );
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


    static class Node<T>{
        private Node next;
        private T value;

        public void foreach() {
            Node node = next;
            System.out.println(value);
            while (node != null) {
                System.out.println(node.value);
                node = node.next;
            }
        }

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }

        public Node() {
        }

        public void add(T value) {
            Node node = new Node<T>(null, value);
            next = node;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }
    //单链表翻转
    public static Node reverse(Node srcNode) {
        Node dscNode = srcNode;
        Node tail = srcNode;
        Node head = srcNode;
        while (tail.next != null) {
            Node next2 = tail.next.next;
            tail.next.next = head;
            head = tail.next;
            tail.next = next2;
            if (tail.next == null) {
                return head;
            }
        }
        return dscNode;
    }
    //单链表是否有环
    public static boolean hasHoop(Node node){
         Node slow;
         Node fast;
         Node head;
         slow = node.next;
         fast = node.next.next;
         while (slow !=null && fast.next!= null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast){
                 return true;
             }
         }
        return false;
    }
    //单链表找到环的入口
    public static Node detectCycle(Node node){
        Node slow;
        Node fast;
        Node head = node;
        slow = node.next;
        fast = node.next.next;
        while (slow !=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
    }
        Node p = head;
        Node cross= slow;
        if (head != slow){
            head = head.next;
            p = p.next;
        }
        return  p;
    }

    public static String toUpperFirstCode(String str){
        String[] s = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for(String ss:s){
            char[] ch =ss.toCharArray();
            if (ch[0] >= 'a' && ch[0] <= 'z') {
                ch[0] = (char) (ch[0] - 32);
            }
            String strT = new String(ch);
            stringBuffer = stringBuffer.append(strT).append(" ");
        }
        return stringBuffer.toString();
    }
    //二分法查找
    public static int search(int key ,int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start <= end){
            int mid = (start+end)/2;
            if(key < arr[mid]){
                end = mid-1;
            } else if(key > arr[mid]) {
                start = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    //判断是否是素数
    public static boolean isPrime(int a){
        boolean isPrime = true;
        for(int i = 2; i < a; i++){
            if(a%i == 0){
              isPrime = false;
              break;
            }
        }
        return isPrime;
    }

    //求字符串中重复字符串最大的长度
    public static void maxRepeating(String str){
        char[] array = str.toCharArray();
        int count = 1;
        int max = 0;
        char maxChar = 0;
        int maxIndex = 0;
        for(int i=1; i < array.length; i++){ // Start from 1 since we want to compare it with the char in index 0
            if(array[i] == array[i-1]){
                count++;
            } else {
                if( count > max ){  // Record current run length, is it the maximum?
                    max = count;
                    maxChar = array[i-1];
                    maxIndex = i-1;
                }
                count = 1; // Reset the count
            }
        }
        if( count > max ){
            max = count; // This is to account for the last run
            maxChar = array[array.length-1];
            maxIndex = array.length-1;
        }
        System.out.println("Longest run: "+max+", for the character "+maxChar+"and the max char index is:"+maxIndex);
        System.out.println(str.substring(maxIndex-(max-1),maxIndex+1));

    }

    //给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){//判断字符串是否为空
            return 0;
        }else{//不为空
            int max=1;//从第一个字符开始，假设1就为最大值
            int sum=1;
            String s1=""+s.charAt(0);//获取字符串中第一个字符，将其作为flag
            if(s.length()==1){
                return 1;//判断字符串长度是否为1，为1直接返回1
            }
            for (int i = 1; i < s.length(); i++) {
                //从第二个字符开始遍历
                if(s1.indexOf(""+s.charAt(i))!=-1){
                    //判断flag字符中是否还有下一个字符
                    int n1=s1.length()-s1.indexOf(""+s.charAt(i))-1;
                    //找到flag字符中含有下一个字符的位置,并截取其后字符的长度
                    sum=n1+1;
                    s1=s1.substring(s1.indexOf(""+s.charAt(i))+1,s1.length())+s.charAt(i);
                    //截取原flag其后字符并加上末端的重复字符形成新的flag字符
                }else{
                    sum=sum+1;
                    //flag字符中没有有下一个字符，sum+1并在flag字符中加上下一个字符
                    s1=s1+s.charAt(i);
                }
                if(sum>max){//当sum>max,替换max
                    max=sum;
                }
            }
            return max;
        }

    }
    public static int maxlength(String str) {
        int max=1;
        String s1=""+str.charAt(0);
        //System.out.println(Integer.parseInt("123456"));
        for(int i=1;i < str.length();i++){
            if(s1.indexOf("" + str.charAt(i)) == -1){
                s1=s1 + ""+ str.charAt(i);
            }else {
               s1 = s1.substring(s1.indexOf(""+ str.charAt(i))+1) + str.charAt(i);
            }
            max = Math.max(s1.length(),max);

        }
        return max;
    }

    public static int maxSubArray(int[] nums){
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }

    public static int mySqrt2(int x){
        if(x < 2){
            return x;
        }
        double x0 = x;
        double x1 = (x0 + x / x0) / 2;
        while (Math.abs(x0 - x1) > 1){
            x0 = x1;
            x1 = (x0 + x / x0) /2;
        }
        return (int) x1;
    }


    public static int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    //字符串与pattern匹配
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Object, Integer> mem = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            if (!Objects.equals(mem.put(words[i], i),
                    mem.put(pattern.charAt(i), i))) return false;
        return true;
    }

    public static ArrayList<String> getMaxString(String s1, String s2) {
        String maxString = (s1.length() < s2.length()) ? s2 : s1;
        String minString = (s1.length() < s2.length()) ? s1 : s2;
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < minString.length(); i++) {
            for (int x = 0, y = minString.length() - i; y < minString.length(); x++, y++) {
                maxString.contains(minString.substring(x, y));
                strings.add(minString.substring(x, y));
            }
            if (strings.size() != 0) {
                return strings;
            }
        }
        return null;
    }

    public static void twoArr() {
        int[] arr1 = {28, 87, 98, 87};
        int[] arr2 = {23, 76, 89, 90};

        //因为数组长度不可变，所以新的数组需要重新定义，长度为两个旧数组长度和
        int[] arr = new int[arr1.length + arr2.length];

        //遍历新数组
        for (int i = 0; i < arr.length; i++) {
            if (i < arr1.length) {
                arr[i] = arr1[i];  //把数组arr1的元素放入新数组
            } else {
                arr[i] = arr2[i - arr1.length]; //把数组arr2的元素放入新数组
            }
        }
        System.out.println("-------排序前-----------");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("--------排序后-----------");
        Arrays.sort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1; //将递归法的结束条件初始化为 1
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;

        }
        return dp[0];
    }

    public static int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i:nums){
            Integer count = map.get(i);
            count = count == null? 1:++count;
            map.put(i, count);
        }
        for(Integer i : map.keySet()){
            Integer count = map.get(i);
            if(count == 1){
                return i;
            }
        }
        return -1;
        
    }

    public List<List<Integer>> fourSum(int[] nums,int target){
        /*定义一个返回值*/
        List<List<Integer>> result=new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if(nums==null||nums.length<4){
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        /*数组长度*/
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
                continue;
            }
            /*第二层循环i，初始值指向k+1*/
            for(int i=k+1;i<length-2;i++){
                /*当i的值与前面的值相等时忽略*/
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                /*定义指针j指向i+1*/
                int j=i+1;
                /*定义指针h指向数组末尾*/
                int h=length-1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min=nums[k]+nums[i]+nums[j]+nums[j+1];
                if(min>target){
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max=nums[k]+nums[i]+nums[h]+nums[h-1];
                if(max<target){
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        j++;
                        while(j<h&&nums[j]==nums[j-1]){
                            j++;
                        }
                        h--;
                        while(j<h&&i<h&&nums[h]==nums[h+1]){
                            h--;
                        }
                    }else if(curr>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length ==0 ) return new ArrayList<>();
        HashMap<String, List> map = new HashMap<>();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.keySet().contains(key)){
                map.put(key,new ArrayList());
            }
            map.get(key).add(s);

        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) throws Exception {

        String[] a = {"jkl","lkj","kjl","ty","yt"};
        System.out.println(groupAnagrams(a).toString());


        //System.out.println(maxlength("abcdeabbb"));
        /*String[] a = {"bca","abc","bca"};
        arraySort(a);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }*/

        //twoArr();

        /*String s1 = "abdhjkhhdd";
        String s2 = "khhh";
        System.out.println(getMaxString(s1, s2));

        String a = "1233";
        int i = Integer.parseInt(a);
        String s = String.valueOf(i);
        System.out.println(s);

        String b = "aaaa";
        byte[] bytes = b.getBytes();
        for(byte by:bytes){
            System.out.println(by);
        }

        String s3 = new String(bytes);
        System.out.println(s3);

        String c = "郝晓庆";
        char[] chars = c.toCharArray();
        for(char ch:chars){
            System.out.print(ch);
        }

        String s4 = new String(chars);
        System.out.println(s4);*/

        //单链表
        /*Node node1 = new Node<Integer>(null, 1);
        Node node2 = new Node<Integer>(null, 2);
        Node node3 = new Node<Integer>(null, 3);
        Node node4 = new Node<Integer>(null, 4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.foreach();
        reverse(node1).foreach();*/
        //String str = "aaaaaaabaa";
        //System.out.println(maxlength(str));

       /* int[] nums = {1,4,5,2,3};
        *//*List<int[]> ints = Arrays.asList(nums);
        ints.toArray();*//*
        int[] ints = plusOne(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }*/

        //System.out.println(climbStairs(3));
        //rotate(nums,3);
        /*String a = "aabb";
        String b = "aabb aabb hjk hjk";
        boolean b1 = wordPattern(a, b);
        System.out.println(b1);*/

        /*user user = new user();
        Class<? extends cn.itcast.gjp.domain.user> userClass = user.getClass();
*/
        //Class<?> userClass = Class.forName("cn.itcast.gjp.domain.user");
        /*Method[] methods = userClass.getMethods();
        for(int i = 0; i < methods.length; i++){
            System.out.print(methods[i]);
            System.out.println();

            Annotation[] annotations = methods[i].getAnnotations();
            for (Annotation an:annotations) {
                System.out.print(an.toString());

            }
        }*/

    }
}

