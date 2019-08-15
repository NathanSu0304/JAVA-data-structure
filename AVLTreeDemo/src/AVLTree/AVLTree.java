package AVLTree;

public class AVLTree {
    //树需要一个根结点
    private Node root;

    public Node getRoot() {
        return root;
    }

    //add
    public void add(Node item){
        if(root == null){
            root = item;
        }
        else{
            root.add(item);
        }
    }
    //infixOrder 遍历
    public void infixOrder(){
        if(this.root == null){
            return;
        }
        else{
            this.root.infixOrder();
        }
    }

    //封装TargetNode 和ParentNode 方法
    public Node TargetNode(int value){
        if(root == null){
            return null;
        }
        else{
            return root.targetNode(value);
        }
    }
    public Node ParentNode(int value){
        if(root == null){
            return null;
        }
        else{
            return root.parentNode(value);
        }
    }

    //删除一个结点
    //1.需要删除的结点是叶子结点，
    //判断这个结点在父结点的左子树还是右子树，确定之后将该子树调成null
    //2.需要删除的结点有一个子树
    //先判断带删除结点在父结点的左子树上还是右子树上，
    //再判断需要删除的子树存留的子树是左子树还是右子树
    //将父结点的左/右子树调成存留的左/右子树
    //3.需要删除的结点有两个子树
    //option1，找到左子树中最大的结点，保留值，删除该结点，将需要删除的结点的值调成这个值
    //option2，找到右子树中最小的结点，保留值，删除该结点，将需要删除的结点的值调成这个值

    //构建删除方法
    public void delNode(int value){
        //删除的结点是叶子结点
        //找到该结点
        //找到该结点的父结点
        if(root == null){
            return;
        }
        if(root.contains(value)){
            Node targetNode = TargetNode(value);
            Node parentNode = ParentNode(value);
            //在查找父结点之前，考虑一个特殊情况，即树中只有根结点
            if(root.left == null && root.right == null){
                root = null;
                return;
            }
            if(targetNode.left == null && targetNode.right == null){
                //说明此结点为叶子结点
                if(parentNode.left != null && parentNode.left.value == value){
                    parentNode.left = null;
                }
                else if(parentNode.right != null && parentNode.right.value == value){
                    parentNode.right = null;
                }
            }
            else if(targetNode.left != null && targetNode.right != null)
            {
                //说明此时targetNode带有两个子树
                //找右子树最小的值，替换到TargetNode 的值
                int temp = getMin(targetNode.right);
                targetNode.value = temp;
            }
            else{
                //如果需要删除的结点有左子树
                if(targetNode.left != null){
                    if(parentNode != null){
                        //判断targetNode在parentNode的左还是右
                        if(parentNode.left.value == targetNode.value){
                            //在左
                            parentNode.left = targetNode.left;
                        }
                        else{
                            //在右
                            parentNode.right = targetNode.left;
                        }
                    }
                    else {
                        root = targetNode.left;
                    }

                }
                //如果需要删除的结点有右子树
                else {
                    if(parentNode != null){
                        if(parentNode.left.value == targetNode.value){
                            //在左
                            parentNode.left = targetNode.right;
                        }
                        else{
                            //在右
                            parentNode.right = targetNode.right;
                        }
                    }
                    else {
                        root = parentNode.right;
                    }

                }
            }
            //说明此时targetNode带有一个子树
            //先把targetNode中子树的值拿出来存放到temp中
//                int temp;
//                if(targetNode.left != null){
//                    temp = targetNode.left.value;
//                    delNode(temp);
//                    if(parentNode.left.value == value){
//                        //需要删除的结点在父子树的左侧，将父子树左子树的值调成temp
//                        parentNode.left.value = temp;
//                    }
//                    else if(parentNode.right.value == value){
//                        parentNode.right.value = temp;
//                    }
//                }
//                if(targetNode.right != null){
//                    temp = targetNode.right.value;
//                    delNode(temp);
//                    if(parentNode.left.value == value){
//                        //需要删除的结点在父子树的左侧，将父子树左子树的值调成temp
//                        parentNode.left.value = temp;
//                    }
//                    else if(parentNode.right.value == value){
//                        parentNode.right.value = temp;
//                    }
//                }
//            }
        }
        else{
            System.out.println("该结点不存在～");

        }

    }
    //构建一个方法找到右子树中最小的值
    //并删除最小值结点
    /**
     *
     * @param node 以node为根结点
     * @return 以node 为根结点的二叉树的最小值
     */
    public int getMin(Node node){
        int temp = 0;
        while(node.left != null){
            node = node.left;
        }
        temp = node.value;
        delNode(temp);
        return temp;
    }
}
