public class ArrayTraversal {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};

//        Simple Traversal
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
//        Reverse Traversal
        for(int i=arr.length-1;i>=0;i--) {
            System.out.print(arr[i] + " ");
        }
    }
}