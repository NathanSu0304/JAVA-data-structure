package BinaryTree;

//huffman tree中的node 需要有对应字节和出现的次数
//huffman tree 需要比较权的大小
public class Node implements Comparable<Node>{
    Byte data;//用Byte存放数据本书 'a' -> 97 ascii
    int weight;//权代表字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    //写一个前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
    @Override
    //从小到大排序
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
