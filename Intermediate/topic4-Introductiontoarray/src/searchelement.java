import java.util.HashMap;
import java.util.Scanner;

public class searchelement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int n1=sc.nextInt();
            int[] arr=new int[n1];
            for(int j=0;j<n1;j++){
                arr[j]=sc.nextInt();
            }
            int b=sc.nextInt();
            int flag=0;
            for(int j=0;j<n1;j++){
                if(arr[j]==b){
                    flag=1;
                    break;
                }
            }
            System.out.println(flag);
        }
    }
}
