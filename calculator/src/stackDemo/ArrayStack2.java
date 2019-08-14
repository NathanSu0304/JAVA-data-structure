package stackDemo;

public class ArrayStack2 {
    //使用数组模拟栈
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //constructor
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//array的初始化
    }

    public boolean isFull() {
        return top + 1 == maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空～");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //打印栈
    public void print() {
        if (isEmpty()) {
            System.out.println("栈空～");
        }
        //从栈顶开始打印
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级
    //优先级使用数字表示，数字越大优先级越高
    public int priority(int operator) {
        if (operator == '+' || operator == '-') {
            return 0;
        } else if (operator == '*' || operator == '/') {
            return 1;
        }
        else{
            return -1;//假定计算式只有加减乘除
        }
    }
    //判断是不是运算符号
    public boolean isOper(char input){
       return input == '+'||input =='-'||input =='*'||input =='/';
    }
    //计算方法
    public int cal(int num1, int num2, int opr){//先进的数是num1, 后进的数是num2
        int res = 0;
        /*switch (opr){
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
                res = num2 / num2;
                break;
        }
        return res;*/
        if(opr == '+'){
            res = num1 + num2;
        }
        else if(opr == '-'){
            res = num1 - num2;
        }
        else if(opr == '*'){
            res = num1 * num2;
        }
        else if(opr == '/'){
            res = num1/num2;
        }
        return res;
    }
    //peek 返回栈顶
    public int peek(){
        return stack[top];
    }

}