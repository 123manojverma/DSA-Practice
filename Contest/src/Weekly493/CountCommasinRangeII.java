package Weekly493;

public class CountCommasinRangeII {
    public static long countCommas(long n) {
        long c=0;
        long m=1000000000000L;
        if(n==1000000000000000L){
            c=1;
        }
        if(n>=m){
            c+=(n-m+1);
        }
        if(n>=1000000000){
            c+=(n-1000000000+1);
        }
        if(n>=1000000){
            c+=(n-1000000+1);
        }
        if(n>=1000){
            c+=(n-1000+1);
        }
        return c;
    }

    public static void main(String[] args) {
        long n=100000002544L;
        System.out.println(countCommas(n));
    }
}
