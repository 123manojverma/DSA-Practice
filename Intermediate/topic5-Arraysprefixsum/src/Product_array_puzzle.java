import java.util.Arrays;

public class Product_array_puzzle {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int n=arr.length;
        int[] res=new int[n];
//        for(int i=0;i<n;i++){
//            int mul=1;
//            for(int j=0;j<n;j++){
//                if(i==j){
//                    continue;
//                }
//                mul*=arr[j];
//            }
//            res[i]=mul;
//        }
//        System.out.println(Arrays.toString(res));

        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n-1;i++){
            pre[i]=arr[i]*pre[i-1];
        }
        int left=1;
        for(int i=n-1;i>0;i--){
            res[i]=pre[i-1]*left;
            left*=arr[i];
        }
        res[0]=left;
        System.out.println(Arrays.toString(res));
    }
}
