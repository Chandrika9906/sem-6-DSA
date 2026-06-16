import java.util.*;

class PrimsPair{
    int v, w;

    PrimsPair(int v, int w){
        this.v = v;
        this.w = w;
    }
}

public class Prims {
    static int vCnt;
    static List<List<PrimsPair>> adj = new ArrayList<>();

    Prims(int vCnt){
        this.vCnt = vCnt;
        for(int i=0; i<vCnt; i++)
            adj.add(new LinkedList<>());
    }

    void addEdge(int u, int v, int w){
        adj.get(u).add(new PrimsPair(v, w));
        adj.get(v).add(new PrimsPair(u, w));
    }

    void display(){
        for(int i=0; i<vCnt; i++){
            System.out.print(i+" -> ");
            for(PrimsPair p: adj.get(i))
                System.out.print("("+p.v+", "+p.w+")");
            System.out.println();
        }
    }

    void prims(){
        int arr[] = new int[vCnt], parent[] = new int[vCnt];
        boolean vis[] = new boolean[vCnt];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Random rm = new Random();
        int ver = rm.nextInt(vCnt);
        arr[ver] = 0;

        for(int i=0; i<vCnt; i++){
            int u = findMinVertex(arr, vis);
            vis[u] = true;

            for(PrimsPair p: adj.get(u)){
                int v = p.v;
                int w = p.w;

                if(vis[v]==false && w<arr[v]){
                    arr[v] = w;
                    parent[v] = u;
                }
            }
        }

        int res = 0;
        for(int i=0; i<vCnt; i++)
            res += arr[i];
        System.out.println("Minimum Cost: "+res);
    }

    int findMinVertex(int arr[], boolean vis[]){
        int min = Integer.MAX_VALUE, ver = -1;
        for(int i=0; i<vCnt; i++){
            if(vis[i]==false && arr[i]<min){
                min = arr[i];
                ver = i;
            }
        }

        return ver;
    }

    public static void main(String[] args) {
        Prims pr = new Prims(6);
        pr.addEdge(0, 1, 3);
        pr.addEdge(0, 2, 1);
        pr.addEdge(1, 3, 2);
        pr.addEdge(1, 4, 7);
        pr.addEdge(2, 5, 5);
        pr.addEdge(2, 3, 1);
        pr.addEdge(3, 5, 4);
        pr.addEdge(3, 4, 6);
        pr.display();
        pr.prims();
    }
}