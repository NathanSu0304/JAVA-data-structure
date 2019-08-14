package stackDemo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //传入的表达式
        String expression = "7*2*2-5+1-5+3-4";//186
        //创建两个栈，一个是数盏，一个是符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //创建辅助参数
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        //创建型为整数的指针遍历 expression 表达式
        int index = 0;
        char temp = ' ';
        String keepNum = "";


        //使用integer.intphase()将字符串转换成数字
        while(true){
            temp = expression.substring(index,index + 1).charAt(0);
            if(!operStack.isOper(temp)){
                //此时temp是算式最后一位，就不需要验证下一位， 直接将这个数压入栈
                keepNum += temp;
                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }
                else{//验证temp下一位是否为数字，如果是数字存入keepNum，如果是操作符，将此时keepNum改成数字
                    //压入numStack
                    char ch = expression.substring(index + 1, index + 2).charAt(0);
                    if(operStack.isOper(ch)){
                        numStack.push(Integer.parseInt(keepNum));
                        System.out.printf("压入数盏的数为%d\n",Integer.parseInt(keepNum));
                        keepNum = "";
                    }

                }
                //numStack.push(temp - 48);//temp 是一个char， 需要-48 得到int
            }
            else{
                if(operStack.isEmpty()){
                    operStack.push(temp);

                }
                else{
                    if(operStack.priority(temp) <= operStack.priority(operStack.peek())){
                        num2 = numStack.pop();
                        num1 = numStack.pop();
                        oper = operStack.pop();
                        System.out.printf("num2 = %d\n",num2);
                        System.out.printf("num1 = %d\n",num1);
                        System.out.printf("oper = %d\n",oper);
                        res = numStack.cal(num1, num2, oper);
                        System.out.printf("res = %d\n",res);

                        numStack.push(res);
                        //运算后把当前操作符号押入符号栈
                        operStack.push(temp);
                    }
                    else{
                        //如果当前符号优先级大于栈中符号优先级直接押入栈
                        operStack.push(temp);

                    }
                }
            }
            index++;
            if(index >= expression.length()){
                break;
            }
        }
        while(!operStack.isEmpty()){
            num2 = numStack.pop();
            num1 = numStack.pop();
            oper = operStack.pop();
            System.out.println("test~\n");
            System.out.printf("num2 = %d\n",num2);
            System.out.printf("num1 = %d\n",num1);
            System.out.printf("oper = %d\n",oper);
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
            System.out.printf("res = %d\n",res);
        }
        System.out.printf("%s = %d",expression,numStack.pop());//13

    }
}
