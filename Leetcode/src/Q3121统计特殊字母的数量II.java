// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Q3121统计特殊字母的数量II {
    public static void main(String[] args) {
        Q3121统计特殊字母的数量II main = new Q3121统计特殊字母的数量II();
        System.out.println(main.numberOfSpecialChars(new String("cADEDee")));
    }
    //1只有小写 2只有大写 3先小写再大写 4大写后有小写 （3->4 要减一）
    public int numberOfSpecialChars(String word) {
        int res=0;
        int[] list = new int[26];
        for(char c:word.toCharArray()){
            if(c>='a'&&c<='z'){
                if(list[c-'a']==0) list[c-'a']=1;
                else if(list[c-'a']==2){
                    list[c-'a'] =4;
                } else if (list[c-'a']==3) {
                    list[c-'a'] =4;
                    res--;
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