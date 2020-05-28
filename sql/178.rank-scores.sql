--178. 分数排名
select 
scores.score, b.rank
from scores
left join (
select score , rownum as rank
from (
select
score
from scores
group by score
order by score desc
) a
) b on b.score = scores.score
order by scores.score desc