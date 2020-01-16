package cn.itcast.gjp.Array;

import java.lang.reflect.Array;

public class SpareArray {
    public static void main(String[] args) {
        int chessArray[][] =new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][4]=2;

        for(int[] row: chessArray){
            for(int item: row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
    public static int[][] ArrayTospare(int[][] arr){
        int count=0;
        for(int[] row: arr){
            for(int item: row){
                if(item!=0){
                    count++;

                }
            }
            System.out.println();
        }

        return null;

    }
}
