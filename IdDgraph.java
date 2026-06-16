//public DIRECT AND INDIRECT GRAPH

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IdDgraph {
    static int v;
    static List<List<Integer>> adjList = new ArrayList<>();
    IdDgraph(int v){
        this.v = v;
        for(int i=0; i<v; i++)
            adjList.add(new LinkedList<>());
    }

    // void addEdge(int u, int v){  // this is undirected graph
    //     adjList.get(u).add(v);
    //     adjList.get(v).add(u);
    // }

    void addEdge(int u, int v){  // this is directed graph
        adjList.get(u).add(v);
    }

    void display(){
        for(int i=0; i<v; i++)
            System.out.println(i+"=>"+adjList.get(i));
    }

    public static void main(String[] args) {
        IdDgraph gp = new IdDgraph(5);
        gp.addEdge(0, 1);
        gp.addEdge(0, 2);
        gp.addEdge(0, 3);
        gp.addEdge(1, 2);
        gp.addEdge(1, 3);
        gp.addEdge(2, 3);
        gp.addEdge(2, 4);
        gp.addEdge(3, 4);
        gp.display();
    }
}
    

