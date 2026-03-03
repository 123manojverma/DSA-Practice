import java.util.*;

public class topologicalsort{
    // Kahn's Algo
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer>res=new ArrayList<>();
        int[] InDeg=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<edges.length;j++){
                if(edges[j][0]==i){
                    InDeg[edges[j][1]]++;
                }
            }
        }
        ArrayDeque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(InDeg[i]==0){
                q.push(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.pop();
            res.add(node);
            for(int i=0;i<edges.length;i++){
                if(edges[i][0]==node){
                    InDeg[edges[i][1]]--;
                    if(InDeg[edges[i][1]]==0){
                        q.push(edges[i][1]);
                    }
                }
            }
        }
        return res;
    }

    // using stack
    public static void DFS(int[][] edges,int node,Stack<Integer>st,boolean[] visited){
        if(visited[node])return;
        visited[node]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==node){
                DFS(edges,edges[i][1],st,visited);                
            }
        }
        st.push(node);
    }
    public static ArrayList<Integer> topoSort1(int V, int[][] edges) {
        boolean[] visited=new boolean[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                DFS(edges,i,st,visited);
            }
        }
        ArrayList<Integer>res=new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }

    public static void main(String[] args){
        int V=6;
        int[][] edges={{1,3},{2,3},{4,1},{4,0},{5,0},{5,2}};
        System.out.println(topoSort1(V,edges).toString());
        System.out.println(topoSort(V,edges).toString());
    }
}