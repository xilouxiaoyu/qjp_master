package cn.itcast.gjp.service;


public class daba {

    public int sum = 0;

    /**
     * @param time  总共可以尝试的次数.
     * @param score time次要求获得的环数.
     * @return time次完成score分数的可能情况数.
     */
    public int f(int time, int score) {
        int all = 0;
        if (score / time > 10)
            return 0;
        if (time == 1)
            return 1;
        for (int i = 0; i <= 10; i++) {
            int tmp = f(1, i) * f(time - 1, score - i);
            if (tmp >= 1)
                all += tmp;
        }
        return all;
    }

    /**
     * @param time  总次数
     * @param score time次数所要求达到得环数
     * @param arr   每次所中得环数.
     */
    public void f2(int time, int score, int[] arr) {
        //    System.out.println("time="+time+",score="+score);
        if (score / time > 10)
            return;
        if (time == 1) {
            arr[0] = score;
            output(arr);
            return;
        }
        for (int i = 0; i <= 10; i++) {
            arr[time - 1] = i;
            f2(time - 1, score - i, arr);
        }
    }

    private void output(int[] arr) {
        String result = "";
        for (int i = 0; i <= 9; i++) {
            result += arr[i] + " ";
        }
        System.out.println(result);
        sum++;

    }


    public daba() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        daba obj = new daba();
        //System.out.println(obj.f(10,90));;
        int[] arr = new int[10];
        obj.f2(10, 90, arr);
        System.out.println(obj.sum);
    }

}
