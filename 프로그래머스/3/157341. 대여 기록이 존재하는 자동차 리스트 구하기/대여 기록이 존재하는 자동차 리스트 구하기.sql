-- 세단인 종류 자동차 아이디 추출
WITH SEDAN_IDS AS (
    SELECT
        CAR_ID
    FROM
        CAR_RENTAL_COMPANY_CAR
    WHERE
        CAR_TYPE = '세단'
)

SELECT
    DISTINCT(CAR_ID)
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY rh
WHERE
    ( rh.CAR_ID IN (
        SELECT
            CAR_ID
        FROM
            SEDAN_IDS
    ) )
AND
    MONTH(rh.START_DATE) = 10
ORDER BY
    CAR_ID DESC