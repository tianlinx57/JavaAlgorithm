import java.util.HashMap;
import java.util.Map;

class TinyURL {

    private Map<Integer, String> dataBase = new HashMap<Integer, String>();
    private int id;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }




    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";

        TinyURL obj = new TinyURL();
        String tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
        String ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。

        System.out.println(tiny); // 输出 加密后得到的 TinyURL
        System.out.println(ans); // 输出 https://leetcode.com/problems/design-tinyurl

    }
}
