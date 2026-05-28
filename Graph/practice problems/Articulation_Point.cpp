#include <bits/stdc++.h>
using namespace std;

// Tarjan's Algorithm

void DFS(int node, int parent, vector<int> adj[], vector<bool> &visited, vector<int> &disc, vector<int> &low, vector<bool> &artpoint, int &timer)
{
    visited[node] = 1;
    int child = 0;
    disc[node] = low[node] = timer;
    for (int i = 0; i < adj[node].size(); i++)
    {
        int neigh = adj[node][i];
        if (neigh == parent)
            continue;
        else if (visited[neigh])
        {
            low[node] = min(low[node], disc[neigh]);
        }
        else
        {
            child++;
            timer++;
            DFS(neigh, node, adj, visited, disc, low, artpoint, timer);
            if (disc[node] <= low[neigh] && parent != -1)
            {
                artpoint[node] = 1;
            }
            low[node] = min(low[node], low[neigh]);
        }
    }
    if (child > 1 && parent == -1)
    {
        artpoint[node] = 1;
    }
}

vector<int> articulationPoints(int V, vector<int> adj[])
{
    // Code here
    vector<bool> artpoint(V, 0);
    vector<int> disc(V);
    vector<int> low(V);
    vector<bool> visited(V, 0);
    int timer = 0;
    DFS(0, -1, adj, visited, disc, low, artpoint, timer);

    vector<int> ans;
    for (int i = 0; i < V; i++)
    {
        if (artpoint[i])
        {
            ans.push_back(i);
        }
    }

    if (ans.size() == 0)
    {
        ans.push_back(-1);
    }
    return ans;
}

// Time Complexity : O(V+E)
// Space Complexity : O(V)

int main(){
    int V=5;
    vector<int>adj[]={{1},{0,4},{3,4},{2,4},{1,2,3}};
    vector<int>ans=articulationPoints(V,adj);
    for(int i=0;i<ans.size();i++){
        cout<<ans[i]<<" ";
    }
}