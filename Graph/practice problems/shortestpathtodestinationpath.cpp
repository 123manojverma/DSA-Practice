#include <bits/stdc++.h>
using namespace std;

int row[4] = {1, -1, 0, 0};
int col[4] = {0, 0, 1, -1};

bool valid(int i, int j, int n, int m)
{
    return i >= 0 && j >= 0 && i < n && j < m;
}

int shortestDistance(int N, int M, vector<vector<int>> A, int X, int Y)
{
    if (X == 0 && Y == 0)
        return 0;

    if (!A[0][0])
        return -1;

    // row,col,step
    queue<pair<int, int>> q;
    q.push({0, 0});
    A[0][0] = 0;
    int step = 0;
    while (!q.empty())
    {
        int count = q.size();
        while (count--)
        {
            int i = q.front().first;
            int j = q.front().second;
            q.pop();
            for (int k = 0; k < 4; k++)
            {
                int newi = i + row[k];
                int newj = j + col[k];
                if (valid(newi, newj, N, M) && A[newi][newj])
                {
                    A[newi][newj] = 0;
                    if (newi == X && newj == Y)
                        return step + 1;
                    q.push({newi, newj});
                }
            }
        }
        step++;
    }
    return -1;
}

int main()
{
    int N=3,M=4,X=2,Y=3;
    vector<vector<int>>A={{1,0,0,0},{1,1,0,1},{0,1,1,1}};
    cout<<shortestDistance(N,M,A,X,Y);
}