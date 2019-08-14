package BinaryTree;

//创建英雄的结点
//因为是树，有left right 两个索引
public class HeroNode {
    private String name;
    private int id;
    private HeroNode left;
    private HeroNode right;

    //constructor
    HeroNode(int id, String name){
        this.name = name;
        this.id = id;
        //left right 默认为空
    }

    public void setLeft(HeroNode left){
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode getLeft() {
        return left;
    }
    public HeroNode getRight() {
        return right;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return "HeroNode [no=" + id + ",name=" + name + "]";
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);//先输出当前结点
        //递归向左子树
        if(this.left != null){
            this.left.preOrder();
        }
        //递归向右子数
        if(this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    //左->中->右
    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }
    //后续遍历
    //左->右->中
    public void postOrder(){
        if(this.left !=null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    //先判断当前结点是否是要找的结点，如果是，直接输出；如果不是，查找左子树
    //先判断左子树是否为空，如果不为空，左子树递归前序查找，如果找到返回该结点；如果没有找到，查找右子树
    //递归前序查找右子树，如果找到返回该结点，如果没有找到返回null

    public HeroNode preOrderSearch(int id){
        if(this.id == id){
            return this;
        }
        //需要一个空结点保留带回的返回值
        HeroNode res = null;
        if(this.left != null){
            res = this.left.preOrderSearch(id);
        }
        //判断左子树找没找到，如果找到返回该结点
        if(res != null){
            return res;
        }
        //如果左子树没有找到该结点，递归右子树
        if(this.right != null){
            res = this.right.preOrderSearch(id);
        }
        //最后不管找没找到都返回res
        return res;
    }
    //中序查找
    //先判断左子树是否为空，不为空则递归中序查找，如果在左子树中找到则返回
    //如果没有找到，怎判断当前结点是否是要查找的那个结点，如果是则返回该结点
    //如果不是则递归右子树
    public HeroNode infixOrderSearch(int id){
        //需要一个空结点保留最后找到的结点
        HeroNode res = null;
        if(this.left != null){
            res = this.left.infixOrderSearch(id);
        }
        if(res != null){
            return res;
        }
        if(this.id == id){
            return this;
        }
        if(this.right != null){
            res = this.right.infixOrderSearch(id);
        }
        return res;
    }

    //后续查找
    //递归 后续查找左子树，如果找到就返回； 如果没有找到，递归 后续查找 右子树
    //如果都没有找到，判断当前结点
    public HeroNode postOrderSearch(int id){
        HeroNode res = null;
        if(this.left != null){
            res = this.left.postOrderSearch(id);
        }
        if(res != null){
            return res;
        }
        if(this.right != null){
            res = this.right.postOrderSearch(id);
        }
        if(res != null){
            return res;
        }
        if(this.id == id){
            return this;
        }
        return null;
    }

    //删除一个结点
    //如果带删除的结点是叶子结点，则直接将其删除；如果带删除结点有叶子结点则将这个树删除
    //根据父结点判断其子结点
    public void delNode(int id){
        //判断左子结点是否是要找的，如果是将左边变成空
        if(this.left != null && this.left.getId() == id){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.getId() == id){
            this.right = null;
            return;
        }
        //如果左右结点不是要找的点，则在左结点下递归；找到，返回；找不到，右结点下递归
        if(this.left != null && this.left.getId() != id){
            this.left.delNode(id);
        }
        if(this.right != null && this.right.getId() !=id){
            this.right.delNode(id);
        }
    }

    //删除一个结点，规则如下
    //如果删除的结点是叶子结点则直接删除；如果删除的结点的是根结点
    //如果该根结点下只有一个叶子结点，则将该叶子结点挪到根结点位置
    //如果该根结点下有两个叶子结点，则将左子结点挪到根结点位置
    public void delRootNode(int id){
        if(this.left != null && this.left.getId() == id){
            if(this.left.left != null && this.left.right != null){
                HeroNode temp = this.left.right;
                this.left = this.left.left;
                this.left.right = temp;
            }
            else if(this.left.left == null && this.left.right == null){
                this.left = null;
            }
            else{
                if(this.left.left != null){
                    this.left = this.left.left;
                }
                if(this.left.right != null){
                    this.left = this.left.right;
                }
            }
        }
        if(this.right != null && this.right.getId() == id){
            if(this.right.left != null && this.right.right != null){
                HeroNode temp = this.right.right;
                this.right = this.right.left;
                this.right.right = temp;
            }
            else if(this.right.left == null && this.right.right == null){
                this.right = null;
            }
            else{
                if(this.right.left != null){
                    this.right = this.right.left;
                }
                if(this.right.right != null){
                    this.right = this.right.right;
                }
            }
        }
        if(this.left != null){
            this.left.delRootNode(id);
        }
        if(this.right != null){
            this.right.delRootNode(id);
        }

    }



}
