package cn.itcast.gjp.myStudy.stackStudy;


import java.util.Scanner;

public class arrayToStack {
    public static void main(String[] args) {
        arrayStack arrayStack = new arrayStack(4);
        char key =' ';
        Scanner scanner = new Scanner(System.in);
        System.out.println("l:显示栈");
        System.out.println("push:添加元素");
        System.out.println("pop:获取元素");
        while (true){
            key = scanner.next().charAt(0);
            switch (key){
                case 'l':
                    System.out.println("显示队列元素");
                    arrayStack.list();
                    break;
                case 'p':
                    System.out.println("请输入一个元素");
                    arrayStack.push(scanner.nextInt());
                    break;
                case 'o':
                    System.out.println("获取队列中的元素");
                    try {
                        System.out.println(arrayStack.pop());
                    }catch (Exception e){
                        e.getMessage();
                    }
            }
        }
    }
}

class arrayStack{
    private int max;
    private int[] stack;
    private int top = -1;

    public arrayStack(int max){
        this.max = max;
        stack = new int[this.max];
    }

    public boolean isFull(){
        return top == max-1;
    }

    public boolean isEmpty(){
        return  top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }

    public int pop(){
        if(isEmpty()){
           throw new RuntimeException("栈空");
        }
        int temp =stack[top];
        top--;
        return temp;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈已空");
            return;
        }
        for (int i = top ; i >= 0 ; i--){
            System.out.println(stack[i]);
        }

    }

}