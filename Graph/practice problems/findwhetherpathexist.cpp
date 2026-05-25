#include <bits/stdc++.h>
using namespace std;

int row[4] = {1, -1, 0, 0};
int col[4] = {0, 0, 1, -1};

bool valid(int i, int j, int n)
{
    return i >= 0 && j >= 0 && i < n && j < n;
}

bool is_Possible(vector<vector<int>> &grid)
{
    queue<pair<int, int>> q;
    int n = grid.size();
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (grid[i][j] == 1)
            {
                q.push({i, j});
                grid[i][j] = 0;
                break;
            }
        }
    }
    while (!q.empty())
    {
        int i = q.front().first;
        int j = q.front().second;
        q.pop();
        for (int k = 0; k < 4; k++)
        {
            int newi = i + row[k];
            int newj = j + col[k];
            if (valid(newi, newj, n))
            {
                if (grid[newi][newj] == 2)
                    return 1;
                if (grid[newi][newj] == 3)
                {
                    grid[newi][newj] = 0;
                    q.push({newi, newj});
                }
            }
        }
    }
    return 0;
}

int main(){
    vector<vector<int>>grid={{3,0,3,0,0},{3,0,0,0,3},{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
    cout<<is_Possible(grid);
}