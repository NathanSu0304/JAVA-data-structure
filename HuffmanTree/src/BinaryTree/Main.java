package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int array [] = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(array);
        preOrder(root);


    }
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }
        else
        {
            System.out.println("这是一个空树～");
        }
    }
    //创建Huffman Tree的方法

    /**
     *
     * @param arr 需要变成Huffman的数组
     * @return Huffman树的头结点
     */
    public static Node createHuffmanTree(int arr[]){
        //遍历数组，把数组中每个值放到Node中，并把Node存在list中，方便操作
        List<Node> nodes = new ArrayList<Node>();
        for(int value:arr){
            nodes.add(new Node(value));
        }
        //按顺序从小到大排列
        Collections.sort(nodes);

        System.out.println(nodes);
        //将最小的两个数取出，求和，生成一个新的Node，存放进List中
        //删除那两个最小的数
        //重排List
        while(nodes.size() > 1){
            Node parent = new Node(nodes.get(0).value + nodes.get(1).value);
            parent.left = nodes.get(0);
            parent.right = nodes.get(1);

            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
            Collections.sort(nodes);

            System.out.println("第一次排序后～");
            System.out.println(nodes);
        }
        return nodes.get(0);
    }
}
