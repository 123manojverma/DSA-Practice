import java.util.Arrays;
import java.util.Scanner;

public class Rotationgame {

    public static void swap(int[] arr,int i,int j){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int rot=sc.nextInt();
        swap(arr,0,n-rot%n-1);
        swap(arr,n-rot%n,n-1);
        swap(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
}
