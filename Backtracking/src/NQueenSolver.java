import java.util.Arrays;
import java.util.Scanner;

public class NQueenSolver {
    public static void printBoard(int[][] board,int N){
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(board[i]));
        }
            System.out.println();
    }

    public static boolean isSafe(int[][] board,int i,int j,int N){
        for(int row=0;row<i;row++){
            if(board[row][j]==1){
                return false;
            }
        }
//        left diagonal
        int x=i-1;
        int y=j-1;
        while (x>=0 && y>=0){
            if(board[x][y]==1){
                return false;
            }
            x=x-1;
            y=y-1;
        }
//        right diagonal
        x=i-1;
        y=j+1;
        while(x>=0 && y<N){
            if(board[x][y]==1){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    public static int solveNQueen(int[][] board,int i,int N){
//        Base case
        if(i==N) {
            printBoard(board, N);
            return 1;
        }
//        rec case
        int count=0;
        for(int j=0;j<N;j++){
            if(isSafe(board,i,j,N)){
                board[i][j]=1;
                count+=solveNQueen(board,i+1,N);
//                if(success){
//                    return true;
//                }
//                no success -> try out the next position
//                remove the current queen
                board[i][j]=0;
            }
        }
//        no success in the ith row
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] board;
        board=new int[n][n];
        System.out.println(solveNQueen(board,0,n));
    }
}
