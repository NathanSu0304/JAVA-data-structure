package stack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //test LL demo stack
        LLStack LLStackDemo = new LLStack();
        LLNode node1 = new LLNode(10);
        LLNode node2 = new LLNode(21);
        LLNode node3 = new LLNode(33);
        LLStackDemo.push(node1);
        LLStackDemo.push(node2);
        LLStackDemo.push(node3);
        LLStackDemo.print();
        System.out.println("pop之后～");
        LLStackDemo.pop();
        LLStackDemo.print();





	    /*ArrayStack arrayStackDemo = new ArrayStack(5);
        Scanner scanner = new Scanner(System.in);
        String key = "";
        boolean flag = true;

        while(flag){
            System.out.println("[show]显示菜单");
            System.out.println("[push]显示菜单");
            System.out.println("[pop]显示菜单");
            System.out.println("[exit]显示菜单");

            key = scanner.next();
            switch (key){
                case "show":
                    arrayStackDemo.print();
                    break;
                case"push":
                    System.out.println("请输入一个数据：");
                    int val = scanner.nextInt();
                    arrayStackDemo.push(val);
                    break;
                case "pop":
                    try{
                        int res = arrayStackDemo.pop();
                        System.out.printf("出栈的数据是%d\n",res);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    flag = false;
                    break;
            }
        }*/
        System.out.println("程序退出～");



    }
}
