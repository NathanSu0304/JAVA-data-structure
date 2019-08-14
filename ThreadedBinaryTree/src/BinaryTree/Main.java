package BinaryTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(3, "吴用");
        HeroNode heroNode3 = new HeroNode(6, "卢俊义");
        HeroNode heroNode4 = new HeroNode(8, "林冲");
        HeroNode heroNode5 = new HeroNode(10, "关胜");
        HeroNode heroNode6 = new HeroNode(14, "鲁智深");
//        HeroNode heroNode7 = new HeroNode(7, "花融");
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);


        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNode();
        System.out.println(heroNode5.getLeft());
        System.out.println(heroNode5.getRight());



    }
}
