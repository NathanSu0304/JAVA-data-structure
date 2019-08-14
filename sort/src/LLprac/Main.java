package LLprac;

public class Main {
    public static void testSort(){
        String[] input = {"i","hava","an","egg"};
        String[] expect = {"an","egg","hava","i"};

        Sort.sort(input);

        if(!java.util.Arrays.equals(input,expect)){
            System.out.println("There is something wrong~");
        }



    }


    public static void main(String[] args) {
	// write your code here
        testSort();
    }
}
