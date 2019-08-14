package Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[array.length];
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }


    }

    /**
     * @param arr   需要排序的数组
     * @param left  左半边的索引
     * @param mid   中间位置来判断左半边的结束和右半边的开始
     * @param right 右半边的索引的最后一位
     * @param temp  暂存数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//0
        mid = (left + right) / 2;
        int j = mid + 1;
        int t = 0;//这个索引用于移动temp中位置

        //将左半边或右半边的数完全写入到暂存数组中
        while (i <= mid && j <= right) {
            //哪个位置对应的数小，就把那个数写入到暂存数组中
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //将剩余半边的剩下的数写入到暂存数组中
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将暂存数组copy到原始数组中
        t = 0;//重置t copy temp中的值到array
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            templeft++;
            t++;
        }

    }
}
