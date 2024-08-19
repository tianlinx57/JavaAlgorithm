public class Q3136有效单词 {

    public boolean isValid(String word) {
        if(word.length() < 3) return false;

        int yuanyin=0,fuyin=0;
        for(char c:word.toCharArray()){
            if(c == 'a'|| c=='o' || c=='u' || c=='i' || c=='e' || c == 'A'|| c=='O' || c=='U' || c=='I' || c=='E'){
                yuanyin++;
            } else if (c >= 'a'&&c <= 'z' || c>='A'&&c<='Z') {
                fuyin++;
            } else if (!(c>='0'&&c<='9')) {
                return false;
            }
        }
        if(yuanyin==0||fuyin==0)return false;
        return true;
    }


    public static void main(String[] args) {
        Q3136有效单词 solution = new Q3136有效单词();
        System.out.println(solution.isValid(new String("234Adas")));
        //输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
        //
        // 输出：[0,-1,4]
    }
}