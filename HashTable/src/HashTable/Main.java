package HashTable;

import java.util.Scanner;

import static HashTable.HashTable.*;


public class Main {

    public static void main(String[] args) {
        //建立一个hashtable
        HashTable test = new HashTable();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员～");
            System.out.println("print: 打印雇员～");
            System.out.println("find: 查找雇员～");
            System.out.println("delete: 删除雇员～");
            System.out.println("exit: 退出程序～");
            input = scanner.next();
            switch (input){
                case "add":
                    System.out.println("输入ID");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");

                    String name = s.nextLine();
                    Employee emp = new Employee(name,id);
                    HashTable.add(emp);
                    break;
                case "print":
                    HashTable.print();
                    break;
                case"find":
                    System.out.println("输入需要查找的ID：");
                    int find_id = scanner.nextInt();
                    HashTable.find(find_id);
                    break;
                case"delete":
                    System.out.println("删除的ID：");
                    int delete_id = scanner.nextInt();
                    HashTable.delete(delete_id);
                    break;
                case"exit":
                    s.close();
                    scanner.close();
                    System.out.println("程序结束～");
                    break;
                default:
                    break;

            }
        }


    }
}
