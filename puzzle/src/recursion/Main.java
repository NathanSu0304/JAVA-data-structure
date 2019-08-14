package recursion;

public class Main {
    //写一个方法来判断路径

    /**
     *
     * @param map 传入的地图
     * @param i 开始的横坐标位置
     * @param j 开始的纵坐标位置
     * @return 如果路径通则返回true
     */
    public static boolean setWay(int[][]map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }
        else{
            //️下->右->️左->️上
            if(map[i][j] == 0){//该点没有走过，
                map[i][j] = 2;
                if(setWay(map,i+1,j)){
                    return true;
                }
                else if(setWay(map,i,j+1)){
                    return true;
                }
                else if(setWay(map,i-1,j)){
                    return true;
                }
                else if(setWay(map,i-1,j)){
                    return true;
                }
                else{
                    map[i][j] = 3;//该点走不通
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        //用二维数组创建 8行 *7列 的map
        int[][] map = new int[8][7];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7;j++){
                map[i][j] = 0;
            }
        }
        for(int i = 0;i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for(int i = 0; i < 7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][4] = 1;
        map[3][5] = 1;
        System.out.println("打印地图～");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("测试函数～");

        setWay(map,1,1);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
