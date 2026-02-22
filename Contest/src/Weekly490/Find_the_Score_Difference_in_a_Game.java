package Weekly490;

public class Find_the_Score_Difference_in_a_Game {
    public static int scoreDifference(int[] nums) {
        boolean isactive=false;
        int p1=0,p2=0;
        for(int i=0;i<nums.length;i++){
            if((i+1)%6==0){
                isactive=!isactive;
            }
            if(nums[i]%2!=0){
                if(!isactive){
                    isactive=true;
                    p2+=nums[i];
                }else{
                    isactive=false;
                    p1+=nums[i];
                }
            }else{
                if(isactive){
                    p2+=nums[i];
                }else{
                    p1+=nums[i];
                }
            }
        }
        return p1-p2;
    }

    public static void main(String[] args) {
        int[] nums={1,2,6,5,9,2,3};
        System.out.println(scoreDifference(nums));
    }
}
