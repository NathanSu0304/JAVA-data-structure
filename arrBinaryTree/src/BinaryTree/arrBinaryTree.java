package BinaryTree;

public class arrBinaryTree {
    //需要传入一个数组进行操作
    private int []arr;

    arrBinaryTree(int[] array){
        this.arr = array;
    }

    //overwrite preOrder
    public void preOrder(){
        preOrder(0);
    }
    public void postOrder(){
        postOrder(0);
    }
    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("带排序的Array是空～");
        }
        //按照前序的方式输出数组
        if(index < arr.length){
            System.out.println(arr[index]);
        }
        //判断左结点的index是否超过了排序数组的长度。如果没有就可以递归操作
        //左侧结点的index为 2* index + 1
        //右侧结点的index为 2* index + 2
        if(index * 2 + 1 < arr.length){
            preOrder(index * 2 + 1);
        }
        if(index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }
    public void postOrder(int index){
        if(index * 2 + 1 < arr.length){
            postOrder(index * 2 + 1);
        }
        if(index * 2 + 2 < arr.length){
            postOrder(index * 2 + 2);
        }
        if(index < arr.length){
            System.out.println(arr[index]);
        }

    }

}
