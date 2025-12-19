import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Leaders_in_an_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int max=a[n-1];
        ArrayList<Integer>res=new ArrayList<>();
        res.add(a[n-1]);
        for(int i=n-2;i>=0;i--){
            if(a[i]>max){
                res.add(a[i]);
                max=a[i];
            }
        }
        System.out.println(res.toString());
    }
}
