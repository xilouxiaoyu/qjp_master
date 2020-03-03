package cn.itcast.gjp.myStudy;

public class BinaryTreeStudy {

    public static void main(String[] args) {


        heroNode root = new heroNode(1, "宋江");
        heroNode node2 = new heroNode(2, "武松");
        heroNode node3 = new heroNode(3, "鲁智深");
        heroNode node4 = new heroNode(4, "卢俊义");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        BinaryTree binaryTree = new BinaryTree(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.midOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}

class BinaryTree{
    public heroNode root;

    public BinaryTree() {
    }

    public BinaryTree(heroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    public void midOrder(){
        if(this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }

    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("当前二叉树为空");
        }
    }
}

class heroNode{
    private int id;
    private String name;
    private heroNode left;
    private heroNode right;

    public heroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public heroNode getLeft() {
        return left;
    }

    public heroNode getRight() {
        return right;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(heroNode left) {
        this.left = left;
    }

    public void setRight(heroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "heroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){

        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right !=null){
            this.right.preOrder();
        }
    }

    public void midOrder(){

        if(this.left != null){
            this.left.midOrder();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.midOrder();
        }
    }

    public void postOrder(){

        if (this.left != null){
            this.left.postOrder();
        }

        if (this.right !=null){
            this.right.postOrder();
        }

        System.out.println(this);
    }
}