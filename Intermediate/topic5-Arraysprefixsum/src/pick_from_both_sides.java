public class pick_from_both_sides {
    public static void main(String[] args) {
        int[] arr={1,2};
        int b=1;
        int n=2;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=arr[i]+pre[i-1];
        }
        int sum=Math.max(pre[b-1],pre[n-1]-pre[n-b-1]);
        for(int i=0;i<b;i++){
            sum=Math.max(sum,pre[i]+pre[n-1]-pre[n-b+i]);
        }
        System.out.println(sum);

//        int max=Integer.MIN_VALUE;
//        for(int i=b;i>=0;i--){
//            int lsum=0;
//            int rsum=0;
//            for(int j=0;j<i;j++){
//                lsum+=arr[j];
//            }
//            for(int j=n-b+i;j<n;j++){
//                rsum+=arr[j];
//            }
//            max=Math.max(max,lsum+rsum);
//        }
//        System.out.println(max);
    }
}
