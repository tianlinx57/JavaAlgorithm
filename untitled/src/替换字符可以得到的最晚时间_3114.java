// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class 替换字符可以得到的最晚时间_3114 {
    public static void main(String[] args) {
        替换字符可以得到的最晚时间_3114 main = new 替换字符可以得到的最晚时间_3114();
        System.out.println(main.findLatestTime("1?:?4"));
    }
    public String findLatestTime(String s) {
        char[] ch = s.toCharArray();
        if(ch[0] == '?'){
            if(ch[1] == '?'){
                ch[0] = '1';
                ch[1] = '1';
            }
            else if(ch[1] >= '2') ch[0] = '0';
            else ch[0] = '1';
        }
        if(ch[1] == '?'){
            if(ch[0] == '1'){
                ch[1] = '1';
            }
            else {
                ch[1] = '9';
            }
        }

        if(ch[3] == '?'){
            ch[3] = '5';
        }

        if(ch[4] == '?'){
            ch[4] = '9';
        }

        return new String(ch);
    }
}