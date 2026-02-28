import java.util.*;

public class helpfromsam {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=n;
        int val=1;
        int help=1;
        n=n>>1;
        while(n>0){
            n=n>>1;
            val*=2;
        }
        help+=m-val;
        System.out.println(help);
    }    
}