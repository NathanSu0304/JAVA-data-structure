package Graph;

public class Main {

    public static void main(String[] args) {
        System.out.println("测试一把～");
        int n = 8;//顶点个数
        //String vertexArray[] = {"A","B","C","D","E"};
        String vertexArray[] = {"1","2","3","4","5","6","7","8"};
	    Graph graph = new Graph(n);
	    for(String s: vertexArray){
	        graph.insertVertex(s);
        }
	    graph.print();
	    //添加边
        //A-B A-C B-D B-E B-C
//        System.out.println("添加后～");
//        graph.insertEdges(0,1);
//        graph.insertEdges(0,2);
//        graph.insertEdges(1,2);
//        graph.insertEdges(1,3);
//        graph.insertEdges(1,4);
//        System.out.println(graph.getNumberOfVertex());
        //测试案例
        graph.insertEdges(0,1);
        graph.insertEdges(0,2);
        graph.insertEdges(1,3);
        graph.insertEdges(1,4);
        graph.insertEdges(3,7);
        graph.insertEdges(4,7);
        graph.insertEdges(2,5);
        graph.insertEdges(2,6);
        graph.insertEdges(5,6);
        graph.print();
        System.out.println("深度优先算法～");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先算法～");
        graph.bfs();

    }
}
