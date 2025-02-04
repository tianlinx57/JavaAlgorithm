package EA;

import java.util.Random;

public class TestStringGenerator {
    /**
     * 生成一个指定长度的随机字符串，由字母和数字组成。
     *
     * @param length 字符串长度
     * @return 生成的随机字符串
     */
    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);

        // 插入一些长回文子串
        String palindrome = "abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba";
        int palinLength = palindrome.length();
        int insertPosition = length / 2 - palinLength / 2;

        // 先填充随机字符
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rand.nextInt(characters.length())));
        }

        // 在中间插入一个长回文子串
        if (length >= palinLength) {
            sb.replace(insertPosition, insertPosition + palinLength, palindrome);
        }

        return sb.toString();
    }
}
