#include<bits/stdc++.h>
using namespace std;

// Array Convert MaxHeap
// MaxHeap to Sorted Array

void Heapify(int arr[],int index,int n){
    int largest=index;
    int left=2*index+1;
    int right=2*index+2;

    if(left<n && arr[largest]<arr[left]){
        largest=left;
    }
    if(right<n && arr[largest]<arr[right]){
        largest=right;
    }

    if(largest!=index){
        swap(arr[largest],arr[index]);
        Heapify(arr,largest,n);
    }
}

void BuildMaxHeap(int arr[],int n){
    // step down
    for(int i=n/2-1;i>=0;i--){
        Heapify(arr,i,n);
    }
}

void Heapify1(int arr[],int index,int n){
    int largest=index;
    int left=2*index+1;
    int right=2*index+2;

    if(left<n && arr[largest]>arr[left]){
        largest=left;
    }
    if(right<n && arr[largest]>arr[right]){
        largest=right;
    }

    if(largest!=index){
        swap(arr[largest],arr[index]);
        Heapify1(arr,largest,n);
    }
}

void BuildMinHeap(int arr[],int n){
    // step down
    for(int i=n/2-1;i>=0;i--){
        Heapify1(arr,i,n);
    }
}

void sortArray(int arr[],int n){
    for(int i=n-1;i>0;i--){
        swap(arr[i],arr[0]);
        Heapify(arr,0,i);
    }
}

int main(){
    // int arr[]={10,3,8,9,5,13,18,14,11,70};
    // BuildMinHeap(arr,10);

    // Heap Sort-> First Build MaxHeap then then call sortArray 
    // BuildMaxHeap(arr,10);
    // sortArray(arr,10);
    // for(int i=0;i<10;i++){
    //     cout<<arr[i]<<" ";
    // }

    // priority_queue<int>p; //max heap
    // p.push(10);
    // p.push(20);
    // p.push(11);
    // p.push(18);
    // p.push(15);
    // cout<<p.top()<<" ";

    // // delete
    // p.pop();
    // cout<<p.top()<<" ";

    // // size
    // cout<<p.size()<<endl;

    // while(!p.empty()){
    //     cout<<p.top()<<" ";
    //     p.pop();
    // }

    priority_queue<int,vector<int>,greater<int>>p;  //min heap
    p.push(10);
    p.push(20);
    p.push(11);
    p.push(18);
    p.push(15);
    cout<<p.top()<<" ";

    // delete
    p.pop();
    cout<<p.top()<<" ";

    // size
    cout<<p.size()<<endl;

    while(!p.empty()){
        cout<<p.top()<<" ";
        p.pop();
    }

}

// Time Complexity to build Heap->O(n)
// Time Complexity of heap sort->O(n logn)