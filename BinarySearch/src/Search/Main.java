package Search;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {1,8,10,89,999,1000,1000,1234};
//        int findIndex;
//        findIndex = BinarySearch(array,0,array.length - 1,1);
//        System.out.println(findIndex);
        List<Integer>resList = new ArrayList<Integer>();
        resList = BinarySearch2(array,0,array.length - 1,1000);
        System.out.println(resList);



    }

    /**
     *
     * @param arr 带查询数组
     * @param left 左侧索引
     * @param right 右侧索引
     * @param value 带查询的数
     * @return
     */
    public static int BinarySearch(int[]arr, int left, int right, int value){
        //用二分法查找需要一个有序数组
        //以及该数组的中间值
        int mid = (left + right)/2;
        int midValue = arr[mid];
        //需要使用recursion查询，当左侧大于右侧/右侧小于左侧时，退出递归
        if(left > right){
            return -1;
        }
        if(value > midValue){//右侧递归
            return BinarySearch(arr,mid + 1,right, value);
        }
        else if(value < midValue){//左侧递归
            return BinarySearch(arr,left,mid - 1,value);
        }
        else
        {//此时找到的数就是该索引
            return mid;
        }

    }

    public static List<Integer> BinarySearch2(int[]arr, int left,int right,int value){
        //用二分法查找需要一个有序数组
        //以及该数组的中间值
        int mid = (left + right)/2;
        int midValue = arr[mid];
        List<Integer> store_list = new ArrayList<Integer>();
        //需要使用recursion查询，当左侧大于右侧/右侧小于左侧时，退出递归
        if(left > right){
            return new ArrayList<>();
        }
        if(value > midValue){//右侧递归
            return BinarySearch2(arr,mid + 1,right, value);
        }
        else if(value < midValue){//左侧递归
            return BinarySearch2(arr,left,mid - 1,value);
        }
        else
        {//此时找到的数就是该索引
            //需要一个索引确定左侧是否遍历完全
            int temp = mid - 1;
            //向左遍历找到所有的index并存入Arraylist中
            while(true){
                if(temp < left){
                    break;
                }
                else if(arr[temp] != value){
                    temp--;
                }
                else{
                    store_list.add(temp);
                    temp--;
                }
            }
            //将目前找到的值放入数组中
            store_list.add(mid);
            //向右遍历找到所有的index并存入Arraylist 中
            temp = mid + 1;
            while(true){
                if(temp > right || arr[temp] != value){
                    break;
                }
                store_list.add(temp);
                temp++;
            }
//            while(true){
//                if(temp > right){
//                    break;
//                }
//                else if(arr[temp] != value){
//                    temp++;
//                }
//                else{
//                    store_list.add(temp);
//                    temp++;
//                }
//            }

        }
        return store_list;
    }


}
