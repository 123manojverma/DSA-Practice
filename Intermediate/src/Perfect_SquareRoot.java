import java.util.Scanner;

public class Perfect_SquareRoot {

    public static int Perfect(int n) {
//        int s=1,e=n-1;
//        while(s<=e){
//            int mid=s+(e-s)/2;
//            long square=mid*mid;
//            if(square==n){
//                return mid;
//            }else if(square<n){
//                s=mid+1;
//            }else{
//                e=mid-1;
//            }
//        }
//        return -1;
        for(int i=1;i*i<=n;i++){
            if(i*i==n)return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Perfect(n));
    }
}