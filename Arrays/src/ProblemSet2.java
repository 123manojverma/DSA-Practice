import java.util.Arrays;

public class ProblemSet2 {

    public static void leftRotate(int[] arr){
        int temp=arr[0];
        for(int i=1;i< arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=temp;
    }

    public static void rightRotate(int[] arr) {
        int temp=arr[arr.length-1];
        for(int i= arr.length-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=temp;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,5,4,6,5,9};
//        leftRotate(arr);
        rightRotate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
