package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 * 题目描述:
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 解题思路
 * 语法题
 */
public class _1108_IP地址无效化 {
    @Test
    public void test1() {
        Assert.assertEquals("1[.]1[.]1[.]1", defangIPaddr("1.1.1.1"));
        Assert.assertEquals("255[.]100[.]50[.]0", defangIPaddr("255.100.50.0"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/23146113/
     * 执行用时 :1 ms, 在所有 Java 提交中击败了97.74%的用户
     * 内存消耗 :35 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public String defangIPaddr(String address) {
        int len = address.length();
        StringBuilder sb = new StringBuilder(len + 6);
        for (int i = 0; i < len; i++) {
            char ch = address.charAt(i);
            if(ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
