import java.util.ArrayList;
import java.util.List;

class Daxiaoxie {

    // public List<String> letterCasePermutation(String s) {
    //     List<String> list = new ArrayList<>();
    //     list.add("");
    //     for(int i = 0; i<s.length();i++) {
    //         List<String> listNew = new ArrayList<>();
    //         if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
    //             for(String str:list){
    //                 listNew.add(str+((char)(s.charAt(i)+'A'-'a')));
    //                 listNew.add(str + s.charAt(i));
    //             }
    //         } else if (s.charAt(i)>='A'&&s.charAt(i)<='Z') {
    //             for(String str:list){
    //                 listNew.add(str+((char)(s.charAt(i)-'A'+'a')));
    //                 listNew.add(str + s.charAt(i));
    //             }
    //         } else{
    //             for(String str:list){
    //                 listNew.add(str + s.charAt(i));
    //             }
    //         }
    //         list.removeAll(list);
    //         list.addAll(listNew);
    //     }
    //     return list;
    // }

    List<String> res = new ArrayList<>();

    String string;

    void dfs(int depth, int n, String str){
        if(depth == n){
            res.add(str);
            return;
        }
        char c=string.charAt(depth);
        if(c>='a'&&c<='z'){
            dfs(depth+1,n,str+c);
            dfs(depth+1,n,str+(char)(c+'A'-'a'));
        } else if (c>='A'&&c<='Z') {
            dfs(depth+1,n,str+c);
            dfs(depth+1,n,str+(char)(c-'A'+'a'));
        } else {
            dfs(depth+1,n,str+c);
        }
    }
    public List<String> letterCasePermutation(String s) {
        string = s;
        dfs(0,s.length(),"");
        return res;
    }



    public static void main(String[] args) {
        Daxiaoxie example = new Daxiaoxie();
        System.out.println(example.letterCasePermutation("A1b2"));
        System.out.println(example.letterCasePermutation("3z4"));
    }
}
