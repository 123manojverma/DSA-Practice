package TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class SpiralMatrixCreation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] nums=new int[n][n];
        int top=0;
        int left=0;
        int right=n-1;
        int bottom=n-1;
        int num=1;
        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++){
                nums[top][j]=num++;
            }
            top++;

            for(int i=top;i<=bottom;i++){
                nums[i][right]=num++;
            }
            right--;
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    nums[bottom][j]=num++;
                }
                bottom--;
                for(int i=bottom;i>=top;i--){
                    nums[i][left]=num++;
                }
                left++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
