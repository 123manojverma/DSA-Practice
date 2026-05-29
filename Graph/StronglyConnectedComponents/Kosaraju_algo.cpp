#include<bits/stdc++.h>
using namespace std;

void Topological(int node,vector<vector<int>>&adj,vector<bool>&visited,stack<int>&s){
    visited[node]=1;

    // look at its all neighbour
    for(int i=0;i<adj[node].size();i++){
        if(!visited[adj[node][i]])
        Topological(adj[node][i],adj,visited,s);
    }
    s.push(node);
}

void DFS(int node,vector<vector<int>>&adj2,vector<bool>&visited){
    visited[node]=1;
    for(int i=0;i<adj2[node].size();i++){
        if(!visited[adj2[node][i]])
        DFS(adj2[node][i],adj2,visited);
    }
}

int kosaraju(int V,vector<vector<int>>&adj){
    // Topological sort
    stack<int>s;
    vector<bool>visited(V,0);

    for(int i=0;i<V;i++){
        if(!visited[i]){
            Topological(i,adj,visited,s);
        }
    }
    // Reverse the edges / Transpose the graph

    vector<vector<int>>adj2(V);

    for(int i=0;i<V;i++)
    for(int j=0;j<adj[i].size();j++){
        int u=i;
        int v=adj[i][j];
        adj2[v].push_back(u);
    }
    // pop the element from stack
    // if the popped node is not visited yet
    // SCC++
    // DFS

    for(int i=0;i<V;i++) visited[i]=0;

    int SCC=0;
    
    while(!s.empty()){
        int node=s.top();
        s.pop();
        if(!visited[node]){
            SCC++;
            DFS(node,adj2,visited);
        }
    }
    return SCC;
}

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)

int main(){
    int V=5;
    vector<vector<int>>adj={{2,3},{0},{},{4},{}};
    cout<<kosaraju(V,adj);
}