#include<bits/stdc++.h>
using namespace std;

vector<int> shortestPath(int V, vector<vector<int>> &edges, int src,int dest) {
    // adjacency list create
    vector<vector<int>>adj(V);
    for(int i=0;i<edges.size();i++){
        adj[edges[i][0]].push_back(edges[i][1]);
        adj[edges[i][1]].push_back(edges[i][0]);
    }
    
    // array dist
    vector<bool>visited(V,0);
    vector<int>parent(V,-1);    
    queue<int>q;
    q.push(src);
    visited[src]=1;
    while(!q.empty()){
        int node =q.front();
        q.pop();
        
        // Look at all the neigbours
        for(int j=0;j<adj[node].size();j++){
            if(visited[adj[node][j]])continue;
            visited[adj[node][j]]=1;
            parent[adj[node][j]]=node;
            q.push(adj[node][j]);
        }
    }
    vector<int>path;
    while(dest!=-1){
        path.push_back(dest);
        dest=parent[dest];
    }
    reverse(path.begin(),path.end());
    return path;
}

int main(){
    int V=9;
    vector<vector<int>>edges={{0,1},{0,2},{1,5},{2,4},{2,3},{3,4},{3,7},{4,8},{5,6},{6,8},{7,8}};
    int src=0;
    int dest=8;
    vector<int>dist=shortestPath(V,edges,src,dest);
    for(int i=0;i<dist.size();i++)
    cout<<dist[i]<<" ";
}