package Search;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        //System.out.println(Arrays.toString(array));
        int resIndex = insertValueSearch(array,0,array.length - 1,-9);
        System.out.println(resIndex);
    }

    /**
     * @param arr   带排序数组
     * @param left  左侧索引
     * @param right 右侧索引
     * @param value 带查找值
     * @return 若找到返回查找值所在的index
     *          若没找到返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int value) {
        if(left > right|| value < arr[left] || value > arr[right]){
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if(value > midValue){
            return insertValueSearch(arr,mid + 1,right, value);
        }
        else if(value < midValue){
            return insertValueSearch(arr,left,mid -1,value);
        }
        else{//此时找到了
            return mid;
        }

    }
}
