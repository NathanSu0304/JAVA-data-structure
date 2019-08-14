package BinaryTree;

//创建树的结点
//node 的值需要比较大小，所以需要使用comparable接口

public class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;
    Node(int val){
        this.value = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value - o.value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}

