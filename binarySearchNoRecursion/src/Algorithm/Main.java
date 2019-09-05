package Algorithm;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[]arr ={1,3,8,10,11,67,100};
        int ans = binarySearch(arr,100);
        System.out.println("index = " + ans);//0
    }
    //二分查找非递归算法

    /**
     *
     * @param arr 带查找数组
     * @param target 目标数
     * @return 目标数下标， 如果没找到返回-1
     */
    public static int binarySearch(int[]arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){//向左查找
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
