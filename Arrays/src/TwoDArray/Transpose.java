package TwoDArray;

import java.util.Arrays;

public class Transpose {

    public static void rotate90(int[][] mat) {
        int n = mat.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++; r--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void rotate180(int[][] mat) {
        int n = mat.length;

        // Reverse rows
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++; r--;
            }
        }

        // Reverse columns
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++; bottom--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void rotate270(int[][] mat) {
        int n = mat.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse columns
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++; bottom--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }


    public static void main(String[] args) {
        int[][] nums={{1,2,3},{4,5,6},{7,8,9}};
//        int n=nums.length;
//        for(int i=0;i<n;i++){
//            for(int j=i;j<n;j++){
//                int temp=nums[i][j];
//                nums[i][j]=nums[j][i];
//                nums[j][i]=temp;
//            }
//        }
//        for(int i=0;i<n;i++){
//            System.out.println(Arrays.toString(nums[i]));
//        }

//        rotate90(nums);
//        rotate180(nums);
        rotate270(nums);
    }
}
