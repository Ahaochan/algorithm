# https://leetcode-cn.com/problems/tenth-line/
# 给定一个文本文件 file.txt，请只打印这个文件中的第十行。
#
# 你可以假设一个有效的电话号码必须满足以下两种格式： (xxx) xxx-xxxx 或 xxx-xxx-xxxx。（x 表示一个数字）
#
# 你也可以假设每行前后没有多余的空格字符。

#!/bin/bash
sed -n '10p' file.txt
awk 'NR==10' file.txt