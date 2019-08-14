package BinaryTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1,2,3,4,5,6,7};
        //创建一个Array，并将这个Array放入binaryTree 中
        //创建一个方法，按照前序重新打印出这个Array
        //1，2，4，5，3，6，7
        arrBinaryTree arrBinaryTreeDemo = new arrBinaryTree(arr);
//        arrBinaryTreeDemo.preOrder();
        arrBinaryTreeDemo.postOrder();

    }
}
