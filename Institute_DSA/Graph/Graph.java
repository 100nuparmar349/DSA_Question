
import java.util.*;;

public class Graph{
    static class Edge{
        int src,dest;
        Edge(int src,int d){
            this.src=src;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
            
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
    public static void BFS(ArrayList<Edge>graph[],int v){
        boolean[] vis=new boolean[v];
        Queue<Integer>q=new LinkedList<>(); // ArrayDeque.
        q.add(4);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                vis[curr]=true;
                System.out.println(curr+" ");
                for(Edge e:graph[curr]){
                    if(!vis[e.dest])q.add(e.dest);
                }
            }

        }
    }
    public static void DFS(ArrayList<Edge>graph[],int curr,boolean[] vis ){
        
        if(vis[curr]){
            return;
        }
        vis[curr]=true;
        System.out.println(curr);
        for(Edge e:graph[curr]){
            if(!vis[e.dest])DFS(graph, e.dest, vis);

        }
    }
    
    public static void printAllpath(ArrayList<Edge>graph[],int curr,int v,String ans){
        
    }
    public static void main(String[] args) {

        System.out.println("Hello");
        int v=5;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph,v);
        //  BFS(graph,v);
        // System.out.println();
        // DFS(graph,4,new boolean[v]);
        boolean[] vis=new boolean[v];
        vis[0]=true;
        printAllpath(graph,0,4,vis,"0");

    }
}