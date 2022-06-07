package leetcode.base;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * https://leetcode.cn/problems/unique-email-addresses/
 */
public class Solution929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for (String email : emails) {
            String[] split = email.split("@");
            int plusIndex = split[0].indexOf("+");
            if (plusIndex != -1) {
                String substring = split[0].substring(0, plusIndex);
                split[0] = substring;
            }
            if (split[0].indexOf(".") != -1) {
                String replaceString = split[0].replace(".", "");
                split[0] = replaceString;
            }
            String join = String.join("@", split);
            set.add(join);
        }
        return set.size();
    }

}
