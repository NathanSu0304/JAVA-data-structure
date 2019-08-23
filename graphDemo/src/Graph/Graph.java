package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    //图中需要储存顶点 String ArrayList
    //需要二维数组储存边的关系
    //存变得数量
    private int numberOfEdges;
    //存顶点的集合
    private ArrayList<String> vertexList;
    //存边的
    private int [][]edges;
    //图的深度遍历，需要一个数组，记录顶点是否已经遍历
    private boolean[] isVisited;

    //构造器，需要告诉有几点顶点
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numberOfEdges = 0;
        isVisited = new boolean[n];
    }

    //添加顶点
    public void insertVertex(String s){
        vertexList.add(s);
    }
    //添加边
    /**
     *
     * @param V_index1 边中一个顶点对应的下标
     * @param V_index2 边中另一个顶点对应下标
     */
    public void insertEdges(int V_index1, int V_index2){
        edges[V_index1][V_index2] = 1;
        edges[V_index2][V_index1] = 1;
        numberOfEdges++;
    }
    //常见方法
    //返回边的个数
    public int getNumberOfEdges(){
        return numberOfEdges;
    }
    //返回结点的个数
    public int getNumberOfVertex(){
        return vertexList.size();
    }
    //传入结点对应的下标，返回对应的结点
    //0 ->"A" 1->"B"....
    public String getVertex(int i){
        return vertexList.get(i);
    }
    //返回顶点之间的权值
    /**
     *
     * @param i 第一个顶点对应下标
     * @param j 第二个顶点对应下标
     * @return 两点之间的权
     */
    public int getWeight(int i, int j){
        return edges[i][j];
    }
    //打印图对应的矩阵
    public void print(){
//        for(int[] vertex: edges){//二维数组第一次遍历，出一个一维数组
//            System.err.println(Arrays.toString(vertex));
//            System.out.println(Arrays.toString(vertex));
//        }
        for(int i = 0; i < edges[0].length; i++){
            for(int j = 0; j < edges[0].length;j++){
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }
    //图的dfs需要两个基础方法，1）根据传入的结点找到其第一个相连接的点
    //2）根据传入的点和第一个相连接的点，找到传入的点的第二个相连接的点
    //因为：第一个点，第二个点，recursion时候第二个点变成第一个点，如果下一个2号点不存在
    //需要返回上一个1号点，并找到1号点的下一个相连接结点
    //比如A-B A-C 但是B-C 没有连， A-B走完后，走B-C走不通，则通过A-C走到三号点

    //第一个基础方法，找到传入结点的第一个相连结点

    /**
     *
     * @param i 结点的下标
     * @return i 的第一个相连结点；-1 没有相连结点
     */
    public int getFirstNeighbour(int i){
        for(int j = 0; j< vertexList.size();j++){
            if(edges[i][j] > 0){//此时i,j 结点有相连
                return j;
            }
        }
        return -1;
    }

    /**
     *
     * @param v1 传入的第一个结点
     * @param v2 与v1相连的第一个结点
     * @return 与v1相连的第二个结点； -1 没找到
     */
    public int getNextNeighbour(int v1, int v2){
        for(int j = v2+1; j < vertexList.size();j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度遍历方法
    /**
     *
     * @param isVisited boolean 数组，记录顶点是否遍历
     * @param v 开始遍历的结点
     */
    private void dfs(boolean[] isVisited, int v){
        //先输出起始结点
        if(v == getNumberOfVertex() - 1){
            System.out.print(getVertex(v));
        }
        else{
            System.out.print(getVertex(v) + "->");
        }
        //将该结点标记为已经遍历
        isVisited[v] = true;
        //找到该结点的第一个相连结点
        int w = getFirstNeighbour(v);
        //先判断能不能找到w点，如果能找到
        //判断w是否标记已经遍历
        //如果没有标记，打印w,标记w,recursion w 变成1号点
        while(w != -1){//说明找到w点
            if(!isVisited[w]){//w没有标记，说明没走到w
                //recursion
                dfs(isVisited,w);
            }
            else{//w已经标记，说明该点走过了
                //此时需要走v 的第二个相连结点
                w = getNextNeighbour(v,w);
            }
        }
        //如果找不到w点，需要传入下一个v点；
        //所以我们需要一个方法，重塑dfs.遍历所有的v点
    }

    //dfs 的重塑
    public void dfs(){
        for(int i = 0; i < vertexList.size();i++){
            if(!isVisited[i]){//如果该点没有被访问过，就进去
                dfs(isVisited,i);
            }
        }
    }

}
