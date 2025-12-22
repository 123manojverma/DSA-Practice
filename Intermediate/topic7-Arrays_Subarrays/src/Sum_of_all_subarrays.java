import java.util.Scanner;

public class Sum_of_all_subarrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int[] pre=new int[n];
        pre[0]=a[0];
        for(int i=1;i<n;i++){
            pre[i]=a[i]+pre[i-1];
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==0){
                    sum+=pre[j];
                }else{
                    sum+=pre[j]-pre[i-1];
                }
            }
        }
        System.out.println(sum);
    }
}
