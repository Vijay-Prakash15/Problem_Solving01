package Graph;

import java.util.ArrayList;

class graph{
    int vertex;
    ArrayList<ArrayList<Integer>> adj;
    graph(int v){
        this.vertex = v;
        adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);  // for undirected graph
    }

    void printGraph(){
        for(int i=0;i<vertex;i++){
            System.out.print(i + " -> ");
            for(Integer j : adj.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}

public class RepresentationList {
    public static void main(String[] args){
        graph g = new graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.printGraph();

    }
}
