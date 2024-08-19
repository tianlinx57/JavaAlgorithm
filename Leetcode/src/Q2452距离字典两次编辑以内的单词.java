import java.util.ArrayList;
import java.util.List;

public class Q2452距离字典两次编辑以内的单词 {

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<queries.length;i++){
            for(int j=0;j< dictionary.length;j++){
                // char[] ch1 = queries[i].toCharArray();
                // char[] ch2 = dictionary[j].toCharArray();
                if(queries[i].length()!=dictionary[j].length()) continue;

                int n = queries[i].length();
                int flag = 0;
                for(int k=0;k<n;k++){
                    if(flag>=3) break;
                    if(queries[i].charAt(k) != dictionary[j].charAt(k)) ++flag;
                }
                if(flag<3) {
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Q2452距离字典两次编辑以内的单词 solution = new Q2452距离字典两次编辑以内的单词();
        System.out.println(solution.twoEditWords(new String[]{"word","note","ants","wood"},new String[]{"wood","joke","moat"}));
    }
}