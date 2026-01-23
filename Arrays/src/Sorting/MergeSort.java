package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr,int s,int m,int e){
        int i=s,j=m+1;
        int k=0;
        int[] ans=new int[e-s+1];
        while(i<=m && j<=e){
            if(arr[i]>arr[j]){
                ans[k]=arr[j];
                j++;
            }else{
                ans[k]=arr[i];
                i++;
            }
            k++;
        }
        while(i<=m){
            ans[k]=arr[i];
            i++;
            k++;
        }while(j<=e){
            ans[k]=arr[j];
            j++;
            k++;
        }
        for(i=s;i<=e;i++){
            arr[i]=ans[i-s];
        }
    }

    public static void mergesort(int[] arr,int s,int e){
        if(s<e){
            int mid=s+(e-s)/2;
            mergesort(arr,s,mid);
            mergesort(arr,mid+1,e);
            merge(arr,s,mid,e);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,5,5,6,9,78,75,4,8,23,5};
        mergesort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
