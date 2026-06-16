import java.util.*;

class DijPair{
    int v, w;
    DijPair(int v, int w){
        this.v = v;
        this.w = w;
    }
}

public class DijkstraAlgo {
    static int vCnt;
    static List<List<DijPair>> adj = new ArrayList<>();
    DijkstraAlgo(int vCnt){
        this.vCnt = vCnt;
        for(int i=0; i<vCnt; i++)
            adj.add(new LinkedList<>());
    }

    void addEdge(int u, int v, int w){
        adj.get(u).add(new DijPair(v, w));
        adj.get(v).add(new DijPair(u, w));
    }

    void dijkstra(int srt){
        int dist[] = new int[vCnt], parent[] = new int[vCnt];
        boolean vis[] = new boolean[vCnt];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[srt] = 0;

        for(int i=0; i<vCnt; i++){
            int u = findMinVertex(dist, vis);
            vis[u] = true;

            for(DijPair pr: adj.get(u)){
                int v = pr.v;
                int w = pr.w;
                if(vis[u]==true && dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){ //relaxation
                    dist[v] = dist[u]+w;
                    parent[v] = u;
                }
            }
        }
        
        parent[srt] = -1;
        for(int i=0; i<vCnt; i++){
            System.out.print("Shortest Path from "+srt+" to "+i+" is ");
            printPath(parent, i, srt);
            System.err.println("| Shortest distance from "+srt+" to "+i+" is "+dist[i]);
        }
    }

    void printPath(int parent[], int v, int srt){
        if(parent[v]==-1){
            System.out.print(v+" ");
            return;
        }
        printPath(parent, parent[v], srt);
        System.out.print(v+" ");
    }

    int findMinVertex(int dist[], boolean vis[]){
        int min = Integer.MAX_VALUE, ver = -1;
        for(int i=0; i<vCnt; i++){
            if(vis[i] == false && dist[i]<min){
                min = dist[i];
                ver = i;
            }
        }
        return ver;
    }

    void display(){
        for(int i=0; i<vCnt; i++){
            System.out.print(i+" -> ");
            for(DijPair p: adj.get(i))
                System.out.print("("+p.v+", "+p.w+")");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DijkstraAlgo dj = new DijkstraAlgo(6);
        dj.addEdge(0, 1, 6);
        dj.addEdge(0, 2, 2);
        dj.addEdge(0, 4, 1);
        dj.addEdge(1, 2, 3);
        dj.addEdge(1, 4, 7);
        dj.addEdge(1, 5, 8);
        dj.addEdge(2, 3, 6);
        dj.addEdge(2, 4, 5);
        dj.addEdge(3, 4, 3);
        dj.addEdge(4, 5, 4);
        dj.display();
        dj.dijkstra(0);
    }
}