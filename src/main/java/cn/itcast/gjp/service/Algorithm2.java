package cn.itcast.gjp.service;

public class Algorithm2 {
    //二分法变形查找
    public static int search(int[] a,int b){
        int max = a.length-1;
        int min =0;
        int mid;
        while(min<=max){
            mid=(max+min)/2;
            if (b == a[mid]) {
                return mid;
            }
            //左边有序
            if(a[min] < a[mid]){
                //在左边区间
                if (a[min] <= b && a[mid] > b) {
                    max = mid - 1;
                } else {
                    //在右边区间
                    min = mid + 1;
                }
            } else {
                //右边有序
                if (a[mid] < b && a[max] >=b){
                    min = mid+1;
                }else {
                    max = mid-1;
                }
            }
        }
        return -1;
    }
    //二分法查找
    public static int search2(int[] a,int b){
        int max = a.length-1;
        int min =0;
        int mid = (max+min)/2;
        while(min<=max){
            mid=(max+min)/2;
            if (b == a[mid]) {
                return mid;
            }
            if(b<a[mid]){
                max=mid-1;
            } else {
                 min=mid+1;
             }
        }
        return -1;
    }

    //回文

    public static int center(String s,int left, int right){
        int l = left;
        int r = right;
        while (l >= 0 && r <s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public static String longest(String s){
        if(s==null){
            return "";
        }
        int start = 0;
        int end =0;
        for(int i = 0;i<s.length(); i++){
            int lenth1 = center(s,i,i);
            int lenth2 = center(s,i,i+1);
            int lenth = Math.max(lenth1,lenth2);
            if(lenth > end-start){
                start =  i - (lenth - 1) / 2;;
                end = i +lenth/2;
            }
        }
        return s.substring(start, end+1);
    }
    public static int removeDuplicates(int[] a){
        int j=0;
        for(int i = 0; i<a.length; i++){
            if(a[i]!=a[j]){
                j++;
                a[j]=a[i];
            }
        }
        return j+1;

    }
        public static void main(String[] args) {
            int[] a={1,1,1,2,2,3,4,5};
            String s="adh";
            System.out.println(removeDuplicates(a));

    }
}
