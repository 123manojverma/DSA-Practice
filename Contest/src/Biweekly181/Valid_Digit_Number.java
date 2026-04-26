package Biweekly181;

public class Valid_Digit_Number {
    public static boolean validDigit(int n, int x) {
        boolean flag=false;
        while(n>0){
            if(n/10==0){
                if(n==x){
                    return false;
                }
            }else{
                if(n%10==x){
                    flag=true;
                }
            }
            n/=10;
        }
        return flag;
    }

    public static void main(String[] args) {
        int n=101,x=0;
        System.out.println(validDigit(n,x));
    }
}
