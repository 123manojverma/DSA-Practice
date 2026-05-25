#include <bits/stdc++.h>
using namespace std;

int row[8] = {2, 2, -2, -2, 1, -1, 1, -1};
int col[8] = {1, -1, 1, -1, 2, 2, -2, -2};

bool valid(int i, int j, int n)
{
    return i >= 0 && j >= 0 && i < n && j < n;
}

int minStepToReachTarget(vector<int> &KnightPos, vector<int> &TargetPos, int N)
{
    KnightPos[0]--;
    KnightPos[1]--;
    TargetPos[0]--;
    TargetPos[1]--;
    // base case
    if (TargetPos[0] == KnightPos[0] && TargetPos[1] == KnightPos[1])
        return 0;
    queue<pair<int, int>> q;
    vector<vector<bool>> chess(N, vector<bool>(N, 0));
    q.push({KnightPos[0], KnightPos[1]});
    chess[KnightPos[0]][KnightPos[1]] = 1;
    int step = 0;
    while (!q.empty())
    {
        int count = q.size();
        while (count--)
        {
            int i = q.front().first;
            int j = q.front().second;
            q.pop();
            for (int k = 0; k < 8; k++)
            {
                int newi = i + row[k];
                int newj = j + col[k];
                if (valid(newi, newj, N) && !chess[newi][newj])
                {
                    if (newi == TargetPos[0] && newj == TargetPos[1])
                        return step + 1;
                    q.push({newi, newj});
                    chess[newi][newj] = 1;
                }
            }
        }
        step++;
    }
    return -1;
}


int main(){
    int N=8;
    vector<int>KnightPos={7,7};
    vector<int>TargetPos={1,5};
    cout<<minStepToReachTarget(KnightPos,TargetPos,N);
}