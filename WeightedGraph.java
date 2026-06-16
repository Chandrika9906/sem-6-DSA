import java.util.*;

class Pair{
    int v, w;

    Pair(int v, int w){
        this.v = v;
        this.w = w;
    }
}

public class WeightedGraph {
    static int vCnt;
    static List<List<Pair>> adj = new ArrayList<>();
    WeightedGraph(int vCnt){
        this.vCnt = vCnt;
        for(int i=0; i<vCnt; i++)
            adj.add(new LinkedList<>());
    }

    void addEdge(int u, int v, int w){
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    void cnvrtToAdjList(int adjMat[][]){
        for(int i=0; i<vCnt; i++){
            for(int j=0; j<vCnt; j++){
                if(adjMat[i][j]!=0){
                    addEdge(i, j, adjMat[i][j]);
                    adjMat[i][j] = adjMat[j][i] = 0;
                }
            }
        }
    }

    void display(){
        for(int i=0; i<vCnt; i++){
            System.out.print(i+" -> ");
            for(Pair p: adj.get(i))
                System.out.print("("+p.v+", "+p.w+")");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedGraph wp = new WeightedGraph(5);
        wp.addEdge(0, 1, 5);
        wp.addEdge(0, 2, 2);
        wp.addEdge(1, 3, 1);
        wp.addEdge(1, 4, 4);
        wp.addEdge(2, 3, 6);
        wp.addEdge(3, 4, 6);
        int adjMat[][] = {{0, 5, 2, 0, 0},  //ver = 0
                          {5, 0, 0, 1, 4},  //ver = 1
                          {2, 0, 0, 6, 0},  //ver = 2
                          {0, 1, 6, 0, 3},  //ver = 3
                          {0, 4, 0, 3, 0}}; //ver = 4
        wp.cnvrtToAdjList(adjMat);
        wp.display();
    }
}