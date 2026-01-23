package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,6,5,4,58,9,5,1,9,5};
        int n=nums.length;
        for(int i=0;i<n;i++){
            int j=i-1;
            int val=nums[i];
            while(j>=0 && nums[j]>val) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1]=val;
        }
        System.out.println(Arrays.toString(nums));
    }
}
