WITH 3_UPPER_USERS AS (
    SELECT
        WRITER_ID
    FROM
        USED_GOODS_BOARD
    GROUP BY
        WRITER_ID
    HAVING
        COUNT(*) >= 3
)

SELECT
    USER_ID,
    NICKNAME,
    CONCAT(CITY,' ',STREET_ADDRESS1,' ',STREET_ADDRESS2) as '전체주소',
    CONCAT(SUBSTR(TLNO,1,3),'-',SUBSTR(TLNO,4,4),'-',SUBSTR(TLNO,8,4)) as '전화번호'
FROM
    USED_GOODS_USER u
WHERE
    u.USER_ID IN (
        SELECT
            WRITER_ID
        FROM
            3_UPPER_USERS
    )
ORDER BY
    USER_ID DESC
