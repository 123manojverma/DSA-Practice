import java.util.Arrays;

public class greatestelementonright{
    
    public static int[] brute(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int max=-1;
            for(int j=i+1;j<n;j++){
                max=Math.max(arr[j],max);
            }
            arr[i]=max;
        }
        return arr;
    }

    public static int[] optimal(int[] arr){
        int n=arr.length;
        int max=-1;
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            arr[i]=max;
            max=Math.max(max,val);
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr={17,18,5,4,6,1};
//        System.out.println(Arrays.toString(brute(arr)));
        System.out.println(Arrays.toString(optimal(arr)));
    }
}