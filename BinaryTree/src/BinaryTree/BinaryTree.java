package BinaryTree;

//建立Binary Tree 需要要一个头结点
public class BinaryTree {
    private HeroNode root;

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


}
