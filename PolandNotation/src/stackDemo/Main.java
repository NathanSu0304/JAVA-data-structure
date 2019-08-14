package stackDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main {
    //写一个方法将中缀表达式转换成后缀表达式
    //建立一个栈存运算符，一个ArrayList存最后结果
    /* 扫描中缀表达式，如果遇到数字，直接加入到list中
    * 如果遇到"（" 直接压入栈中
    * 如果遇到"）"需要将栈顶符号弹出，加入到list中，直到遇到"（" 循环结束 并将"（"弹出
    * 如果遇到符号，判断当前符号与栈顶符号，如果当前符号优先级高于栈顶符号，直接将符号压入栈
    * 如果当前符号优先级小于等于栈顶符号，需要将栈顶符号弹出，加入到LIST
    * 重复过程直到遇到"（" 或者栈为空
    *将栈中剩余元素依次弹出加入到list
    *[1,2,3,+,4,*,+,5,-]
    * */
    public static List<String> parseSuffixEp(List<String> ls){
        Stack<String>inSuffixStack = new Stack<String>();//符号栈
        List<String>inSuffixList = new ArrayList<String>();
        for(String item : ls){
            if(item.matches("\\d++")){
                inSuffixList.add(item);
            }
            else if(item.equals("(")){
                inSuffixStack.push(item);
            }
            else if(item.equals(")")){
                while(!inSuffixStack.peek().equals("(")){
                    inSuffixList.add(inSuffixStack.pop());
                }
                inSuffixStack.pop();
            }
            else{//判断是字符

                while(inSuffixStack.size() != 0 && operation.compare(inSuffixStack.peek()) >= operation.compare(item)){
                    inSuffixList.add(inSuffixStack.pop());
                }
                //将当前扫描的运算符押入栈
                inSuffixStack.push(item);
            }
        }
        while(inSuffixStack.size() != 0){
            inSuffixList.add(inSuffixStack.pop());
        }

        return inSuffixList;
    }












    //写一个方法实现字符串转成对应的List，即中缀表达式
    //1+((2+3)*4)-5 -> [1,+,(,(,2,+,3,),*,4,),-,5]
    public static List<String> getInfixEpList(String s) {
        //需要一个指针遍历表达式
        int index = 0;
        //需要一个字符串暂存数据
        String keepNum = "";
        //需要一个list存最后List
        List<String> resList = new ArrayList<String>();
        char ch = ' ';

        do {
            ch = s.charAt(index);
            if(ch > 57 ||ch < 48) {
                resList.add(ch + "");
                index++;
            }
            else{
                keepNum = keepNum + (ch +"");
                if(index != s.length() - 1 && s.charAt(index + 1) >= 48 && s.charAt(index + 1) <= 57) {
                    index++;
                }
                else{
                    resList.add(keepNum);
                    keepNum = "";
                    index++;
                }
            }
        }while(index < s.length());

        return resList;
    }







    public static void main(String[] args) {
        /*
	// write your code here
        //定义一个逆波兰表达式
        //（3+4）*5-6
        String suffixExpression = "3 4 + 5 * 6 -";
        //1。先将suffixExpression放入ArrayList
        //2。ArrayList传递给一个方法，配合栈完成计算
        List<String>ls = getListString(suffixExpression);
        int value = calculate(ls);
        System.out.println("(3+4)*5-6=" + value);*/

        System.out.println("测试getInfixEpList～");
        String expression = "(1+2)";
        String expression2 = "1+((2+3)*4)-5";
        List<String>infixList = new ArrayList<String>();
        infixList = getInfixEpList(expression2);
        System.out.println(infixList);
        System.out.println("测试parseSuffixEp～\n" + parseSuffixEp(infixList));


    }









    //将逆波兰表达式放入一个ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele:split){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    //遍历ArrayList
    public static int calculate(List<String>ls){
        Stack<String>stack = new Stack<>();
        int res = 0;
        for(String ele:ls){
            //使用正则表达式来取出数
            if(ele.matches("\\d+")){
                //入栈
                stack.push(ele);
            }
            else{
                int num1 = 0;
                int num2 = 0;
                switch (ele){
                    case"+":
                        num2 = Integer.parseInt(stack.pop());
                        num1 = Integer.parseInt(stack.pop());
                        res = num1 + num2;
                        stack.push(res + "");
                        break;
                    case"-":
                        num2 = Integer.parseInt(stack.pop());
                        num1 = Integer.parseInt(stack.pop());
                        res = num1 - num2;
                        stack.push(res + "");
                        break;
                    case"*":
                        num2 = Integer.parseInt(stack.pop());
                        num1 = Integer.parseInt(stack.pop());
                        res = num1 * num2;
                        stack.push(res + "");
                        break;
                    case"/":
                        num2 = Integer.parseInt(stack.pop());
                        num1 = Integer.parseInt(stack.pop());
                        res = num1 / num2;
                        stack.push(res + "");
                        break;
                    default:
                        throw new RuntimeException("运算符错误～");
                }
            }

        }
        return res;
    }

    public static List<String> toInFixExpressionList(String s){
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str = "";
        char c;
        do{
            //如果是非数字直接加入list
            if((s.charAt(i) < 48)||(s.charAt(i) > 57)){
                ls.add(s.charAt(i) + "");
                i++;
            }
            else {
                while(i < s.length() && s.charAt(i) >=48 && s.charAt(i) <=57){
                    str = str + (s.charAt(i) + "");
                    i++;
                }
                ls.add(str);
                str = "";
                i++;
            }

        }while(i < s.length());
        return ls;
    }



}