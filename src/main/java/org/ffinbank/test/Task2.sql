select c.name, a.acc_number, t.amount
from account as a
join fin_transaction as t ON a.id = t.account_id
join customer as c ON a.customer_id = c.id
where a.acc_number like '45204%'
group by t.amount
having sum(t.amount) > 0;