package AVLTree;

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
    //二叉平衡树需要构建新的方法确定树的高度
    public int height(){
        return Math.max(this.left == null? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    //自己写的方法
    public int height2(){
        int h_l = 0, h_r = 0;
        if(left == null){
            h_l = 0;
        }
        else {
            h_l++;
            h_l = h_l + left.height2();
        }
        if(right == null){
            h_r = 1;
        }
        else {
            h_r++;
            h_r = h_r + right.height2();
        }
        return Math.max(h_l,h_r);
    }

    //AVL中获取左子树高度的方法
    //传入一个根结点，获得这个根结点左右子树的高度
    public int leftHeight(){
        if(this.left != null){
            return this.left.height();
        }
        return 0;
    }
    //AVL中获取右子树高度的方法
    public int rightHeight(){
        if(this.right != null){
            return this.right.height();
        }
        return 0;
    }
    //构建左旋转方法
    //如果左右子树高度差超过一，执行左旋转
    public void leftRotate(){
        //构建一个新结点，新结点的值为目前结点的值
        Node newNode = new Node(value);
        //将该结点的左子树给到新结点的左子树
        newNode.left = left;
        //将该结点的右子树的左子树给到新结点的右子树
        newNode.right = right.left;
        //将该结点的值置换成该结点右子结点的值
        value = right.value;
        //将该结点的右子树置换成右子树的右子树
        right = right.right;
        //将该结点的左子树置换成新结点
        left = newNode;
    }

    //构建右旋转方法
    public void rightRotate(){
        //创建一个新结点, 其值等于该结点的值
        Node newNode = new Node(value);
        //令新结点的右子树等于该结点的右子树
        newNode.right = right;
        //令新结点的左子树等于该结点的左子树的右子树
        newNode.left = left.right;
        //令该结点的值等于其左子结点的值
        value = left.value;
        //令该结点的左子树为其左子树的左子树
        left = left.left;
        //令该结点的右子树为新结点
        right = newNode;
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

        //判断是否需要左旋
        //如果右子树高度 - 左子树高度 > 1, 左旋
        if(rightHeight() - leftHeight() > 1){

            //如果该结点的右子树的左子树高度 > 该结点的右子树的右子树高度
            //先将该结点的右子树进行右旋
            if(right != null && right.leftHeight() > right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }
            else
            {
                leftRotate();
            }
            return;//!!!
        }
        //如果左子树高度 - 右子树高低  > 1, 右旋
        if(leftHeight() - rightHeight() > 1){
            //如果该结点的左子树的右子树高度 > 该结点的左子树的左子树高度
            //需要先将该结点的左子树进行左旋
            if(left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }
            else{
                rightRotate();
            }

        }
        return;//!!!
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
