import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class separateoddeven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testcase=sc.nextInt();
        for(int i=0;i<testcase;i++){
            int n=sc.nextInt();
            int[] arr=new int[n];
            ArrayList<Integer>even=new ArrayList<>();
            ArrayList<Integer>odd=new ArrayList<>();
            for(int j=0;j<n;j++){
                arr[j]=sc.nextInt();
                if(arr[j]%2==0){
                    even.add(arr[j]);
                }else {
                    odd.add(arr[j]);
                }
            }
            System.out.println(odd.toString());
            System.out.println(even.toString());
        }
    }
}
