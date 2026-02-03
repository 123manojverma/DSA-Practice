package Biweekly175;

import java.util.ArrayList;

public class Q1 {

    public static String reverseByType1(String s) {
        ArrayList<Character> arr=new ArrayList<>();
        ArrayList<Character>special=new ArrayList<>();
        int ind1=0,ind2=0;
        for(char c:s.toCharArray()){
            if(c>='a' && c<='z'){
                arr.add(c);
                ind1++;
            }else{
                special.add(c);
                ind2++;
            }
        }
        String res="";
        for(char c:s.toCharArray()){
            if(c>='a' && c<='z'){
                ind1--;
                res=res+arr.get(ind1);
            }else{
                ind2--;
                res=res+special.get(ind2);
            }
        }
        return res;
    }

    public static String reversalByTypeOptimal(String s){
        int st=0;
        int e=s.length()-1;
        char[] arr=s.toCharArray();
        while(st<e){
            if(!(arr[st]>='a' && arr[st]<='z')){
                st++;
            }else if (!(arr[e]>='a' && arr[e]<='z')){
                e--;
            }else{
                char temp=arr[st];
                arr[st]=arr[e];
                arr[e]=temp;
                st++;
                e--;
            }
        }
        st=0;
        e=s.length()-1;
        while(st<e){
            if(arr[st]>='a' && arr[st]<='z'){
                st++;
            }else if (arr[e]>='a' && arr[e]<='z'){
                e--;
            }else{
                char temp=arr[st];
                arr[st]=arr[e];
                arr[e]=temp;
                st++;
                e--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s=")ebc#da@f(";
//        System.out.println(reverseByType1(s));
        System.out.println(reversalByTypeOptimal(s));
    }
}
