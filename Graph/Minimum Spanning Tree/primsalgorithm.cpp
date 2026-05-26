#include <bits/stdc++.h>
using namespace std;

int spanningTree(int V, vector<vector<int>> &edges)
{
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
    vector<bool> IsMST(V, 0);
    vector<int> parent(V);
    vector<vector<int>> adj[V];

    for (int i = 0; i < edges.size(); i++)
    {
        int u = edges[i][0];
        int v = edges[i][1];
        int wt = edges[i][2];
        adj[u].push_back({v, wt});
        adj[v].push_back({u, wt});
    }

    int cost = 0;

    pq.push({0, {0, -1}});

    while (!pq.empty())
    {
        int wt = pq.top().first;
        int node = pq.top().second.first;
        int par = pq.top().second.second;
        pq.pop();

        if (!IsMST[node])
        {
            IsMST[node] = 1;
            cost += wt;
            parent[node] = par;

            for (int i = 0; i < adj[node].size(); i++)
            {
                if (!IsMST[adj[node][i][0]])
                {
                    pq.push({adj[node][i][1], {adj[node][i][0], node}});
                }
            }
        }
    }
    return cost;
}

// Time Complexity : O(E logV)
// Space Complexity : O(V + E)

int main(){
    int V=3;
    vector<vector<int>>edges={{0,1,5},{1,2,3},{0,2,1}};
    cout<<spanningTree(V,edges);
}