package TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDarray {

    public static void printMatrix(List<List<Integer>>mat){
        int n=mat.size();
        int m=mat.get(0).size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("Rows: "+n);
        System.out.println("Cols: "+m);
    }

    public static int matrixsum(List<List<Integer>>mat){
        int n=mat.size();
        int m=mat.get(0).size();
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=mat.get(i).get(j);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(arr[2][1]);

//        List<List<Integer>>matrix=new ArrayList<>();
        List<List<Integer>>mat= Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6)
        );

//        if(mat==null || mat.isEmpty())return;

//        System.out.println(mat.get(1).get(2));
//        System.out.println("Number of rows: "+mat.size());
//        System.out.println("Number of cols: "+mat.get(0).size());

//        printMatrix(mat);
        System.out.println(matrixsum(mat));

    }
}
