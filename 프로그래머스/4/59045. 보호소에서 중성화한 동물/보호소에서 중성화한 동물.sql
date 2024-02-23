WITH INTACT_IN_ANIMALS AS (
    SELECT
        ANIMAL_ID
    FROM
        ANIMAL_INS
    WHERE
        SEX_UPON_INTAKE LIKE 'Intact%'
)

SELECT
    ao.ANIMAL_ID,
    ao.ANIMAL_TYPE,
    ao.NAME
FROM
    ANIMAL_OUTS ao
WHERE
    ( ao.SEX_UPON_OUTCOME LIKE 'Spayed%' OR ao.SEX_UPON_OUTCOME LIKE 'Neutered%')
AND
    ao.ANIMAL_ID IN (
        SELECT
            ANIMAL_ID
        FROM
            INTACT_IN_ANIMALS
    )
ORDER BY
    ANIMAL_ID ASC