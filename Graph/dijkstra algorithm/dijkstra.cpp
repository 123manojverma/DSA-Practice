#include <bits/stdc++.h>
using namespace std;

vector<int> dijkstra(int V, vector<vector<int>> adj[], int S)
{
    vector<bool> Explored(V, 0);
    vector<int> dist(V, INT_MAX);
    dist[S] = 0;

    int count = V;
    while (count--)
    {
        int node = -1, value = INT_MAX;
        for (int i = 0; i < V; i++)
        {
            if (!Explored[i] && value > dist[i])
            {
                node = i;
                value = dist[i];
            }
        }

        Explored[node] = 1;
        for (int j = 0; j < adj[node].size(); j++)
        {
            int neighbour = adj[node][j][0];
            int weight = adj[node][j][1];
            if (!Explored[neighbour] && (dist[node] + weight < dist[neighbour]))
                dist[neighbour] = dist[node] + weight;
        }
    }
    return dist;
}

vector<int> dijkstra1(int V, vector<vector<int>> &edges, int src)
{

    vector<vector<pair<int, int>>> adj(V);

    for (auto &e : edges)
    {
        int u = e[0], v = e[1], w = e[2];
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    vector<int> dist(V, INT_MAX);
    dist[src] = 0;

    pq.push({0, src});

    while (!pq.empty())
    {
        pair<int, int> p = pq.top();
        pq.pop();
        int d = p.first;
        int node = p.second;

        if (d > dist[node])
            continue;

        for (auto &it : adj[node])
        {
            int neighbour = it.first;
            int weight = it.second;

            if (dist[node] + weight < dist[neighbour])
            {
                dist[neighbour] = dist[node] + weight;
                pq.push({dist[neighbour], neighbour});
            }
        }
    }

    return dist;
}

int main()
{
    // int V = 2, S = 0;
    // vector<vector<int>> adj[] = {{{1, 9}}, {{0, 9}}};
    // vector<int> res = dijkstra(V, adj, S);
    // for (int i = 0; i < res.size(); i++)
    // {
    //     cout << res[i] << " ";
    // }

    int V=3,src=2;
    vector<vector<int>>edges={{0,1,1},{1,2,3},{0,2,6}};
    vector<int>res=dijkstra1(V,edges,src);
    for(int i=0;i<res.size();i++){
        cout<<res[i]<<" ";
    }
}