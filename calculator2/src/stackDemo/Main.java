package stackDemo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String expression = "3+2*6-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res =  0;
        int oper = 0;
        char ch = ' ';
        while(true){
            //依次得到每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        System.out.printf("num1 = %d\n",num1);
                        System.out.printf("num2 = %d\n",num2);
                        System.out.printf("oper = %d\n",oper);
                        res = numStack.cal(num1,num2,oper);
                        System.out.printf("result = %d\n",res);

                        numStack.push(res);
                        operStack.push(ch);

                        System.out.println("此时栈顶为～");
                        System.out.printf("numStack top = %d\n",numStack.peek());
                        System.out.printf("operStack top = %d\n",operStack.peek());
                    }
                    else{
                        operStack.push(ch);

                    }
                }
                else{//如果符号栈是空，直接压入
                    operStack.push(ch);
                    System.out.printf("此时符号栈为空，其中元素为 = %d\n",operStack.peek());

                }
            }
            else{//如果是数字直接压入栈
                numStack.push(ch - 48);
                System.out.printf("此时栈中元素 = %d\n",numStack.peek());

            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        while(true){
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("%s = %d\n",expression,numStack.pop());


    }
}
