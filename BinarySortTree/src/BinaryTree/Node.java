package BinaryTree;

//构建树的结点
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    //构建一个add,加入一个结点
    public void add(Node item) {
        if (item.value < this.value) {
            //先判断this结点的左子树树否为空，如果为空直接加入
            //如果不为空，递归加入
            if (this.left == null) {
                this.left = item;
            } else {
                this.left.add(item);
            }
        } else {
            //先判断this结点的右子树是否为空，如果为空直接把item结点挂到右子树上
            //否则递归加入到右子树上
            if (this.right == null) {
                this.right = item;
            } else {
                this.right.add(item);
            }
        }
    }
    //构建一个中序遍历的方法
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    //删除一个结点需要找到这个需要删除的结点，和这个需要删除的结点的父结点
    //构建一个方法找到需要删除的结点

    /**
     *
     * @param value 带删除结点的值
     * @return 需要删除的结点
     */
    public Node targetNode(int value){
        if(this.value == value){
            return this;
        }
        if(value < this.value){
            if(this.left == null){//此时找不到了
                return null;
            }
            return this.left.targetNode(value);
        }
        else{
            if(this.right == null){
                return null;
            }
            return this.right.targetNode(value);
        }
    }

    /**
     *
     * @param value 需要查找的值
     * @return 需要查找的结点的父结点
     */
    //构建一个方法找到需要删除的结点的父结点
    public Node parentNode(int value){
        if(this.contains(value)){
            if(this.left != null && value < this.value){
                if(this.left.value == value){
                    return this;
                }
                return this.left.parentNode(value);
            }
            else if(this.right != null && value > this.value){
                if(this.right.value == value){
                    return this;
                }
                return this.right.parentNode(value);
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }

//        if((this.left != null && this.left.value == value) &&
//                (this.right != null && this.right.value == value)){
//            //此结点为父结点
//            return this;
//        }
//        else if(value < this.value && this.left != null){
//            //向左子树递归
//            return this.left.parentNode(value);
//        }
//        else if(value > this.value && this.right != null){
//            //向右子树递归
//            return this.right.parentNode(value);
//        }
//        else {
//            return null;
//        }

    }

    public Boolean contains(int value){
        if(this.value == value){
            return true;
        }
        else if(this.left != null && value < this.value){
            return this.left.contains(value);
        }
        else if(this.right != null && value >= this.value){
            return this.right.contains(value);
        }
        else{
            return false;
        }
    }
}
