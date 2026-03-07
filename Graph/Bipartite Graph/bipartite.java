import java.util.*;

public class bipartite {

    // BFS approach without converting to adj list
    // T.C. -> O(V x E)
    // S.C. -> O(V)
    public boolean isBipartite(int V, int[][] edges) {
        int[] color=new int[V];
        Arrays.fill(color,-1);
        ArrayDeque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                q.push(i);
                color[i]=0;
                while(!q.isEmpty()){
                    int node=q.pop();
                    for(int j=0;j<edges.length;j++){
                        if(edges[j][0]==node){
                            if(color[edges[j][1]]==-1){
                                color[edges[j][1]]=(color[node]+1)%2;
                                q.offer(edges[j][1]);
                            }else{
                                if(color[edges[j][1]]==color[node]){
                                    return false;
                                }
                            }
                        }
                        else if(edges[j][1]==node){
                            if(color[edges[j][0]]==-1){
                                color[edges[j][0]]=(color[node]+1)%2;
                                q.offer(edges[j][0]);
                            }else{
                                if(color[edges[j][0]]==color[node]){
                                    return false;
                                }
                            }
                        }
                    }  
                }
            }
        }
        return true;
    }

    // BFS approach with adj list
    // T.C. -> O(V+E)
    // S.C. -> O(V+E)
    public boolean isBipartite1(int V, int[][] edges) {
        int[] color=new int[V];
        Arrays.fill(color,-1);
        ArrayDeque<Integer>q=new ArrayDeque<>();
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                q.push(i);
                color[i]=0;
                while(!q.isEmpty()){
                    int node=q.pop();
                    for(int j=0;j<adj.get(node).size();j++){
                        if(color[adj.get(node).get(j)]==-1){
                            color[adj.get(node).get(j)]=(color[node]+1)%2;
                            q.offer(adj.get(node).get(j));
                        }else if(color[adj.get(node).get(j)]==color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // DFS approach
    // T.C. -> O(V+E)
    // S.C. -> O(V+E)
    public boolean IsBip(int node,List<List<Integer>>adj,int[] color){
        for(int i=0;i<adj.get(node).size();i++){
            if(color[adj.get(node).get(i)]==-1){
                color[adj.get(node).get(i)]=(color[node]+1)%2;
                if(!IsBip(adj.get(node).get(i),adj,color))return false;
            }else if(color[adj.get(node).get(i)]==color[node]){
                return false;
            }
        }
        return true;
    }
    
    public boolean isBipartite2(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] color=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!IsBip(i,adj,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}
