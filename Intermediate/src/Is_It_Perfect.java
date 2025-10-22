import java.util.Scanner;

public class Is_It_Perfect {

    public static String isPerfect(int n){
        int cnt=0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                cnt+=i;
            }
        }
        if(cnt==n){
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int q=sc.nextInt();
        int[] arr=new int[q];
        for(int i=0;i<q;i++){
            int n=sc.nextInt();
            arr[i]=n;
        }
        for(int i=0;i<q;i++){
            System.out.println(isPerfect(arr[i]));
        }
    }
}
