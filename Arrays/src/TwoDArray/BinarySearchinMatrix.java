package TwoDArray;

public class BinarySearchinMatrix {

    public static boolean binarysearch(int[][] nums,int target){
        for(int i=0;i<nums.length;i++){
            int s=0,e=nums[i].length-1;
            boolean flag=false;
            while (s <= e) {
                int mid=s+(e-s)/2;
                if(nums[i][mid]==target){
                    return true;
                }else if(nums[i][mid]>target){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] nums,int target){
        int r=nums.length;
        int c=nums[0].length;

        int l=0,h=r*c-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            int row=mid/c;
            int col=mid%c;

            if(nums[row][col]==target){
                return true;
            }else if(nums[row][col]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }

    public static boolean staircaseSearch(int[][] mat,int target){
        int row=mat.length;
        int col=mat[0].length;
        int r=0,c=col-1;
        while(r<row && c>=0){
            if(mat[r][c]==target){
                return true;
            }else if(mat[r][c]>target){
                c--;
            }else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums={{1,2,3},{4,5,6},{7,8,9}};
        int target=6;
//        System.out.println(binarysearch(nums,target));
//        System.out.println(searchMatrix(nums,target));
        System.out.println(staircaseSearch(nums,target));
    }
}
