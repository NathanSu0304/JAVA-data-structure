package BinaryTree;

//实现线索化功能的二叉树
public class ThreadedBinaryTree {
    private HeroNode root;
    private HeroNode pre = null;

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    //编写实现中序索引化的的方法
    //将某一个结点的前后指针重新指向.对node进行线索化

    /**
     *
     * @param node 传入的需要线索化的结点
     */

    public void threadedNode(HeroNode node){
        //判断空
        if(node == null){
            //System.out.println("不能线索化～");
            return;
        }
        //按照中序线索化，先线索化这个结点的左子树
        threadedNode(node.getLeft());
        //线索化当前结点
        if(node.getLeft() == null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if(pre != null && pre.getRight() == null){//pre != null
            pre.setRight(node);
            pre.setRightType(1);
        }

        //!!!!每处理一个结点后，后移一位，让当前结点是下一个结点的前驱结点！！！
        pre = node;

        //线索化当前结点的右子树
        threadedNode(node.getRight());
    }


    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if(root != null){
            root.preOrder();
        }
        else{
            System.out.println("当前二叉树为空无法遍历～");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        }
        else{
            System.out.println("当前二叉树为空无法遍历～");
        }
    }

    //后续遍历
    public void postOrder(){
        if(root != null){
            root.postOrder();
        }
        else{
            System.out.println("当前二叉树为空无法遍历～");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int id){
        HeroNode res = null;
        if(root != null){
            res = root.preOrderSearch(id);
        }
        return res;
    }
    //中序查找
    public HeroNode infixOrderSearch(int id){
        HeroNode res = null;
        if(root != null){
            res = root.infixOrderSearch(id);
        }
        return res;
    }

    //后续查找
    public HeroNode postOrderSearch(int id){
        HeroNode res = null;
        if(root != null){
            res = root.postOrderSearch(id);
        }
        return res;
    }
    //删除结点
    public void delNode(int id){
        if(root == null || root.getId() == id){
            root = null;
        }
        else{
            root.delNode(id);
        }
    }
    public void delRoot(int id){
        if(root.getId() != id){
            root.delRootNode(id);
        }
        else{
            root = null;
        }

    }



    //重载该方法
    public void threadedNode(){
        this.threadedNode(root);
    }

}
