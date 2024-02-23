WITH ROOT_ITEM_IDS AS (
    SELECT
        ITEM_ID
    FROM
        ITEM_TREE
    WHERE
        PARENT_ITEM_ID IS NULL
)

SELECT
    ITEM_ID,
    ITEM_NAME
FROM
    ITEM_INFO ii
WHERE
    ii.ITEM_ID IN (
        SELECT
            ITEM_ID
        FROM
            ROOT_ITEM_IDS
        )
ORDER BY
    ITEM_ID ASC;