select
    count(*) as `COUNT`
from
    ecoli_data ed
where
    ed.genotype & 2 = 0
and
    (ed.genotype | 1 = ed.genotype
or
    ed.genotype | 4 = ed.genotype)