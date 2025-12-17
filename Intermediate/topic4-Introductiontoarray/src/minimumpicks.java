import java.util.Scanner;

public class minimumpicks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int evenMax=Integer.MIN_VALUE;
        int oddMin=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                evenMax=Math.max(evenMax,arr[i]);
            }else {
                oddMin=Math.min(oddMin,arr[i]);
            }
        }
        System.out.println(evenMax-oddMin);
    }
}
