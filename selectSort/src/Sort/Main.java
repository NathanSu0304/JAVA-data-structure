package Sort;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void seletSort(int[] arr) {
        //先找出Array中最小的数，之后和Array【0】互换位置
        //找出Array【1】到Array【n】中最小值，并和array【1】互换位置
        //依次类推
        //第一次互换
        int minIndex = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第一次互换～");
        System.out.println(Arrays.toString(arr));
        //第二次互换
        minIndex = 1;
        min = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第二次互换～");
        System.out.println(Arrays.toString(arr));


    }

    public static void selectSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.printf("第%d次排序后～\n", i + 1);
            //System.out.println(Arrays.toString(arr));
        }

    }


    public static void main(String[] args) {
        // write your code here
        //int[] array = {1, 3, -5, 9, -7,100,-123,0};
        int[]array = new int[80000];
        for(int i = 0; i< 80000;i++){
            array[i] = (int)(Math.random() * 80000);
        }

        Date date1 = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yy-mm-dd hh:mm:ss");
        String date1Str = dateFormat.format(date1);
        System.out.println(date1Str);


        //System.out.println(Arrays.toString(array));
        //seletSort(array);
        selectSort2(array);

        Date date2 = new Date();
        String date2Str = dateFormat.format(date2);
        System.out.println(date2Str);



    }
}
