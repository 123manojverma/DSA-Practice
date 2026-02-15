public class min_in_rotatedarray {

    public static int bs(int[] nums){
        int n=nums.length;
        int s=0,e=n-1;
        while(s<e){
            if(nums[s]<nums[e]){
                return nums[s];
            }
            int mid=s+(e-s)/2;
            if(nums[mid]>nums[e]){
                s=mid+1;
            }else{
                e=mid;
            }
        }
        return nums[s];
    }
    public static void main(String[] args) {
        /*
        * Intution
        * Array is sorted so we find the mid element
        * If mid element is smaller than last element it means that there is no smaller value b/w mid and high so we have to search
        * the element on left side considering mid as high point
        * Now if mid is greater than high there must be possibility that there is more smaller element present on right side so we search on right side
        * */
        int[] nums={5, 6, 1, 2, 3, 4};
        System.out.println(bs(nums));
    }
}
