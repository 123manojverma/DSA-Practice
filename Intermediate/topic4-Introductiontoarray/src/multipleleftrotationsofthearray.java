import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class multipleleftrotationsofthearray {

    public static void rotate(int[] c,int i,int j){
        while(i<j){
            int temp=c[i];
            c[i]=c[j];
            c[j]=temp;
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
        int b=sc.nextInt();
        int[] brr=new int[b];
        for(int i=0;i<b;i++){
            brr[i]=sc.nextInt();
        }
        int[] c=new int[n];
        for(int i=0;i<n;i++){
            c[i]=arr[i];
        }
        int[][] res=new int[b][n];
        for(int i=0;i<b;i++){
            rotate(c,0,brr[i]%n-1);
            rotate(c,brr[i]%n,n-1);
            rotate(c,0,n-1);
            res[i]=c;
            c=arr;
        }
        for(int i=0;i<b;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
