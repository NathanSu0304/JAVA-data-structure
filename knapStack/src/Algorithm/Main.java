package Algorithm;

//背包的最优解问题
//背包容量为4磅，放入不重复物品 吉他1磅，价值1500；音响4磅，价值3000；电脑3磅，价值2000
//问如何不重复放置使背包总价值最高
//动态分析，设置背包容量从1磅到4磅
//设置二维数组，v[i][j] 代表此时背包价值； j 表示背包重量，i 表示物品数
//w[i]代表物品重量
//将二维数组的第一行和第一列初始化为0，目的是方便后续计数物品数，从1开始
//公式：
//v[i][0] = v[0][j] = 0
//w[i] > j, v[i][j] = v[i-1][j]
//w[i] < j, v[i][j] = max{v[i-1][j],v[i]+v[i-1][j-w[i]]}
public class Main {

    public static void main(String[] args) {
        int n = 3;//代表有3种物品
        int m = 4;//代表背包最大承重4磅
        int[]w ={1,4,3};
        int[]val = {1500,3000,2000};
        int[][]v = new int[n+1][m+1];
        //记录放入商品的情况，定义一个二维数组
        int[][] path = new int[n+1][m+1];



        //初始化二维数组，让第一行第一列都是0
        for(int i = 0; i < v.length;i++){
            //第一列设成0
            v[i][0] = 0;
        }
        for(int j = 0; j < v[0].length;j++){
            //第一行设成0
            v[0][j] = 0;
        }
        //根据公式将最优解数值放入二维数组
        //从第一行第一列开始放入，忽略第0行第0列
        for(int i = 1; i < v.length;i++){
            for(int j = 1; j< v[0].length;j++){
                if(w[i-1] > j){
                    v[i][j] = v[i-1][j];
                }
                else if(w[i-1] <= j){
                    //因为i从1开始，因此公式需要调整
                    //v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]])
                    //v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        //记录这种情况
                        //这种情况是最优解
                        path[i][j] = 1;
                    }
                    else{
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
        //打印二维数组
        for(int i = 0; i< v.length;i++){
            for(int j = 0; j < v[0].length;j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //打印背包中存放的物品
        //从后往前遍历path数组，确定path[i][j] = 1 的情况
        //打印最后的一组path[i][j] = 1即可
        int i = path.length - 1;
        int j = path[0].length - 1;
        while(i > 0 && j > 0){
            if(path[i][j] == 1){
                System.out.printf("第%d个物品被放入背包～\n",i);
                j -= w[i-1];
            }
            i--;
        }
    }
}
