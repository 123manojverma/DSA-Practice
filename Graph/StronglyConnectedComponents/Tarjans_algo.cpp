#include <bits/stdc++.h>
using namespace std;

void DFS(int node, vector<vector<int>> &adj, vector<bool> &visited, vector<int> &disc, vector<int> &low, stack<int> &s, vector<bool> &InStack, vector<vector<int>> &ans, int &timer)
{
    visited[node] = 1;
    disc[node] = low[node] = timer;
    s.push(node);
    InStack[node] = 1;

    for (int i = 0; i < adj[node].size(); i++)
    {
        int neigh = adj[node][i];
        if (!visited[neigh])
        {
            timer++;
            DFS(neigh, adj, visited, disc, low, s, InStack, ans, timer);
            low[node] = min(low[node], low[neigh]);
        }
        else
        {
            // if it is present in stack or not
            if (InStack[neigh])
                low[node] = min(low[node], disc[neigh]);
        }
    }

    if (disc[node] == low[node])
    {
        vector<int> temp;
        while (!s.empty() && s.top() != node)
        {
            temp.push_back(s.top());
            InStack[s.top()] = 0;
            s.pop();
        }
        temp.push_back(node);
        InStack[node] = 0;
        s.pop();
        sort(temp.begin(), temp.end());

        ans.push_back(temp);
    }
}

vector<vector<int>> tarjans(int V, vector<vector<int>> &adj)
{
    vector<vector<int>> ans;
    vector<int> disc(V);
    vector<int> low(V);
    vector<bool> visited(V, 0);
    stack<int> s;
    vector<bool> InStack(V, 0);
    int timer = 0;

    for (int i = 0; i < V; i++)
        if (!visited[i])
            DFS(i, adj, visited, disc, low, s, InStack, ans, timer);

    sort(ans.begin(), ans.end());

    return ans;
}

// Time Complexity : O(V+E)
// Space Complexity : O(V)

int main(){
    int V=6;
    vector<vector<int>>adj={{1}, {2}, {0, 3}, {4}, {3, 5}, {}};
    vector<vector<int>>ans=tarjans(V,adj);
    for(int i=0;i<ans.size();i++){
        for(int j=0;j<ans[i].size();j++){
            cout<<ans[i][j]<<" ";
        }
        cout<<endl;
    }
}