import java.util.Arrays;

public class SudokuSolver {

    public static void printBoard(int[][] board,int N){
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();
    }

    public static boolean canPlace(int grid[][],int i,int j,int number,int N){
//        Row and Col
        for(int x=0;x<N;x++){
            if(grid[x][j]==number || grid[i][x]==number){
                return false;
            }
        }
//        Subgrid assuming a 9 x 9 matrix
        int sx=(i/3)*3;
        int sy=(j/3)*3;
        for(int x=sx;x<sx+3;x++){
            for(int y=sy;y<sy+3;y++){
                if(grid[x][y]==number){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int grid[][],int i ,int j, int N){
        if(i==N){
            printBoard(grid,N);
            return true;
        }
//        rec case
//        cross the right boundary go to the next row
        if(j==N){
            return solveSudoku(grid, i+1, 0, N);
        }
//        encounter a prefilled call - skip
        if(grid[i][j]!=0){
            return solveSudoku(grid,i,j+1,N);
        }
//        blank cell -> fill
        for(int number=1;number<=N;number++){
            if(canPlace(grid,i,j,number,N)){
                grid[i][j]=number;
                boolean success=solveSudoku(grid,i,j+1,N);
                if(success){
                    return true;
                }
                grid[i][j]=0;
            }
        }
//        backtracking
        grid[i][j]=0;
        return false;
    }

    public static void main(String[] args) {
        int grid[][]={
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        solveSudoku(grid,0,0,9);

    }
}
