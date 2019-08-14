package BinaryTree;

public class Main {

    public static void main(String[] args) {
        int[]array = {7,3,10,12,5,1,9,2};
        //遍历啊数组把它加入到一个树中
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i = 0; i< array.length;i++){
            Node temp = new Node(array[i]);
            binarySortTree.add(temp);
        }
        binarySortTree.infixOrder();
//        binarySortTree.add(new Node(2));

//        binarySortTree.infixOrder();
        System.out.println("删除后～");
        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);

//        int a = binarySortTree.testGetmin(new Node(3));//5
//        System.out.println(a);
//        int b = binarySortTree.testGetmin(new Node(10));//12
//        System.out.println(b);
//        binarySortTree.delNode(11);
        binarySortTree.infixOrder();
//        Node test = binarySortTree.testParent(10);
//        System.out.println(test);
//        System.out.println("root = " + binarySortTree.getRoot());

    }
}
