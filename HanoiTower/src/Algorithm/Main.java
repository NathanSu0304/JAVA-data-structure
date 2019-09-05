package Algorithm;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("测试一下～");
        HanoiTower(5,'A','B','C');
        System.out.println(total);
    }
    //汉诺塔算法的分治实现
    public static int total = 0;
    /**
     *
     * @param num 一共有几个盘子
     * @param a 第一个塔
     * @param b 第二个塔
     * @param c 第三个塔
     */
    public static void HanoiTower(int num, char a, char b, char c){
        total++;
        //如果只有一个塔，直接将这个盘子从A塔移动到C塔
        //如果>1个盘子，需要将上面的盘子都移动到B塔， 将最后一个盘子移动到C塔， 再将B塔上的盘子移动到C塔
        if(num == 1){
            System.out.printf("第 %d 个盘子：从%c塔->%c塔",num,a,c);
            System.out.println();
        }
        else{
            //recursion, 将上面的盘子从A移动到B
            HanoiTower(num - 1,a,c,b);
            //将最下面的盘从A塔移动到C塔
            System.out.printf("第 %d 个盘子: 从%c塔->%c塔", num,a,c);
            System.out.println();
            //将B塔上的盘子移动到C塔
            HanoiTower(num-1,b,a,c);
        }

    }
}
