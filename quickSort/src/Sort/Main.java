package Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = {-9, 78, 21, 0, 23, -567, 70, -10};
        int[] array2 = {7, -8, 9, -4, 11, 3};
        int[] array3 = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 19};
//        System.out.println("原始数据～");
//        System.out.println(Arrays.toString(array3));
//        quickSort(array3, 0, array3.length - 1);
//        System.out.println("排序后～");
//        System.out.println(Arrays.toString(array3));

        System.out.println("原始数据～");
        System.out.println(Arrays.toString(array));
        quickSort2(array, 0, array.length - 1);
        System.out.println("排序后～");
        System.out.println(Arrays.toString(array));
    }

    //将最左面的元素定义为pivot
    public static void quickSort(int[] arr, int left, int right) {
        int i, j, temp;
        int t;
        i = left; //0
        j = right; //arr.length - 1
        if (i > j) {
            return;
        }
        temp = arr[left];
        while (i < j) {
            //从j起找一个小于temp的元素
            while (arr[j] >= temp && i < j) {
                j--;
            }
            //从i起找一个大于temp的元素
            while (arr[i] <= temp && i < j) {
                i++;
            }
            //将找到的两个元素互换位置
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }


        }

        //将pivot换到此时i/j所在的位置
        arr[left] = arr[i];
        arr[i] = temp;

        //互换后此时i/j左侧全是小于pivot的数，右侧都是大于pivot的数
        //递归将左侧排序
        quickSort(arr, left, j - 1);
        //递归将右侧排序
        quickSort(arr, j + 1, right);
    }

    //将中间位置的元素为pivot
    public static void quickSort2(int[] arr, int left, int right) {
        int i, j, pivot, mid;
        int temp;
        i = left;//0
        j = right;//arr.length - 1
        mid = (i + j) / 2;
        pivot = arr[mid];//中间位置元素
        if (i > j) {
            return;
        }
        while (i < j) {
            //在pivot左侧找一个比pivot大的元素
            //在pivot右侧找一个比pivot小的元素
            //互换这两个元素位置
            while (i < mid && arr[i] < pivot) {
                i++;
            }
            while (j > mid && arr[j] > pivot) {
                j--;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
        System.out.println(i + " "+ j);
        if (i == j) {
            i += 1;
            j -= 1;
        }
        System.out.println(i + " "+ j);
        if (left < j) {
            quickSort2(arr, left, mid - 1);
        }
        if (right > i) {
            quickSort2(arr, mid + 1, right);
        }


    }

}