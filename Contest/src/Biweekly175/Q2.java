package Biweekly175;

public class Q2 {
        public int minimumK(int[] nums) {
            int k=1;
            while(true){
                int op=0;
                boolean flag=true;
                for(int i=0;i<nums.length;i++){
                    if(op/k>k){
                        flag=false;
                        break;
                    }
                    double div=(double) nums[i]/k;
                    op+=(int)Math.ceil(div);
                }
                double n=(double) op/k;
                int m=(int) Math.ceil(n);
                if(m<=k && flag){
                    return k;
                }
                k++;
            }
        }
    public boolean isValid(int[] nums,int k){
        long op=0;
        for(int x:nums){
            op+=(x+k-1)/k;
            if(op>(long) k*k){
                return false;
            }
        }
        return op<=(long) k*k;
    }

    public int minimumKoptimal(int[] nums) {
        int n=nums.length;
        int left=1;
        int right=100000;

        while(left<right){
            int mid=left+(right-left)/2;

            if(isValid(nums,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
