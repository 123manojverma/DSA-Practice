import java.util.Scanner;

public class EvenSubarrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        if(n%2!=0){
            System.out.println("NO");
        }
        else if(a[0]%2==0 && a[n-1]%2==0){
            System.out.println("YES");
        }
    }
}
