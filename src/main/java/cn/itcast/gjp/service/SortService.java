package cn.itcast.gjp.service;

/**
 * @author apple
 * @date 2019/9/24 上午11:27
 */
public class SortService {
    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if (a[i] > a[j]){
                   int m=a[i];
                   a[i]=a[j];
                   a[j]=m;
                }
            }
        }

    }
    public static void main(String[] args) {
        int a[]={1,10,3};
        sort(a);
        for(Object obj:a){
        System.out.println(obj);
        }
    }
}
