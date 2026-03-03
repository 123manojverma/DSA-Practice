import java.util.*;

public class cycledetectiondirectedgraph {
    // Kahn's Algo
    public static boolean isCyclic(int V, int[][] edges) {
        int[] InDeg=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<edges.length;j++){
                if(edges[j][0]==i)
                InDeg[edges[j][1]]++;
            }
        }
        ArrayDeque<Integer>q=new ArrayDeque<>();
        int cnt=0;
        for(int i=0;i<V;i++){
            if(InDeg[i]==0){
                q.push(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.pop();
            cnt++;
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]==node){
                    InDeg[edges[i][1]]--;
                    if(InDeg[edges[i][1]]==0){
                        q.push(edges[i][1]);
                    }
                }
            }
        }
        return cnt!=V;
    }

    private static boolean DetectCycle(int node,int[][] edges,int[] path,boolean[] visited){
        path[node]=1;
        visited[node]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==node){
                if(path[edges[i][1]]==1)return true;
                if(!visited[edges[i][1]] && DetectCycle(edges[i][1],edges,path,visited)){
                    return true;
                }
            }
        }
        path[node]=0;
        return false;
    }
    
    public static boolean isCyclic1(int V, int[][] edges) {
        boolean[] visited=new boolean[V];
        int[] path=new int[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i] && DetectCycle(i,edges,path,visited))return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V=4;
        int[][] edges={{0,1},{0,2},{1,2},{2,3}};
        System.out.println(isCyclic(V, edges));
        System.out.println(isCyclic1(V, edges));
    }
}