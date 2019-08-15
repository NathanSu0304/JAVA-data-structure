package AVLTree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[]array = {4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        for(int i = 0; i< array.length;i++){
            avlTree.add(new Node(array[i]));
        }
        avlTree.infixOrder();
        System.out.println("树的高度为：" + avlTree.getRoot().height());
        System.out.println("树的高度为：" + avlTree.getRoot().height2());

        System.out.println("树的左子树高度为：" + avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度为：" + avlTree.getRoot().rightHeight());

    }
}
