package Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] array = {53, 3, 542, 748, 14, 214};
        radixSort2(array);

    }

    public static void radixSort2(int[] arr) {
        //得到数组中最大数的位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElement = new int[10];

        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //拿到元素每位并放入桶中
                int digitOfEle = arr[j]/n % 10;
                //放入到对应桶中
                bucket[digitOfEle][bucketElement[digitOfEle]] = arr[j];
                bucketElement[digitOfEle]++;
            }
            //按照桶的顺序将桶中数字依次取出，放入到原数组
            int index = 0;
            //遍历每一个桶，并将桶中数据放入到原数组
            for (int i = 0; i < bucket.length; i++) {
                //如果桶中有数据就把数据写入原数组
                if (bucketElement[i] != 0) {
                    //说明次桶中有数，遍历该桶，将数据放入原数组
                    for (int j = 0; j < bucketElement[i]; j++) {
                        //取出元素放入到arr 中
                        arr[index] = bucket[i][j];
                        index++;
                    }
                }
                //第一轮处理后需要将bucketElement[i] == 0
                bucketElement[i] = 0;
            }
            System.out.println("第" + (m+1)+"轮排序～");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void radixSort(int[] arr) {
        //第一轮排序
        //针对每个元素的个位进行排序处理

        //定义一个二维数组，表示10个桶，每个桶代表一个二维数组
        //说明：为了防止放入数的时候数据溢出，则每个一位数组大小定为arr.length
        //基数排序是使用空间换时间的算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，定义一个一位数组来记录每个桶放入数据的个数
        //bucketElement[0] 表示0号桶放入数据的个数
        int[] bucketElement = new int[10];

        //第一轮把数据放入
        for (int j = 0; j < arr.length; j++) {
            //拿到元素个位并放入桶中
            int digitOfEle = arr[j] % 10;
            //放入到对应桶中
            bucket[digitOfEle][bucketElement[digitOfEle]] = arr[j];
            bucketElement[digitOfEle]++;
        }
        //按照桶的顺序将桶中数字依次取出，放入到原数组
        int index = 0;
        //遍历每一个桶，并将桶中数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中有数据就把数据写入原数组
            if (bucketElement[i] != 0) {
                //说明次桶中有数，遍历该桶，将数据放入原数组
                for (int j = 0; j < bucketElement[i]; j++) {
                    //取出元素放入到arr 中
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            //第一轮处理后需要将bucketElement[i] == 0
            bucketElement[i] = 0;
        }
        System.out.println("对各位的排序处理～");
        System.out.println(Arrays.toString(arr));

        System.out.println("第二轮的处理～");
        //第二轮把数据放入
        for (int j = 0; j < arr.length; j++) {
            //拿到元素个位并放入桶中
            int digitOfEle = arr[j] / 10 % 10;
            //放入到对应桶中
            bucket[digitOfEle][bucketElement[digitOfEle]] = arr[j];
            bucketElement[digitOfEle]++;
        }
        //按照桶的顺序将桶中数字依次取出，放入到原数组
        index = 0;
        //遍历每一个桶，并将桶中数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中有数据就把数据写入原数组
            if (bucketElement[i] != 0) {
                //说明次桶中有数，遍历该桶，将数据放入原数组
                for (int j = 0; j < bucketElement[i]; j++) {
                    //取出元素放入到arr 中
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElement[i] = 0;//将记录每桶有多少数的array置空
        }
        System.out.println("对十位的排序处理～");
        System.out.println(Arrays.toString(arr));
        //===============
        System.out.println("第三轮的处理～");
        //第三轮把数据放入
        for (int j = 0; j < arr.length; j++) {
            //拿到元素百位并放入桶中
            int digitOfEle = arr[j] / 100 % 10;
            //放入到对应桶中
            bucket[digitOfEle][bucketElement[digitOfEle]] = arr[j];
            bucketElement[digitOfEle]++;
        }
        //按照桶的顺序将桶中数字依次取出，放入到原数组
        index = 0;
        //遍历每一个桶，并将桶中数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            //如果桶中有数据就把数据写入原数组
            if (bucketElement[i] != 0) {
                //说明次桶中有数，遍历该桶，将数据放入原数组
                for (int j = 0; j < bucketElement[i]; j++) {
                    //取出元素放入到arr 中
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
        }
        System.out.println("对百位的排序处理～");
        System.out.println(Arrays.toString(arr));
    }

}
