#include <iostream>
#include <vector>
using namespace std;

// Time Complexity :
// Worst case: V*E
// Best case: E

// Space Complexity: V

vector<int> bellmanFord(int V, vector<vector<int>> &edges, int src)
{
    vector<int> dist(V, 1e8);
    dist[src] = 0;
    int e = edges.size();
    for (int i = 0; i < V - 1; i++)
    {
        bool flag = 0;
        for (int j = 0; j < e; j++)
        {
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];

            if (dist[u] == 1e8)
                continue;

            if (dist[u] + w < dist[v])
            {
                flag = 1;
                dist[v] = dist[u] + w;
            }
        }
        if (!flag)
            return dist;
    }
    
    // Detect Cycle
    for (int j = 0; j < e; j++)
    {
        int u = edges[j][0];
        int v = edges[j][1];
        int w = edges[j][2];

        if (dist[u] == 1e8)
            continue;

        if (dist[u] + w < dist[v])
        {
            vector<int> ans;
            ans.push_back(-1);
            return ans;
        }
    }
    return dist;
}

int main()
{
    int V = 5;
    vector<vector<int>> edges = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
    int src = 0;
    vector<int> res = bellmanFord(V, edges, src);
    for (int i = 0; i < res.size(); i++)
    {
        cout << res[i] << " ";
    }
}