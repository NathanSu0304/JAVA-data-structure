package Graph;

public class Main {

    public static void main(String[] args) {
        System.out.println("测试一把～");
        int n = 5;//顶点个数
        String vertexArray[] = {"A","B","C","D","E"};
	    Graph graph = new Graph(n);
	    for(String s: vertexArray){
	        graph.insertVertex(s);
        }
	    graph.print();
	    //添加边
        //A-B A-C B-D B-E B-C
        System.out.println("添加后～");
        graph.insertEdges(0,1);
        graph.insertEdges(0,2);
        graph.insertEdges(1,2);
        graph.insertEdges(1,3);
        graph.insertEdges(1,4);
        graph.print();

    }
}
