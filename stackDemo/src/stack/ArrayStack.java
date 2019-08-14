package stack;

public class ArrayStack {
    //使用数组模拟栈
    private int maxSize;
    private int[] stack;
    private int top = -1;
    //constructor
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];//array的初始化
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
}
