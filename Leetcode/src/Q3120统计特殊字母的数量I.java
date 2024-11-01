// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Q3120统计特殊字母的数量I {
    public static void main(String[] args) {
        Q3120统计特殊字母的数量I main = new Q3120统计特殊字母的数量I();
        System.out.println(main.numberOfSpecialChars(new String("aaAbcBC")));
    }
    //1只有小写 2只有大写 3两个都有
    public int numberOfSpecialChars(String word) {
        int res=0;
        int[] list = new int[26];
        for(char c:word.toCharArray()){
            if(c>='a'&&c<='z'){
                if(list[c-'a']==0) list[c-'a']=1;
                else if(list[c-'a']==2){
                    list[c-'a'] =3;
                    res++;
                }
            } else{
                if(list[c-'A']==0) list[c-'A']=2;
                else if(list[c-'A']==1){
                    list[c-'A'] =3;
                    res++;
                }
            }
        }
        return res;
    }
}