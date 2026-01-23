package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums={1,5,3,6,2,1,5};
        int n=nums.length;
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(nums[min]>nums[j]){
                    min=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
