#include <bits/stdc++.h>
using namespace std;

void DFS(int node, int parent, vector<vector<int>> &adj, vector<int> &disc, vector<int> &low, vector<bool> &visited, vector<vector<int>> &Bridges, int &count)
{
    disc[node] = low[node] = count;
    visited[node] = 1;
    for (int i = 0; i < adj[node].size(); i++)
    {
        int neigh = adj[node][i];
        if (neigh == parent)
            continue;
        else if (visited[neigh])
        {
            low[node] = min(low[node], low[neigh]);
        }
        else
        {
            count++;
            DFS(neigh, node, adj, disc, low, visited, Bridges, count);

            // Bridge exist or not
            if (low[neigh] > disc[node])
            {
                vector<int> temp;
                temp.push_back(node);
                temp.push_back(neigh);
                Bridges.push_back(temp);
            }
            low[node] = min(low[node], low[neigh]);
        }
    }
}

vector<vector<int>> criticalConnections(int n, vector<vector<int>> &connections)
{
    vector<vector<int>> adj(n);
    for (int i = 0; i < connections.size(); i++)
    {
        int u = connections[i][0];
        int v = connections[i][1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<vector<int>> Bridges;
    vector<int> disc(n); // discovery time
    vector<int> low(n);  // low time

    vector<bool> visited(n, 0);
    int count = 0;

    DFS(0, -1, adj, disc, low, visited, Bridges, count);

    return Bridges;
}

int main(){
    int n=4;
    vector<vector<int>>connections={{0,1},{1,2},{2,0},{1,3}};
    vector<vector<int>>bridges=criticalConnections(n,connections);
    for(int i=0;i<bridges.size();i++){
        cout<<bridges[i][0]<<" "<<bridges[i][1]<<endl; 
    }
}