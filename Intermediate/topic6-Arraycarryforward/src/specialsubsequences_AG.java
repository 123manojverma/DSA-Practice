import java.util.Scanner;

public class specialsubsequences_AG {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.next();
        int a=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A') {
                a++;
            }
            if(s.charAt(i)=='G'){
                res+=a;
            }
        }
        System.out.println(res);
    }
}
