package cn.itcast.gjp.Array;


public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "张一", "aaa");
        HeroNode heroNode2 = new HeroNode(2, "张二", "bbb");
        HeroNode heroNode3 = new HeroNode(3, "张三", "ccc");
        HeroNode heroNode4 = new HeroNode(4, "张四", "ddd");

        HeroNode heroNode5 = new HeroNode(1, "张零", "eee");

        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addByOrder(heroNode1);
        singleLinkList.addByOrder(heroNode3);
        singleLinkList.addByOrder(heroNode2);
        singleLinkList.addByOrder(heroNode4);
        //System.out.println("新增英雄");

        /*singleLinkList.add(heroNode1);
        singleLinkList.add(heroNode4);
        singleLinkList.add(heroNode3);*/
        singleLinkList.show();

        //singleLinkList.delete(0);
        System.out.println("=====");
        singleLinkList.reverse(singleLinkList.getHead());
        singleLinkList.show();
    }
}

class SingleLinkList {
    private HeroNode head = new HeroNode(0, " ", " ");

    public HeroNode getHead() {
        return head;
    }

    //添加元素
    public void add(HeroNode heronode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next=heronode;
    }
    public void addByOrder(HeroNode heronode) {
        boolean flag = false;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (heronode.no < temp.next.no) {
                break;
            } else if (temp.next.no == heronode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的英雄已存在");
        }else {
            heronode.next = temp.next;
            temp.next = heronode;
        }
    }

    public void update(HeroNode newHero){
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                System.out.println("");
                break;
            }
            if(temp.no == newHero.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.nickname = newHero.nickname;
            temp.name = newHero.name;
        }else {
            System.out.println("没有找到该编号英雄");
        }
    }
    //删除节点
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("没有英雄");
                break;
            }if(temp.next.no==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到要删除的英雄");
        }
    }
    //显示链表
    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                //System.out.println(temp);
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //单链表翻转
    public void reverse(HeroNode head){
        if(head.next==null || head.next.next==null){
            return;
        }
        HeroNode cur =head.next;
        HeroNode next=null;
        HeroNode reverseHead =new HeroNode(0," "," ");
        while (cur !=null){
            next = cur.next;//先暂时保存当前节点的下一个节点
            cur.next =reverseHead.next;//将当前节点的下一个节点指到新链表的最前点
            reverseHead.next=cur;//将cur连到新的链表上
            cur = next;
        }
        head.next=reverseHead.next;
    }
}

    class HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }

