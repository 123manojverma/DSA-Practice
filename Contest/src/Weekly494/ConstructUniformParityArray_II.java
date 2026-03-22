package Weekly494;

public class ConstructUniformParityArray_II {
    public static boolean uniformArray(int[] nums1){
        int even=Integer.MAX_VALUE;
        int odd=Integer.MAX_VALUE;
        for(int num:nums1){
            if(num%2==0){
                even=Math.min(even,num);
            }else{
                odd=Math.min(odd,num);
            }
        }
        if(odd==Integer.MAX_VALUE || even==Integer.MAX_VALUE){
            return true;
        }
        return even - odd > 0;
    }
    public static void main(String[] args) {
        int[] nums1={2,3};
        System.out.println(uniformArray(nums1));
    }
}
