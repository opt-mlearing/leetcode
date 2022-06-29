package leetcode.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. TinyURL 的加密与解密
 * https://leetcode.cn/problems/encode-and-decode-tinyurl/submissions/
 *
 * @author: caogl
 * @date: 2022/6/30, 0:09
 **/
public class Solution535 {

    private Map<String, String> encodeMap = new HashMap<String, String>();
    private Map<String, String> decodeMap = new HashMap<String, String>();
    private static final String FIX_URL = "http://tinyurl.com/";
    private Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodeMap.containsKey(longUrl)) {
            return encodeMap.get(longUrl);
        }
        String shortUrl = null;
        StringBuilder builder = null;
        while (true) {
            builder = new StringBuilder();
            for (int i = 0; i < 6; ++i) {
                int type = random.nextInt(3);
                // [1,9]的数字.
                if (type == 0) {
                    int num = random.nextInt(9) + 1;
                    builder.append(num);
                } else if (type == 1) {
                    char lowercase = (char) (random.nextInt(26) + 'a');
                    builder.append(lowercase);
                } else if (type == 2) {
                    char capital = (char) (random.nextInt(26) + 'A');
                    builder.append(capital);
                }
            }
            shortUrl = builder.toString();
            if (!decodeMap.containsKey(shortUrl)) {
                break;
            }
        }
        encodeMap.put(longUrl, shortUrl);
        decodeMap.put(shortUrl, longUrl);
        return FIX_URL + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf("/");
        String key = shortUrl.substring(index + 1);
        return decodeMap.get(key);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
