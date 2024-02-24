WITH 2022_04_13_APPOINTMENTS AS (
    SELECT
        APNT_NO,
        PT_NO, -- PT_NAME 과 연결
        MCDP_CD,
        MDDR_ID, -- DR_NAME과 연결
        APNT_YMD,
        APNT_CNCL_YN
    FROM
        APPOINTMENT
    WHERE
        DATE(APNT_YMD) = '2022-04-13'
)

SELECT
    ap.APNT_NO,
    p.PT_NAME,
    p.PT_NO,
    ap.MCDP_CD,
    d.DR_NAME,
    ap.APNT_YMD
FROM
    2022_04_13_APPOINTMENTS ap
INNER JOIN
    DOCTOR d
ON
    ap.MDDR_ID = d.DR_ID
INNER JOIN
    PATIENT p
ON
    ap.PT_NO = p.PT_NO
WHERE
    ap.APNT_CNCL_YN = 'N'
ORDER BY
    APNT_YMD ASC