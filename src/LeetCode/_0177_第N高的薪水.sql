# 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
#
# +------------------------+
# | getNthHighestSalary(2) |
# +------------------------+
# | 200                    |
# +------------------------+

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
  BEGIN
    RETURN (
      # 1. 判断 Salary 表记录数至少有 N 条, 否则直接返回 null
      select if((select count(distinct Salary) from Employee) >= N,

        # 3. 这时候, 前 N 高的薪水的最后一条, 肯定是第 N 高的薪水
                (select min(Salary)
                 from(
                       # 2. 根据 Salary 倒序, 获取前 N 高的薪水的记录
                       select distinct Salary
                       from Employee
                       order by Salary desc
                       limit N) tmp)
      , null) SecondHighestSalary
    );
  END