-- /home/grep/src/BOARD_ID/FILE_ID + FILE_NAME + FILE_EXT

WITH MOST_VIEWED_BOARD AS (
    SELECT
        BOARD_ID
    FROM
        USED_GOODS_BOARD
    ORDER BY
        VIEWS DESC
    LIMIT
        1
)

SELECT
    CONCAT('/home/grep/src/', ugf.BOARD_ID, '/', ugf.FILE_ID, ugf.FILE_NAME, ugf.FILE_EXT) as FILE_PATH
FROM
    USED_GOODS_FILE ugf
WHERE
    ugf.BOARD_ID = (
        SELECT
            BOARD_ID
        FROM
            MOST_VIEWED_BOARD
    )
ORDER BY
    ugf.FILE_ID DESC
