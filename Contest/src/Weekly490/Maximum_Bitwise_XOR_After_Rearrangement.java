package Weekly490;

public class Maximum_Bitwise_XOR_After_Rearrangement {

//    Using StringBuilder
    public static String maximumXor(String s, String t) {
        int one=0,zero=0;
        int n=t.length();
        for(int i=0;i<n;i++){
            if(t.charAt(i)=='0')zero++;
            else one++;
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                if(one>0){
                    res.append("1");
                    one--;
                }else{
                    res.append("0");
                    zero--;
                }
            }else{
                if(zero>0){
                    res.append("1");
                    zero--;
                }else{
                    res.append("0");
                    one--;
                }
            }
        }
        return res.toString();
    }

//    Using Array
    public static String maximumXor1(String s, String t) {
        int one=0,zero=0;
        int n=t.length();
        for(int i=0;i<n;i++){
            if(t.charAt(i)=='0')zero++;
            else one++;
        }
        char[] res=new char[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                if(one>0){
                    res[i]='1';
                    one--;
                }else{
                    res[i]='0';
                    zero--;
                }
            }else{
                if(zero>0){
                    res[i]='1';
                    zero--;
                }else{
                    res[i]='0';
                    one--;
                }
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s="110",t="011";
        System.out.println(maximumXor(s,t));
        System.out.println(maximumXor1(s,t));
    }
}
