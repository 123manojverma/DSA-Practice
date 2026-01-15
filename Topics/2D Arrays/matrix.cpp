#include<bits/stdc++.h>
using namespace std;

int main(){
    // vector<vector<int>>a={{1,2,3},{4,5,6}};
    // cout<<a.empty(); to check whether it is empty or not
    // int rows=a.size();
    // int cols=a[0].size();
    // for(int i=0;i<rows;i++){
    //     for(int j=0;j<cols;j++){
    //         cout<<a[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }

    // vector<vector<int>>a={{1,2,3},{4,5,6}};
    // int sum=0;
    // int rows=a.size();
    // int cols=a[0].size();
    // for(int i=0;i<rows;i++){
    //     for(int j=0;j<cols;j++){
    //         sum+=a[i][j];
    //     }
    // }
    // cout<<"The sum is: "<<sum;

    // Diagonal Traversals

    // vector<vector<int>>mat={{1,2,3},{4,5,6,},{7,8,9}};
    // int n=mat.size();
    // for(int i=0;i<n;i++){
    //     cout<<mat[i][n-i-1]<<" ";
    // }

    // Transpose of a matrix
    // In-place transpose is possible only for square matrices
    // vector<vector<int>>mat={{1,2,3},{4,5,6}};
    // vector<vector<int>>mat1(mat[0].size());
    // for(int i=0;i<mat[0].size();i++){
    //     for(int j=0;j<mat.size();j++){
    //         // mat1[i].push_back(mat[j][i]);
    //         cout<<mat[j][i]<<" ";
    //     }
    // }

    // Rotation of a matrix
    // It works only in square matrix

    vector<vector<int>>mat={{1,2},{4,5}};
    // vector<vector<int>>res;
    // res.assign(mat.size(),0);
    // for (int i=0;i<mat.size();i++){
    //     for(int j=0;j<mat[0].size();j++){
    //         res[j][n-i-1]=mat[i][j];
    //     }
    // }

    // int n=mat.size();
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             swap(mat[i][j],mat[j][i]);
    //         }
    //     }

    //     for(int i=0;i<n;i++){
    //         reverse(mat[i].begin(),mat[i].end());
    //     }

    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         cout<<mat[i][j]<<" ";
    //     }
    // }

    // Anti Clockwise
    int n=mat.size();
    // transpose
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            swap(mat[i][j],mat[j][i]);
        }
    }

    // reverse columns
    for(int j=0;j<n;j++){
        int top=0,bottom=n-1;
        while(top<bottom){
            swap(mat[top][j],mat[bottom][j]);
            top++;
            bottom--;
        }
    }


    // 180 degree rotation
    int n=mat.size();
    // reverse rows
    reverse(mat.begin(),mat.end());

    // column reverse
    for(int i=0;i<n;i++){
        reverse(mat[i].begin(),mat[i].end());
    }

}