import java.util.Arrays;

public class foursum {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,1,3};
        Arrays.sort(arr);
        int n=arr.length;
        int target=15;
        boolean flag=true;
        for(int i=0;i<n-3;i++) {
            if(!flag)break;
            if (arr[i] > target) break;
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1, l = n - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    int[] num = {arr[i], arr[j], arr[k], arr[l]};
                    if (sum == target) {
                        flag=false;
                        System.out.println(Arrays.toString(num));
                        break;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
    }
}
