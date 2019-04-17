import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 * Medium
 *
 * 420
 *
 * 892
 *
 * Favorite
 *
 * Share
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class Codec {

    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();

        String shortUrl = toBase36(hashCode);
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    private String toBase36(int hashCode) {
        StringBuilder result = new StringBuilder();
        while (hashCode > 0) {
            int rem = hashCode % 36;
            if (rem < 10) result.append('0' + rem);
            else result.append('a' + rem - 10);
            hashCode /= 36;
        }
        return result.reverse().toString();
    }
}