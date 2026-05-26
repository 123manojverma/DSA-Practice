#include <bits/stdc++.h>
using namespace std;

void DFS(int node, vector<vector<int>> &adj, vector<bool> &visited)
{
    visited[node] = 1;
    for (int i = 0; i < adj[node].size(); i++)
    {
        if (!visited[adj[node][i]])
        {
            DFS(adj[node][i], adj, visited);
        }
    }
}

int isEulerCircuit(int V, vector<vector<int>> &adj)
{
    // Euler Circuit : 2
    // Calculate the Degree of each node
    // All node should have even degree
    // All non-zero degree node should be connected

    // Euler Path : 1
    // Calculate the Degree of each node
    // Zero or two node can have odd degree and remaining have even degree
    // All non-zero degree should be connected
    vector<bool> visited(V, 0);
    vector<int> degree(V, 0);
    int odd_Deg = 0;
    for (int i = 0; i < V; i++)
    {
        degree[i] = adj[i].size();
        if (degree[i] % 2)
            odd_Deg++;
    }
    if (odd_Deg != 2 && odd_Deg != 0)
        return 0;

    for (int i = 0; i < V; i++)
    {
        if (degree[i])
        {
            DFS(i, adj, visited);
            break;
        }
    }

    // If non-zero degree node is still not visited, return 0;

    for (int i = 0; i < V; i++)
    {
        if (degree[i] && !visited[i])
            return 0;
    }

    if (odd_Deg == 0)
        return 2;

    return 1;

    //  Time Complexity : O(V+E)
    // Space Complexity : O(V)
}

int main(){
    int V=3;
    vector<vector<int>>adj={{1,2},{0,2},{1,0}};
    cout<<isEulerCircuit(V,adj);
}