public class Equilibrium_index_of_an_array {
    public static void main(String[] args) {
        int[] arr={-7,1,5,2,-4,3,0};
        int n=arr.length;
//        int[] pre=new int[n];
//        pre[0]=arr[0];
//        for(int i=1;i<n;i++){
//            pre[i]=arr[i]+pre[i-1];
//        }
        int res=-1;
//        for(int i=0;i<n;i++){
//            if(i==0){
//                if(pre[n-1]-pre[0]==0){
//                    res=i;
//                    break;
//                }
//            }else if(i==n-1){
//                if(pre[n-1]-arr[n-1]==0){
//                    res=i;
//                    break;
//                }
//            }else{
//                if(pre[i-1]==pre[n-1]-pre[i]){
//                    res=i;
//                    break;
//                }
//            }
//        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int leftsum=0;
        for(int i=0;i<n;i++){
            if(i==0){
                leftsum+=arr[i];
                if(sum-leftsum==0){
                    res=i;
                    break;
                }
            }
            else if(i==n-1){
                if(sum-leftsum==0){
                    res=i;
                    break;
                }
            }else {
                leftsum+=arr[i];
                if((sum-leftsum)==(leftsum-arr[i])){
                    res=i;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
