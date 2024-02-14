WITH AVAILABLE_CARS AS(
    SELECT
        CAR_ID,
        CAR_TYPE,
        DAILY_FEE
    FROM
        CAR_RENTAL_COMPANY_CAR
    WHERE
        CAR_TYPE IN ('세단', 'SUV')
        AND
        CAR_ID NOT IN (
            SELECT
                CAR_ID
            FROM
                CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE
                START_DATE <= '2022-11-30'
            AND
                END_DATE >= '2022-11-01'
        )
)

SELECT
    ac.CAR_ID,
    ac.CAR_TYPE,
    FLOOR(DAILY_FEE * (1 - 0.01 * DISCOUNT_RATE) * 30) as FEE
FROM
    AVAILABLE_CARS ac
INNER JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
ON
    ac.CAR_TYPE = p.CAR_TYPE
WHERE
    p.DURATION_TYPE = '30일 이상'
    AND
    30 * ac.DAILY_FEE * (1 - 0.01 * p.DISCOUNT_RATE) 
    BETWEEN 500000 AND 1999999
ORDER BY
    FEE DESC, CAR_TYPE ASC, CAR_ID DESC;