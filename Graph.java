import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    static int v;
    static List<List<Integer>> adjList = new ArrayList<>();
    Graph(int v){
        this.v = v;
        for(int i=0; i<v; i++)
            adjList.add(new LinkedList<>());
    }

    void addEdge(int u, int v){  // this is undirected graph
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // void addEdge(int u, int v){  // this is directed graph
    //     adjList.get(u).add(v);
    // }

    void bfs(int srt){
        Queue<Integer> que = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[v];
        que.offer(srt); // add element inside the queue
        res.add(srt);
        vis[srt] = true;
        while(!que.isEmpty()) {
            int n = que.poll();
            for(int ver: adjList.get(n)){
                if(vis[ver]==false){
                    que.offer(ver);
                    res.add(ver);
                    vis[ver] = true;
                }
            }
        }

        System.out.println("BFS: "+res);
    }

    List<Integer> dfsHelper(int srt, boolean vis[], List<Integer> res){
        res.add(srt);
        vis[srt] = true;
        for(int n: adjList.get(srt)){
            if(vis[n]==false)
                dfsHelper(n, vis, res);
        }
        return res;
    }

    void dfs(int srt){
        boolean vis[] = new boolean[v];
        List<Integer> res = new ArrayList<>();
        dfsHelper(srt, vis, res);
        System.out.println("DFS: "+res);
    }

    void display(){
        for(int i=0; i<v; i++)
            System.out.println(i+"=>"+adjList.get(i));
    }

    public static void main(String[] args) {
        Graph gp = new Graph(7);
        gp.addEdge(0, 1);
        gp.addEdge(0, 2);
        gp.addEdge(1, 3);
        gp.addEdge(1, 6);
        gp.addEdge(2, 3);
        gp.addEdge(2, 5);
        gp.addEdge(3, 6);
        gp.addEdge(3, 5);
        gp.addEdge(4, 5);
        gp.display();
        gp.bfs(0);
        gp.dfs(0);
    }
}