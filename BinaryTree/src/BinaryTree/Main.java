package BinaryTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");
        HeroNode heroNode6 = new HeroNode(6, "鲁智深");
        HeroNode heroNode7 = new HeroNode(7, "花融");

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        //先手动创建二叉树
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);
        heroNode4.setLeft(heroNode6);
        heroNode6.setRight(heroNode7);
        //测试前中后遍历
//        System.out.println("前序遍历～");//1234
//        binaryTree.preOrder();
//        System.out.println("中序遍历～");//2134
//        binaryTree.infixOrder();
//        System.out.println("后序遍历～");//2431
//        binaryTree.postOrder();
//        System.out.println("前序查找～");
//        System.out.println(binaryTree.preOrderSearch(5));
//        System.out.println("中序查找～");
//        System.out.println(binaryTree.infixOrderSearch(14));
//        System.out.println("后序查找～");
//        System.out.println(binaryTree.postOrderSearch(3));
        System.out.println("原始数组～");
//        binaryTree.preOrder();
//        System.out.println("删除后数组～");
//        binaryTree.delNode(3);
//        binaryTree.preOrder();
        binaryTree.preOrder();
        System.out.println("删除根结点～");
        binaryTree.delRoot(5);
        binaryTree.preOrder();

    }
}
