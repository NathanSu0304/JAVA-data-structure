package Sort;

import java.util.Arrays;

public class Main {
    public static void shellSort(int[] arr) {
        //第一次排序
        //先将10个元素分成10/2 = 5组，每组两个元素
        //用转换法排列两个元素，从小到大
        int temp = 0;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j + 5];
                    arr[j + 5] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第一次排序～");
        System.out.println(Arrays.toString(arr));
        //第二次排序
        //将十个元素分成 5//2 = 2 组，每组五个元素，并从小到大排序
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j + 2];
                    arr[j + 2] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第二次排序～");
        System.out.println(Arrays.toString(arr));
        //第三次排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第三次排序～");
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort2(int[] arr) {
        int temp = 0;
        int count = 1;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println("第" + (count++) + "次排序～");
            System.out.println(Arrays.toString(arr));
        }
    }

    //用插入法替换转化法
    public static void shellSort3(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int index = i;
                if (arr[index] < arr[index - gap]) {
                    while (index - gap >= 0 && arr[index] < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = temp;
                }

            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] array2 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] array3 = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        System.out.println("原始数据～");
//        System.out.println(Arrays.toString(array));
//        System.out.println("shellsort～");
//        shellSort(array);
//        System.out.println("shellSort2～");
//        shellSort2(array2);
        System.out.println("shellSort3～");
        shellSort3(array3);
        System.out.println(Arrays.toString(array3));



    }
}
