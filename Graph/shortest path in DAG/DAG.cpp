#include<bits/stdc++.h>
using namespace std;

void DFS(int node,vector<pair<int,int>>adj[],stack<int>&st,vector<bool>&visited){
        visited[node]=1;
        for(int i=0;i<adj[node].size();i++){
            if(!visited[adj[node][i].first]){
                DFS(adj[node][i].first,adj,st,visited);
            }
        }
        st.push(node);
    }
    vector<int> shortestPath(int V, int E, vector<vector<int>>& edges) {
        // code here
        vector<pair<int,int>>adj[V];
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int weight=edges[i][2];
            adj[u].push_back(make_pair(v,weight));
        }
        
        // topological sort
        stack<int>st;
        vector<bool>visited(V,0);
        vector<int>dist(V,INT_MAX);
        dist[0]=0;
        DFS(0,adj,st,visited);
        while(!st.empty()){
            int node=st.top();
            st.pop();
            for(int i=0;i<adj[node].size();i++){
                int neighbour=adj[node][i].first;
                int weight=adj[node][i].second;
                dist[neighbour]=min(dist[neighbour],weight+dist[node]);
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==INT_MAX){
                dist[i]=-1;
            }
        }
        return dist;
    }

int main(){
    int V=4,E=2;
    vector<vector<int>>edges={{0,1,2},{0,2,1}};
    vector<int>dist=shortestPath(V,E,edges);
    for(int i=0;i<dist.size();i++){
        cout<<dist[i]<<" ";
    }
}