package Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //将这个数组用堆排序的方法降序排列
        int[]array = {4,6,8,5,9};
        int[]array2 = {4,6,8,5,9,1,3,10,7,-1,80,2};
        adjustHeap(array2,3,9);

        SortHeap(array2);
        System.out.println(Arrays.toString(array2));


    }
    public static void SortHeap(int[]arr){
        int temp = 0;
        System.out.println("开始堆排序～");
        for(int j = arr.length/2 - 1; j >= 0; j--){
            adjustHeap(arr,j,arr.length);
        }
        //现在出一个大顶堆顺序的数组
        //将大顶堆第0位即最大的那个数，置换到末尾
        //重复操作length-1次，直到获得一个从小到大的数组
        for(int i = arr.length - 1; i > 0;i--){
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //用大顶堆的方法重新找到数组中的最大数
            //开始调整的位置是从0开始
            adjustHeap(arr,0,i);
        }
    }

    //设置堆排序方法，使一个小树可以成 堆
    //note：如果升序排列，用大顶堆排序
    //如果降序排列用小顶堆

    /**
     *
     * @param arr 需要排序的数组
     * @param i 第一个非叶子结点的index
     * @param length 整个数组的长度，这个值应该逐渐减少1
     */
    //第一次：调整6，5，9这个小树，使其满足大堆的形式，最大的数在根结点的位置->9,6,5
    public static void adjustHeap(int[] arr, int i ,int length){
        //先保留根结点位置的值
        int temp = arr[i];
        //比较其左右子树的值，并获取左右子树中最大的值，以左子树为基准开始比较
        //用for循环，假设左子树下仍有小树需要操作，实际上，堆排序是从最下面的非叶子结点开始
        //一直找到最底层的非叶子结点
        //第二轮for，一定会退出
        for(int k = 2*i + 1; k < length; k = 2*k + 1){
            //获取最大值的k
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            //将找到的最大值和定点值进行比较,如果比定点值大，进行交换
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;//!!!!!
                arr[i] = temp;
            }
            else {
                break;
            }
        }
//        arr[i] = temp;
    }

}
