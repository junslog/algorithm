-- 어떤 ITEM의 ROOT가 아닌 아이템들 = 업그레이드 할 수 없는 아이템.

WITH NON_UPGRADABLE_IDS AS (
SELECT
    ITEM_ID
FROM
    ITEM_TREE
WHERE
    ITEM_ID NOT IN (
        SELECT 
            DISTINCT(PARENT_ITEM_ID)
        FROM
            ITEM_TREE
        WHERE
            PARENT_ITEM_ID IS NOT NULL
    )
)

SELECT
    ITEM_ID,
    ITEM_NAME,
    RARITY
FROM
    ITEM_INFO ii
WHERE
    ii.ITEM_ID IN (
        SELECT
            ITEM_ID
        FROM
            NON_UPGRADABLE_IDS
    )
ORDER BY
    ITEM_ID DESC