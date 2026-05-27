#include <bits/stdc++.h>
using namespace std;

int findParent(int u, vector<int> &parent)
{
    if (u == parent[u])
        return u;

    return parent[u] = findParent(parent[u], parent);
}

void UnionByRank(int u, int v, vector<int> &parent, vector<int> &rank)
{
    int pu = findParent(u, parent);
    int pv = findParent(v, parent);

    if (rank[pu] > rank[pv])
    {
        parent[pv] = pu;
    }
    else if (rank[pu] < rank[pv])
    {
        parent[pu] = pv;
    }
    else
    {
        parent[pv] = pu;
        rank[pu]++;
    }
}

int spanningTree(int V, vector<vector<int>> &edges)
{
    // code here
    vector<int> parent(V);
    vector<int> rank(V, 0);
    for (int i = 0; i < V; i++)
    {
        parent[i] = i;
    }

    vector<pair<int, int>> adj[V];
    for (int i = 0; i < edges.size(); i++)
    {
        int u = edges[i][0];
        int v = edges[i][1];
        int wt = edges[i][2];
        adj[u].push_back({v, wt});
        adj[v].push_back({u, wt});
    }

    // priority queue
    // wt,u,v
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < adj[i].size(); j++)
        {
            pq.push({adj[i][j].second, {i, adj[i][j].first}});
        }
    }

    int cost = 0, edge = 0;
    while (!pq.empty())
    {
        int wt = pq.top().first;
        int u = pq.top().second.first;
        int v = pq.top().second.second;
        pq.pop();

        // check if they are in different set
        if (findParent(u, parent) != findParent(v, parent))
        {
            cost += wt;
            UnionByRank(u, v, parent, rank);
            edge++;
        }
        if (edge == V - 1)
            break;
    }
    return cost;
}

int spanningTree1(int V, vector<vector<int>> &edges)
{
    // code here
    vector<int> parent(V);
    vector<int> rank(V, 0);
    for (int i = 0; i < V; i++)
    {
        parent[i] = i;
    }

    vector<pair<int, int>> adj[V];
    for (int i = 0; i < edges.size(); i++)
    {
        int u = edges[i][0];
        int v = edges[i][1];
        int wt = edges[i][2];
        adj[u].push_back({v, wt});
        adj[v].push_back({u, wt});
    }

    vector<pair<int, pair<int, int>>> temp;
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < adj[i].size(); j++)
        {
            temp.push_back({adj[i][j].second, {i, adj[i][j].first}});
        }
    }
    // priority queue
    // wt,u,v
    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq(temp.begin(), temp.end());

    int cost = 0, edge = 0;
    while (!pq.empty())
    {
        int wt = pq.top().first;
        int u = pq.top().second.first;
        int v = pq.top().second.second;
        pq.pop();

        // check if they are in different set
        if (findParent(u, parent) != findParent(v, parent))
        {
            cost += wt;
            UnionByRank(u, v, parent, rank);
            edge++;
        }
        if (edge == V - 1)
            break;
    }
    return cost;
}

// Time Complexity : O(E logE)
// Space Complexity : O(V + E)

int main()
{
    int V = 3;
    vector<vector<int>> edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
    // cout << spanningTree(V, edges);
    cout << spanningTree1(V, edges);
}