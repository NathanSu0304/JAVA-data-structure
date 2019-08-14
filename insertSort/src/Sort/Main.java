package Sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Date date1 = new Date();
        DateFormat simpleDateForm = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dat1Str = simpleDateForm.format(date1);
        System.out.println(dat1Str);
        int[] array = new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 800000);
        }

        //int[] array = {6, -1, 11, 3, -5, 7};
        //System.out.println(Arrays.toString(array));
        //insertSort(array);
        insertSort2(array);

        Date date2 = new Date();
        String dat2Str = simpleDateForm.format(date2);
        System.out.println(dat2Str);

    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertValue = arr[i];
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //优化，判断是否需要重置
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertValue;
            }

            //System.out.println("第"+i+"次排序～");
            //System.out.println(Arrays.toString(arr));
        }
    }

    public static void insertSort(int[] arr) {
        //从数组的第二个元素起，依次和该元素之前的所有元素比较
        //若该元素比所比较元素大，则将该元素插入所比较元素的下一位
        //若该元素比所比较元素小，则所比较元素后移一位，index减1，继续比较。直到到头或着比所比较元素大

        //第一次排序
        int insertValue = arr[1];
        int insertIndex = 0;
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第一次排序～");
        System.out.println(Arrays.toString(arr));

        //第二次排序
        insertValue = arr[2];
        insertIndex = 1;

        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex + 1] = insertValue;
        System.out.println("第二次排序～");
        System.out.println(Arrays.toString(arr));
    }


}
