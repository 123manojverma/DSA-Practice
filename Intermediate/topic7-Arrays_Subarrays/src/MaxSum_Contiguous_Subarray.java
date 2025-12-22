import java.util.Scanner;

public class MaxSum_Contiguous_Subarray {

    public static int brute(int[] arr){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum1=0;
                for(int k=i;k<=j;k++){
                    sum1+=arr[k];
                }
                sum=Math.max(sum,sum1);
            }
        }
        return sum;
    }

    public static int better(int[] arr){
        int n=arr.length;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=arr[i]+pre[i-1];
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int val;
                if(i==0){
                    val=pre[j];
                }else {
                    val=pre[j]-pre[i-1];
                }
                res=Math.max(res,val);
            }
        }
        return res;
    }

    public static int optimal(int[] arr){
        int n= arr.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max=Math.max(sum,max);
            sum=Math.max(sum,0);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
//        System.out.println(brute(arr));
//        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
