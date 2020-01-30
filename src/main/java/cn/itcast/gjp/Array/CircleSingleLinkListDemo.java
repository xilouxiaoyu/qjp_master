package cn.itcast.gjp.Array;

public class CircleSingleLinkListDemo{
    public static void main(String[] args) {

    }
}
class CircleSingleLinkList{

    public Boy first = new Boy(-1);
    public void addBoy(int nums){
        if (nums < 1){
            System.out.println("nums不正确");
        }else {
            Boy cruboy = null;
            for(int i=1;i <=nums; i++){
                Boy boy = new Boy(i);
                if(i==1){
                    cruboy = boy;
                    boy.setNext(boy);
                    first = boy;
                }
                else{
                     cruboy.setNext(boy);
                    //boy.
                }
            }

        }

    }

}


class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}