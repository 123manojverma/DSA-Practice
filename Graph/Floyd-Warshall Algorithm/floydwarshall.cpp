#include <bits/stdc++.h>
using namespace std;

// Time Complexity : O(V^3)

// Space Complexity: O(1)

void floydWarshall(vector<vector<int>> &dist)
{
    int n = dist.size();
    for (int k = 0; k < n; k++)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dist[i][k] == 1e8 || dist[k][j] == 1e8)
                    continue;
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
}

int main(){
    vector<vector<int>>dist={{0, -1, 2}, {1, 0, 100000000}, {3, 1, 0}};
    floydWarshall(dist);
    for(int i=0;i<dist.size();i++){
        for(int j=0;j<dist.size();j++){
            cout<<dist[i][j]<<" ";
        }
        cout<<endl;
    }
}