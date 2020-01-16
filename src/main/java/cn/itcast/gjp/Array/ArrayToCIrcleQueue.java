package cn.itcast.gjp.Array;

import java.util.Scanner;

public class ArrayToCIrcleQueue {
    public static void main(String[] args) {
        ArrayToQueue queue = new ArrayToQueue(3);
        char key =' ';
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("s:显示队列");
            System.out.println("a:添加元素");
            System.out.println("g:获取元素");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    System.out.println("显示队列元素");
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个元素");
                    queue.add(scanner.next());
                    break;
                case 'g':
                    System.out.println("获取队列中的元素");
                    queue.get();

            }
        }
    }
}
       class ArrayToQueue {
        public int front;
        public int rear;
        public int maxsize;
        public Object[] arr;

        public ArrayToQueue(int maxsize) {
            this.maxsize = maxsize;
            arr = new Object[maxsize];
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return (rear + 1) % maxsize == front;
        }

        public void add(Object element) {
            if (isFull()) {
                System.out.println("队列已满不能添加");
            } else {
                arr[rear] = element;
                rear = (rear + 1) % maxsize;
            }
        }

        public Object get() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不可以取数据");
            } else {
                Object tem = arr[front];
                front = (front+1)%maxsize;
                return tem;
            }
        }

        public void show() {
            for (int i = front; i <front+((rear + maxsize - front) % maxsize); i++){
                System.out.println(arr[i]);
            }
        }
    }


