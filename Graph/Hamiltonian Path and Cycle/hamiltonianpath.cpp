#include <bits/stdc++.h>
using namespace std;

bool DFS(int node, vector<vector<int>> &adj, vector<bool> &visited, int &count, int n)
{
    visited[node] = 1;
    count++;
    if (count == n)
        return 1;
    for (int i = 0; i < adj[node].size(); i++)
    {
        if (!visited[adj[node][i]] && DFS(adj[node][i], adj, visited, count, n))
        {
            return 1;
        }
    }
    count--;
    visited[node] = 0;
    return 0;
}

bool check(int n, int m, vector<vector<int>> edges)
{
    vector<vector<int>> adj(n);
    for (int i = 0; i < m; i++)
    {
        adj[edges[i][0] - 1].push_back(edges[i][1] - 1);
        adj[edges[i][1] - 1].push_back(edges[i][0] - 1);
    }

    vector<bool> visited(n, 0);
    int count = 0;
    for (int i = 0; i < n; i++)
        if (DFS(i, adj, visited, count, n))
            return 1;
    return 0;
}

// Time Complexity : O(n!)
// Space Complexity : O(n + m)

int main(){
    int n=4,m=4;
    vector<vector<int>>edges={{1,2},{2,3},{3,4},{2,4}};
    cout<<check(n,m,edges);
}