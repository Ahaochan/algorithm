# 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
#
# Customers 表：
# +----+-------+
# | Id | Name  |
# +----+-------+
# | 1  | Joe   |
# | 2  | Henry |
# | 3  | Sam   |
# | 4  | Max   |
# +----+-------+
#
# Orders 表：
# +----+------------+
# | Id | CustomerId |
# +----+------------+
# | 1  | 3          |
# | 2  | 1          |
# +----+------------+
#
# 例如给定上述表格，你的查询应返回：
# +-----------+
# | Customers |
# +-----------+
# | Henry     |
# | Max       |
# +-----------+

# 执行用时: 545 ms, 在Customers Who Never Order的MySQL提交中击败了44.45% 的用户
select c.Name Customers
from Customers c
left join Orders o on c.Id = o.CustomerId
where o.id is null

# 执行用时: 840 ms, 在Customers Who Never Order的MySQL提交中击败了10.10% 的用户
select c.Name Customers
from Customers c
where c.id not in ( select CustomerId from Orders )