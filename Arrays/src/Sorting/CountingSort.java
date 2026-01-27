package Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] nums={1,2,3,5,10,5,5,9,4,4,54,6,12,9,5,4,296,1,2,2,23,3,2,1,1,5,5,2};
        int n=nums.length;
        int max= Arrays.stream(nums).max().getAsInt();

        int[] cnt=new int[max+1];
        for(int x:nums){
            cnt[x]++;
        }
        int i=0;
        for(int j=0;j<max+1;j++){
            while(cnt[j]-->0){
                nums[i]=j;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}