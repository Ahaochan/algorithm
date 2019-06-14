package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 * 题目描述:
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * 例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。
 * 我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 解题思路
 * Set一下就好了
 */
public class _0804_唯一摩尔斯密码词 {
    @Test
    public void test1() {
        Assert.assertEquals(2, uniqueMorseRepresentations("gin", "zen", "gig", "msg"));
    }

    /**
     * https://leetcode-cn.com/submissions/detail/20656135/
     * 执行用时 : 5 ms, 在所有Java提交中击败了 71.07% 的用户
     * 内存消耗 : 34.6 MB, 在所有Java提交中击败了 91.72% 的用户
     */
    public int uniqueMorseRepresentations(String... words) {
        String[] DICT = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            int len = word.length();
            StringBuilder sb = new StringBuilder(len * 3);
            for (int i = 0; i < len; i++) {
                sb.append(DICT[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
