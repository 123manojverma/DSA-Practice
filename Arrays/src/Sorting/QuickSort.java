package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] nums,int s,int e){
        int pivot=nums[e];
        int i=s-1;
        for(int l=s;l<e;l++){
            if(nums[l]<pivot){
                i++;
                int temp=nums[i];
                nums[i]=nums[l];
                nums[l]=temp;
            }
        }
        int temp=nums[i+1];
        nums[i+1]=nums[e];
        nums[e]=temp;
        return i+1;
    }

    public static int randomPartition(int[] a,int l,int r){
        int pivotIndex=l+(int)(Math.random()*(r-l+1));
        int temp=a[pivotIndex];
        a[pivotIndex]=a[r];
        a[r]=temp;
        return partition(a,l,r);
    }

    public static void quicksort(int[] nums,int s,int e){
        if(s<e){
            int pi=randomPartition(nums,s,e);
            quicksort(nums,s,pi-1);
            quicksort(nums,pi+1,e);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,5,6,9,7,5,6,3,9,5,-5};
        int n=nums.length;
        quicksort(nums,0,n-1);
        System.out.println(Arrays.toString(nums));
    }
}
