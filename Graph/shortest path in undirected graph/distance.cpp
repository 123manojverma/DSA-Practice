#include<bits/stdc++.h>
using namespace std;

vector<int> shortestPath(int V, vector<vector<int>> &edges, int src) {
    // adjacency list create
    vector<vector<int>>adj(V);
    for(int i=0;i<edges.size();i++){
        adj[edges[i][0]].push_back(edges[i][1]);
        adj[edges[i][1]].push_back(edges[i][0]);
    }
    
    // array dist
    vector<int>dist(V,-1);
    
    queue<int>q;
    q.push(src);
    dist[src]=0;
    while(!q.empty()){
        int node =q.front();
        q.pop();
        
        // Look at all the neigbours
        for(int j=0;j<adj[node].size();j++){
            if(dist[adj[node][j]]!=-1)continue;
            
            q.push(adj[node][j]);
            dist[adj[node][j]]=dist[node]+1;
        }
    }
    return dist;
}

int main(){
    int V=9;
    vector<vector<int>>edges={{0,1},{0,2},{1,5},{2,4},{2,3},{3,4},{3,7},{4,8},{5,6},{6,8},{7,8}};
    int src=0;
    vector<int>dist=shortestPath(V,edges,src);
    for(int i=0;i<dist.size();i++)
    cout<<dist[i]<<" ";
}