package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/heaters/
 * 题目描述:
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 解题思路
 * 暴力破解, 一个房屋, 要么被前一个加热器覆盖, 要么被后一个加热器覆盖.
 */
public class _0475_供暖器 {
    @Test
    public void test1() {
        Assert.assertEquals(1, findRadius(new int[]{1, 2, 3}, new int[]{2}));
        Assert.assertEquals(1, findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        Assert.assertEquals(0, findRadius(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        Assert.assertEquals(161834419, findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int index = 0;
        int r = heaters[0], l = -r; // 保留下标
        int min = 0;
        for (int house : houses) {

            while (house > r && index < heaters.length) {
                index++;
                if (index < heaters.length) {
                    l = r;
                    r = heaters[index];
                } else {
                    l = heaters[index - 1];
                    r = Integer.MAX_VALUE;
                }
            }
            if (house > l && house < r) {
                min = Math.max(min, Math.min(house - l, r - house));
            }

        }
        return min;
    }

    /**
     * 暴力超时
     */
    public int findRadius_force(int[] houses, int[] heaters) {
        int max = 0;
        for (int house : houses) {
            int min = Integer.MAX_VALUE;
            for (int heater : heaters) {
                min = Math.min(min, Math.abs(house - heater));
            }
            max = Math.max(max, min);
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/submissions/detail/22391261/
     * 执行用时 :33 ms, 在所有 Java 提交中击败了27.95%的用户
     * 内存消耗 :49.2 MB, 在所有 Java 提交中击败了46.89%的用户
     */
    public int findRadius_binary(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0, heatersLen = heaters.length;
        for (int house : houses) {
            int min = Integer.MAX_VALUE;

            int l = 0, r = heatersLen - 1, mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if(house > heaters[mid]) {
                    l = mid + 1;
                } else if (house < heaters[mid]) {
                    r = mid - 1;
                } else {
                    min = Math.abs(house - heaters[mid]);
                    break;
                }
            }
            if(min == Integer.MAX_VALUE) {
                int l1 = l-1 >= 0 && l-1 < heatersLen ? Math.abs(house - heaters[l-1]) : Integer.MAX_VALUE;
                int l2 = l   >= 0 && l   < heatersLen ? Math.abs(house - heaters[l]  ) : Integer.MAX_VALUE;
                int l3 = l+1 >= 0 && l+1 < heatersLen ? Math.abs(house - heaters[l+1]) : Integer.MAX_VALUE;
                min = Math.min(l1, Math.min(l2, l3));

            }
            max = Math.max(max, min);
        }
        return max;
    }
}
