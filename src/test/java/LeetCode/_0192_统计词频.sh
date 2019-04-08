# https://leetcode-cn.com/problems/word-frequency/
# 写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。
#
# 为了简单起见，你可以假设：
#
# words.txt只包括小写字母和 ' ' 。
# 每个单词只由小写字母组成。
# 单词间由一个或多个空格字符分隔。
# 示例:
#
# 假设 words.txt 内容如下：
#
# the day is sunny the the
# the sunny is is
# 你的脚本应当输出（以词频降序排列）：
#
# the 4
# is 3
# sunny 2
# day 1
# 说明:
#
# 不要担心词频相同的单词的排序问题，每个单词出现的频率都是唯一的。
# 你可以使用一行 Unix pipes 实现吗？

#!/bin/bash
awk '{for(i=1;i<=NF;i++){res[$i]++}}END{for(i in res){print i" "res[i]}}' words.txt | sort -nr -k2

# 1. awk 分为三个部分, BEGIN, pattern, END
#    awk [option] '[BEGIN{awk 操作命令}]pattern{awk 操作命令}[END{awk 操作命令}]' file(s)
#    默认以空格做分割, NF表示分割的片段的数量, 所以做 for(i --> NF) 循环
#
# 2. 因为 $0 是表示整行, 所以要从1开始 for(1 --> NF), 只统计片段
#    $i 表示 第i个片段
#
# 3. 统计完毕后, 进入END部分
#    那么for循环打印出来即可
#
# 4. 使用管道符对后续结果进行排序, -n表示按数值排序, -r表示倒序, -k表示按第二栏排序, 即按统计次数排序
