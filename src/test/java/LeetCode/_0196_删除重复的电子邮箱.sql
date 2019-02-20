# https://leetcode-cn.com/problems/delete-duplicate-emails/
# 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
#
# Id 是这个表的主键。
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
#
# 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# +----+------------------+


# https://stackoverflow.com/questions/4471277/mysql-delete-from-with-subquery-as-condition
delete from Person where Id not in
(select Id from (select min(Id) Id from Person group by Email) tmp )