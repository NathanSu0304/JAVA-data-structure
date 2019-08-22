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
    //构造器，需要告诉有几点顶点
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numberOfEdges = 0;
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
        for(int[] vertex: edges){//二维数组第一次遍历，出一个一维数组
            System.err.println(Arrays.toString(vertex));
//            System.out.println(Arrays.toString(vertex));
        }
//        for(int i = 0; i < edges[0].length; i++){
//            for(int j = 0; j < edges[0].length;j++){
//                System.out.print(edges[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

}
