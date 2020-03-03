package cn.itcast.gjp.myStudy;

import java.util.Arrays;

public class heapSort {

    public static void main(String[] args) {
        int[] arr ={4,6,8,5,9,1,2,10,-1};
        heapSort(arr);
        int a =123;


    }

    public static void heapSort(int[] arr){
        int temp = 0;

        /*adjust(arr,1,4);
        adjust(arr,0,4);*/
       for (int i = arr.length / 2 -1; i >= 0; i--){
           adjust(arr, i, arr.length);
       }

       for (int j = arr.length-1; j > 0; j-- ){

           temp = arr[j];
           arr[j] = arr[0];
           arr[0] = temp;

           adjust(arr,0, j);
       }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjust(int[] arr, int i,int length){

        int temp = arr[i];

        for(int k = 2 * i +1; k < length; k = 2 * k +1){

            if(k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (temp < arr[k]){
                arr[i] =arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}


