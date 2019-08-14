package recursion;

public class Main {

    //定义Max共有多少个皇后
    static int total = 0;
    int Max = 8;
    //定义一个数组保存最后结果
    int[] array = new int[Max];
    //写一个方法打印出皇后摆放的位置
    private void print(){
        for(int i = 0; i < Max;i++){//array.length
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //查看皇后位置是否冲突,两个皇后不能在同一行，不能在同一列，不能在同一斜线

    /**
     *
     * @param 传入的第n个皇后
     * @return true/false
     */
    private boolean judge(int n){
        for(int i = 0; i < n; i++){//检测n之前摆放的元素
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //编写一个方法放置第n个皇后
    //需要用recussion回溯，如果n满足条件，则检测n+1，直到8个皇后全部放置
    private void check(int n){
        if(n == Max){
            print();
            total++;
            return;
        }
        //依次放入皇后并判断是否冲突
        for(int i = 0; i < Max; i++){
            //先把皇后放到该行的第一列
            array[n] = i;
            //判断放置皇后在第一列时是否冲突
            if(judge(n)){
                check(n+1);
            }
            //如果冲突，将该皇后放置到i+1的位置
        }
    }
    public static void main(String[] args) {
	// write your code here
        Main test = new Main();
        test.check(0);
        System.out.println();
        System.out.println(total);
    }


}
