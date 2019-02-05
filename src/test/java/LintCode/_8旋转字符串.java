package LintCode;

/**
 * https://www.lintcode.com/problem/rotate-string
 * 描述
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 *
 * 样例
 * 对于字符串 "abcdefg".
 *
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * 挑战
 * 在数组上原地旋转，使用O(1)的额外空间
 */
public class _8旋转字符串 {

    /**
     * 三步翻转法
     *
     * abcdef 3
     *
     * step1: abc def   根据offset分割成两个部分
     * step2: cba fed   翻转各自的部分
     * step3: def abc   整体翻转
     */
    public void rotateString(char[] str, int offset) {
        if(str == null || str.length <= 0){
            return;
        }

        int right = str.length - 1;
        offset %= str.length;
        rotateString(str, 0, right-offset);
        rotateString(str, right-offset+1, right);
        rotateString(str, 0, right);
    }

    public  void rotateString(char[] str, int left, int right) {
        while(left < right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 模拟人工位移
     */
    @Deprecated
    public void rotateString1(char[] str, int offset) {
        // 1. 偏移量为0 直接返回
        if(offset == 0){
            return;
        }
        // 2. 偏移量能被整除则分解成两部分执行, 避免无限循环
        if(str.length % offset == 0 && offset > 1){
            rotateString(str, offset-1);
            rotateString(str, 1);
            return;
        }

        int count = 0, index = 0, len = str.length;
        // 额外的空间
        char zoom = 'X';
        while(count <= len){
            int next = (index + offset + len) % len;
            // 第一次位移则取出到zoom空间保存
            if(count == 0){
                zoom = str[next];
                str[next] = str[index];
            } else {
                // 之后则每次和zoom空间替换
                char temp = str[next];
                str[next] = zoom;
                zoom = temp;
            }
            index += offset;
            count++;
        }
    }
}
