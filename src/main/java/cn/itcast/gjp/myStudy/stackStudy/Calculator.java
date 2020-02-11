package cn.itcast.gjp.myStudy.stackStudy;

public class Calculator {
    public static void main(String[] args) {
        String expression = "11+8*3+100";
        arrayStackCal numStackCal = new arrayStackCal(10);
        arrayStackCal operStackCal = new arrayStackCal(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        String keepNum = "";


        while (true) {
            char ch = expression.substring(index, index + 1).charAt(0);
            if (operStackCal.isOper(ch)) {
                if (!operStackCal.isEmpty()) {
                    if (operStackCal.priority(ch) <= operStackCal.priority(operStackCal.peek())) {
                        num1 = numStackCal.pop();
                        num2 = numStackCal.pop();
                        oper = operStackCal.pop();
                        int cal = numStackCal.cal(num1, num2, oper);
                        numStackCal.push(cal);
                        operStackCal.push(ch);
                    } else {
                        operStackCal.push(ch);
                    }
                } else {
                    operStackCal.push(ch);
                }
            } else {
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStackCal.push(Integer.parseInt(keepNum));
                } else {
                    char temp = expression.substring(index + 1, index + 2).charAt(0);
                    if (operStackCal.isOper(temp)) {
                        numStackCal.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
                index++;
                if (index >= expression.length()) {
                    break;
                }

            }
            while (true) {
                if (operStackCal.isEmpty()) {
                    break;
                }
                num1 = numStackCal.pop();
                num2 = numStackCal.pop();
                oper = operStackCal.pop();
                res = numStackCal.cal(num1, num2, oper);
                numStackCal.push(res);
            }
            System.out.printf("表达式%s=%d", expression, res);
        }
    }


    class arrayStackCal {
        private int max;
        private int[] stack;
        private int top = -1;

        public arrayStackCal(int max) {
            this.max = max;
            stack = new int[this.max];
        }

        public int peek() {
            return stack[top];
        }

        public boolean isFull() {
            return top == max - 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("栈满");
                return;
            }
            top++;
            stack[top] = value;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈空");
            }
            int temp = stack[top];
            top--;
            return temp;
        }


        public void list() {
            if (isEmpty()) {
                System.out.println("栈已空");
                return;
            }
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }

        public int priority(int oper) {
            if (oper == '*' || oper == '/') {
                return 1;
            } else if (oper == '+' || oper == '-') {
                return 0;
            } else {
                return -1;
            }
        }

        public boolean isOper(char val) {
            return val == '*' || val == '/' || val == '+' || val == '-';
        }


        public int cal(int num1, int num2, int oper) {
            int res = 0;
            switch (oper) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
                default:
                    break;
            }
            return res;
        }
    }


