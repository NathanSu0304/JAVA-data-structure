package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {


    public static void BubbleSort(int[] arr) {
        boolean flag = false;
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                //如果前面的数比后面的数大则改变顺序
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            //System.out.printf("第%d次排序后～\n", j + 1);
            //System.out.println(Arrays.toString(array));
            if (!flag) {
                break;
            } else {
                flag = true;
            }
        }

    }


    public static void main(String[] args) {
        int[] array2 = {3, 9, -1, 10, -2};
        BubbleSort(array2);
        //System.out.println(Arrays.toString(array2));


        //制造一个80000个数的数组，并观察排序所需的时间
        int[] test = new int[80000];
        for (int i = 0; i < 80000; i++) {
            test[i] = (int) (Math.random() * 800000);
        }


        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-mm-dd hh:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是～" + date1Str);

        BubbleSort(test);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是～" + date2Str);






        //array = {3,9,-1,10,-2} 用冒泡排序从小到大排序
        //优化算法，如果一次改变都没有发生，则可以退出
//        boolean flag = false;
//        int[] array2 = {3, 9, -1, 10, -2};
//        int[] array = {1, 2, 3, 4, 5};
//        int temp = 0;
//        for (int j = 0; j < array.length - 1; j++) {
//            for (int i = 0; i < array.length - 1 - j; i++) {
//                //如果前面的数比后面的数大则改变顺序
//                if (array[i] > array[i + 1]) {
//                    flag = true;
//                    temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                }
//            }
//            System.out.printf("第%d次排序后～\n", j + 1);
//            System.out.println(Arrays.toString(array));
//            if (!flag) {
//                break;
//            } else {
//                flag = true;
//            }
//        }
    }

}
