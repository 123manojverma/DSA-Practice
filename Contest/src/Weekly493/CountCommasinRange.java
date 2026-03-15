package Weekly493;

public class CountCommasinRange {
    public static int countCommas(int n) {
        if(n<1000) return 0;
        return n-999;
    }

    public static void main(String[] args) {
        int n=1002;
        System.out.println(countCommas(n));
    }
}
