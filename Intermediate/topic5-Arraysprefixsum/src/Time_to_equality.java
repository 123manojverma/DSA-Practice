public class Time_to_equality {
    public static void main(String[] args) {
        int[] a={2,4,1,3,2};
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            max=Math.max(a[i],max);
        }
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=max-a[i];
        }
        System.out.println(sum);
    }
}
