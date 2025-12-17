import java.util.Arrays;

class NumMatrix {
    int[][] arr;
    int[][] pre;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        pre=new int[m][n];
        pre[0][0]=matrix[0][0];
        for(int i=1;i<n;i++){
            pre[0][i]=pre[0][i-1]+matrix[0][i];
        }
        for(int j=1;j<m;j++){
            pre[j][0]=pre[j-1][0]+matrix[j][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<matrix[i].length;j++){
                pre[i][j]=matrix[i][j]+pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1];
            }
        }

        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(pre[i]));
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 && col1==0){
            return pre[row2][col2];
        }
        if(row1==0){
            return pre[row2][col2]-pre[row2][col1-1];
        }if(col1==0){
            return pre[row2][col2]-pre[row1-1][col2];
        }
        return pre[row2][col2]-pre[row2][col1-1]-pre[row1-1][col2]+pre[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] arr={{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix mat=new NumMatrix(arr);
        System.out.println(mat.sumRegion(2,0,4,3));

    }
}
