package cn.itcast.gjp.myStudy;

public class recursion_miGong {
    public static void main(String[] args) {
        int[][] ints = new int[7][8];
        ints[2][1] = 1;
        ints[2][2] = 1;

        for (int i = 0; i < 8; i++){
            ints[0][i] = 1;
            ints[6][i] = 1;
        }

        for(int i = 0 ;i < 7; i++){
            ints[i][0] = 1;
            ints[i][7] = 1;

        }

        setWay(ints,1,1);

        for(int i = 0; i < 7; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(ints[i][j]);
            }
            System.out.println();
        }
    }

    public static Boolean setWay(int[][] ints, int i, int j){
        if(ints[5][6]==2){
            return true;
        }else {
            if(ints[i][j]==0){
                ints[i][j]=2;
                if(setWay(ints,i+1,j)){
                    return true;
                }else if(setWay(ints, i,j+1 )){
                    return true;
                }else if(setWay(ints,i -1,j)){
                    return true;
                }else if(setWay(ints,i, j-1)){
                    return true;
                }else {
                    ints[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
