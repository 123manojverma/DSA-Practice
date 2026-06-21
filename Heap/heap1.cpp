#include<bits/stdc++.h>
using namespace std;

// Time Complexity - O(n logn) to create the heap
// T.C. - O(log n) to delete the node

class MaxHeap{
    int *arr;
    int size; // total elements in heap
    int total_size; // total size of array

    public:
    MaxHeap(int n){
        arr=new int[n];
        size=0;
        total_size=n;
    }

    void Heapify(int index){
        int largest=index;
        int left=2*index+1;
        int right=2*index+2;

        // Largest will store the index of the element which is greater between parent,left child and right child

        if(left<size && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<size && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=index){
            swap(arr[largest],arr[index]);
            Heapify(largest);
        }
    }

    // insert into the heap
    void insert(int value){
        // if heap size is available or not
        if(size==total_size){
            cout<<"Heap Overflow\n";
            return;
        }

        arr[size]=value;
        int index=size;
        size++;

        // Compare it with its parent
        while(index>0 && arr[(index-1)/2]<arr[index]){
            swap(arr[index],arr[(index-1)/2]);
            index=(index-1)/2;
        }
        cout<<arr[index]<<" is inserted into the heap\n";
    }

    void print(){
        for(int i=0;i<size;i++){
            cout<<arr[i]<<" ";
        }
        cout<<endl;
    }

    void Delete(){
        if(size==0){
            cout<<"Heap Underflow\n";
            return;
        }

        cout<<arr[0]<<" deleted from heap\n";
        size--;
        arr[0]=arr[size];

        if(size==0)return;
        Heapify(0);
    }
};

class MinHeap{
    int *arr;
    int size; // total elements in heap
    int total_size; // total size of array

    public:
    MinHeap(int n){
        arr=new int[n];
        size=0;
        total_size=n;
    }

    void Heapify(int index){
        int largest=index;
        int left=2*index+1;
        int right=2*index+2;

        // Largest will store the index of the element which is smaller between parent,left child and right child

        if(left<size && arr[left]<arr[largest]){
            largest=left;
        }
        if(right<size && arr[right]<arr[largest]){
            largest=right;
        }
        if(largest!=index){
            swap(arr[largest],arr[index]);
            Heapify(largest);
        }
    }

    // insert into the heap
    void insert(int value){
        // if heap size is available or not
        if(size==total_size){
            cout<<"Heap Overflow\n";
            return;
        }

        arr[size]=value;
        int index=size;
        size++;

        // Compare it with its parent
        while(index>0 && arr[(index-1)/2]>arr[index]){
            swap(arr[index],arr[(index-1)/2]);
            index=(index-1)/2;
        }
        cout<<arr[index]<<" is inserted into the heap\n";
    }

    void print(){
        for(int i=0;i<size;i++){
            cout<<arr[i]<<" ";
        }
        cout<<endl;
    }

    void Delete(){
        if(size==0){
            cout<<"Heap Underflow\n";
            return;
        }

        cout<<arr[0]<<" deleted from heap\n";
        size--;
        arr[0]=arr[size];

        if(size==0)return;
        Heapify(0);
    }
};

int main(){
    // MaxHeap H1(6);
    // H1.insert(4);
    // H1.insert(14);
    // H1.insert(11);
    // H1.print();
    // H1.insert(144);
    // H1.insert(24);
    // H1.insert(1);
    // H1.Delete();
    // H1.print();
    // H1.Delete();
    // H1.print();
    // H1.Delete();
    // H1.print();

    MinHeap H1(6);
    H1.insert(4);
    H1.insert(14);
    H1.insert(11);
    H1.print();
    H1.insert(144);
    H1.insert(24);
    H1.insert(1);
    H1.Delete();
    H1.print();
    H1.Delete();
    H1.print();
    H1.Delete();
    H1.print();
}