#include <bits/stdc++.h>
using namespace std;

void DFS(int node, vector<int> adj[], vector<bool> &visited)
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

int isCircle(vector<string> &arr)
{
    // adjacency list
    // a-z
    // a-0,b-1,..,z-25
    int n = arr.size();
    vector<int> adj[26];
    vector<int> InDeg(26, 0);
    vector<int> OutDeg(26, 0);
    for (int i = 0; i < n; i++)
    {
        string temp = arr[i];
        int u = temp[0] - 'a';
        int v = temp[temp.size() - 1] - 'a';
        adj[u].push_back(v);
        OutDeg[u]++;
        InDeg[v]++;
    }

    // Eulerian circuit
    // Find Indegree and OutDegree

    for (int i = 0; i < 26; i++)
    {
        if (InDeg[i] != OutDeg[i])
            return 0;
    }

    // ALl the edges are part of one component
    // All the non zero degree node(InDegree or OutDegree), they should be part of single component
    
    vector<bool> visited(26, 0);
    DFS(arr[0][0] - 'a', adj, visited);

    for (int i = 0; i < 26; i++)
    {
        if (!visited[i] && InDeg[i])
            return 0;
    }

    return 1;
}

// Time Complexity : O(N)
// Space Complexity : O(N)

int main(){
    vector<string>arr={"abc","bcd","cdf"};
    cout<<isCircle(arr);
}