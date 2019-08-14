package stackDemo;

public class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //constructor
    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//array的初始化
    }
    public int peek(){
        return stack[top];
    }
    public boolean isFull(){
        return top + 1 == maxSize;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int num){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空～");
        }
        int val = stack[top];
        top--;
        return val;
    }

    //打印栈
    public void print(){
        if(isEmpty()){
            System.out.println("栈空～");
        }
        //从栈顶开始打印
        for(int i = top; i > -1; i--){
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
    //返回运算符的优先级
    //假定数字越大优先级越高
    public int priority(int oper){
        if(oper == '+'|| oper == '-'){
            return 0;
        }
        else if(oper == '*'|| oper == '/'){
            return 1;
        }
        else{
            return -1;
        }
    }
    public boolean isOper(char val){
        return val == '+'|| val == '-'||val =='*'||val =='/';
    }
    //计算方法
    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
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
        }
        return res;
    }


}

