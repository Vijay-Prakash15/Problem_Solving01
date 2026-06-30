package Graph;

class graph{
    int[][] matrix;
    int vertex;
    graph(int vertex){
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int u, int v){
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    public void printGraph(){
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class RepresentationMatrix {
    public static void main(String[] args){
        graph g = new graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
    }
}
