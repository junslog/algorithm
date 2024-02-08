WITH TEMP AS (
    SELECT
        CATEGORY,
        MAX(PRICE) AS MAX_PRICE
    FROM
        FOOD_PRODUCT
    WHERE
        CATEGORY IN ('과자', '국', '김치', '식용유')
    GROUP BY
        CATEGORY
), TEMP2 AS(
    SELECT
        fp.CATEGORY,
        PRODUCT_NAME
    FROM
        FOOD_PRODUCT fp
    WHERE
        PRICE = (
            SELECT
                MAX(PRICE)
            FROM
                FOOD_PRODUCT fp2
            WHERE
                fp2.CATEGORY = fp.CATEGORY
        )
    GROUP BY
        fp.CATEGORY
)

SELECT
    t.CATEGORY,
    MAX_PRICE,
    PRODUCT_NAME
FROM
    TEMP t
JOIN
    TEMP2 t2
ON 
    t.CATEGORY = t2.CATEGORY
ORDER BY
    MAX_PRICE DESC;

