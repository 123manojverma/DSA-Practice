class SegmentTree1{
    static int[] tree; //segment tree
    static int[] arr;  // array
    int n;                  //size of array
    SegmentTree1(int[] input){
        n=input.length;
        arr=input;
        tree=new int[4*n];
        build(0,0,n-1); //Segment tree //root node index,start,end
    }

    public static void build(int node,int start,int end) {
        // Base condition
        if(start==end){
            tree[node]=arr[start];
            return;
        }
        int mid=start+(end-start)/2;
        // Left Child
        build(2*node+1,start,mid);
        // Right Child
        build(2*node+2, mid+1, end);
        // max of my left and right child
        tree[node]=Math.max(tree[2*node+1],tree[2*node+2]);
    }

    public int range(int node,int start,int end,int left,int right){
        // Fully out of range
        if(end<left || start>right) return 0;
        // Fully in the range
        if(start>=left && end<=right) return tree[node];

        int mid=start+(end-start)/2;

        // Overlapping or partially in the range
        // left child + right child

        return Math.max(range(2*node+1,start,mid,left,right),range(2*node+2,mid+1,end,left,right));
    }

    public void updating(int node,int start,int end,int idx,int val){
        // Base condition
        if(idx>end || idx<start) return;

        if(start==end){
            tree[node]=val;
            return;
        }

        int mid=start+(end-start)/2;
        // left child
        updating(2*node+1,start,mid,idx,val);
        // right child
        updating(2*node+2,mid+1,end,idx,val);
        tree[node]=Math.max(tree[2*node+1],tree[2*node+2]);
    }
    
    public int query(int left,int right){
        return range(0,0,n-1,left,right); // Root node index(seg),start,end
    }

    public void update(int idx,int val){
        updating(0,0,n-1,idx,val);
        arr[idx]=val;
    }
    
}

public class maximum {
    public static void main(String[] args){
        int[] arr={3,6,4,25,5,13,18};
        SegmentTree1 Tree=new SegmentTree1(arr);
        Tree.update(2, 10);
        System.out.println(Tree.query(1,2));
    }
}
