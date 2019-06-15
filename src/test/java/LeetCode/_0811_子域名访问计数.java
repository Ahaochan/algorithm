package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subdomain-visit-count/
 * 题目描述:
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 *
 * 解题思路
 * 业务逻辑题, 考API熟练度
 */
public class _0811_子域名访问计数 {
    @Test
    public void test1() {
        List<String> actual = subdomainVisits("9001 discuss.leetcode.com");
        List<String> expect = Arrays.asList("9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test2() {
        List<String> actual = subdomainVisits("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org");
        List<String> expect = Arrays.asList("951 com", "900 google.mail.com", "1 intel.mail.com", "5 org", "5 wiki.org", "901 mail.com", "50 yahoo.com");
        Assert.assertEquals(expect, actual);
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20704026/
     * 执行用时 :32 ms, 在所有Java提交中击败了65.96%的用户
     * 内存消耗 :49.4 MB, 在所有Java提交中击败了69.95%的用户
     */
    public List<String> subdomainVisits(String... cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = splitWorker(cpdomain, ' ', false);

            Integer count = Integer.valueOf(split[0]);
            String[] domains = splitWorker(split[1], '.', false);

            StringBuilder temp = new StringBuilder();
            for (int i = domains.length - 1; i >= 0 ; i--) {
                String domain = domains[i];
                if(temp.length() != 0) {
                    temp.insert(0, '.');
                }
                temp.insert(0, domain);
                map.put(temp.toString(), map.getOrDefault(temp.toString(), 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    /**
     * copy from apache common
     */
    private String[] splitWorker(String str, char separatorChar, final boolean preserveAllTokens) {
        if (str == null) {
            return null;
        }
        final int len = str.length();
        if (len == 0) {
            return new String[0];
        }
        final List<String> list = new ArrayList<>();
        int i = 0, start = 0;
        boolean match = false;
        boolean lastMatch = false;
        while (i < len) {
            if (str.charAt(i) == separatorChar) {
                if (match || preserveAllTokens) {
                    list.add(str.substring(start, i));
                    match = false;
                    lastMatch = true;
                }
                start = ++i;
                continue;
            }
            lastMatch = false;
            match = true;
            i++;
        }
        if (match || preserveAllTokens && lastMatch) {
            list.add(str.substring(start, i));
        }
        return list.toArray(new String[list.size()]);
    }
}
