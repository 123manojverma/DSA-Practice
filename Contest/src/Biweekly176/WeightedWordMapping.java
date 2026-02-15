package Biweekly176;

public class WeightedWordMapping {
    public static String mapWordWeights(String[] words, int[] weights) {
        String res="";
        for(int i=0;i<words.length;i++){
            int sum=0;
            for(int j=0;j<words[i].length();j++){
                sum+=weights[words[i].charAt(j)-'a'];
            }
            int val=sum%26;
            res=res+(char) ('z'-val);
        }
        return res;
    }
    public static String mapWordWeights1(String[] words, int[] weights) {
        char[] arr={'z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'};
        String res="";
        for(int i=0;i<words.length;i++){
            int sum=0;
            for(int j=0;j<words[i].length();j++){
                sum+=weights[words[i].charAt(j)-'a'];
            }
            int val=sum%26;
            res=res+arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words={"abcd","def","xyz"};
        int[] weights={5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(mapWordWeights(words,weights));
        System.out.println(mapWordWeights(words,weights));
    }
}
