package 算法爱好者;

/**
 * Created by Ahaochan on 2017/7/31.
 * 假设支付宝红包口令支持1到6位的数字组合,
 * 即'0'、'1'、'003'、'999999'都是合法的红包口令,
 * 那么总共可以有多少个合法的红包口令
 */
public class 阿里_支付宝红包口令 {
    public static void main(String[] args) {

        int num = 0;
        for (int i = 1; i <= 6; i++) {
            // 长度为1的有10种, 0 1 2 3 4 5 6 7 8 9
            // 长度为2的有100种, 00, 01, 02, 03, ... 99
            // 依次类推
            num += Math.pow(10, i);
        }
        System.out.println(num);
    }
}
