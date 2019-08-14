package Search;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[]array = {1,9,11,-1,34,89,11};
        List<Integer> store_list = new ArrayList<Integer>();
        seqSearch(array,11,store_list);
        System.out.println(store_list);

    }

    public static void seqSearch(int[] arr,int value,List<Integer>list){
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == value){
                list.add(i);
            }
        }
    }
}
