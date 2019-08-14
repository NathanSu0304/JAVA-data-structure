package Search;

import java.util.Arrays;

public class Main {

    public static int maxSize = 20;
    public static void main(String[] args) {
	// write your code here
        int[] array = {1,8,10,89,1000,1234};
        //System.out.println(Arrays.toString(f()));
        System.out.println(fibonacciSort(array,1));
        System.out.println(fibonacciSort(array,89));
        System.out.println(fibonacciSort(array,1234));
        System.out.println(fibonacciSort(array,124));
    }
    //构建一个Fibonacci sequence 以便在查找中可以使用Fibonacci 的值
    public static int[] f()
    {
        int[] f = new int[maxSize];
        //用for循环来构建fibonacci
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i< maxSize;i++)
        {
            f[i] = f[i-1]+ f[i-2];
        }
        return f;
    }
    //编写fibonacci 查找算法 如果不对应返回-1

    /**
     *
     * @param arr 带查找的数组
     * @param key 带查找的数值
     * @return 该数值所在位置
     */
    public static int fibonacciSort(int[]arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示fibonacci 中要用的那个数k的下标
        //那个对应k只需要满足f(k)-1大于等于目前的数组长度即可
        int mid = 0;//拆分数组所需要的中间位置
        int[] f = f();//获取fibonacci 数列以便调用其中的值
        while (f[k] <= high) {
            k++;
        }
        //创建一个新的数组，copy原数组的值，并将其长度扩展为f[k]
        //后加进来的位数，其数值为原来数组最后一位
        int[] temp = new int[f[k]];
        for (int i = 0; i < f[k]; i++) {
            if (i < high) {
                temp[i] = arr[i];
            } else {
                temp[i] = arr[high];
            }
        }
        while(low <= high)
        {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                //在数组左侧继续找
                high = mid - 1;
                k -= 1;
                //因为需要从数组左侧的数中在出一个中间值， 我们需要数组左侧中间值的个数，其对应的个数为f(k-1)
                //反复循环每次需要-1
            } else if (key > temp[mid]) {
                //在数组右侧继续找
                low = mid + 1;
                k -= 2;
            }
            else
            {
                //找到
                if(mid > high)
                {
                    return high;
                }
                else{
                    return mid;
                }


            }
        }
       //此时没找到
        return -1;
    }
}
