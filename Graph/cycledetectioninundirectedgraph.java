public class cycledetectioninundirectedgraph {
    public static boolean DetectCycle(int[][] edges,int node,int parent,boolean[] visited){
        visited[node]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==node){
                if(!visited[edges[i][1]]){
                    if(DetectCycle(edges,edges[i][1],node,visited)){
                        return true;
                    }
                }else if(parent!=edges[i][1])
                return true;
            }else if(edges[i][1]==node){
                if(!visited[edges[i][0]]){
                    if(DetectCycle(edges,edges[i][0],node,visited)){
                        return true;
                    }
                }else if(parent!=edges[i][0])
                return true;
            }
        }
        return false;
    }
    public static boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(DetectCycle(edges,i,-1,visited))
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=4;
        int[][] edges={{0,1},{0,2},{1,2},{2,3}};
        System.out.println(isCycle(V,edges));
    }
}
