import java.util.Arrays;

public class reversethearray {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,5};
        int i=0,j=4;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
