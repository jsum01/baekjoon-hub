-- CAL_RENTAL_COMPANY_CAR(대여중인 자동차 정보)
-- CAL_RENTAL_COMPANY_RENTAL_HISTORY(자동차 대여 기록 정보)
-- CAL_RENTAL_COMPANY_DISCOUNT_PLAN(차종 별 대여기간 종류 별 할인 정책 정보)

-- 차종이 세단, SUV인 자동차 중 2022년 11월 동안 대여가 가능하고
-- 30일간 대여 금액이 50이상 200미만인 자동차를
-- 자동차 ID, 자동차 종류, 대여금액(컬럼명: FEE)로 출력
-- 대여 금액 기준 내림차순, 자동차 종류 기준 오름차순, 자동차 ID 내림차순

-- FEE 계산
-- 일수 * 1일당 대여금 * 차종별, 일수별 할인률
WITH TMP AS (
    -- TMP 서브쿼리: '세단' 또는 'SUV' 차종 중 30일 이상 대여 기간에 대한 대여 금액 계산
    SELECT
        A.CAR_ID,
        A.CAR_TYPE,
        DAILY_FEE * ((100 - B.DISCOUNT_RATE) / 100) * 30 AS FEE
    FROM
        CAR_RENTAL_COMPANY_CAR A,
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN B
    WHERE
        A.CAR_TYPE = B.CAR_TYPE
        AND A.CAR_TYPE IN ('세단', 'SUV')
        AND B.DURATION_TYPE = '30일 이상'
        AND A.CAR_ID NOT IN (
            -- 대여 기록이 있는 자동차 제외
            SELECT DISTINCT A.CAR_ID
            FROM CAR_RENTAL_COMPANY_CAR A,
                 CAR_RENTAL_COMPANY_RENTAL_HISTORY B
            WHERE A.CAR_ID = B.CAR_ID
              AND NOT (
                  TO_CHAR(START_DATE, 'YYYYMMDD') > '20221130'
                  OR TO_CHAR(END_DATE, 'YYYYMMDD') < '20221101'
              )
        )
)
-- 최종 결과: 대여 금액이 50만원 이상 200만원 미만인 자동차 선택하여 정렬하여 출력
SELECT *
FROM TMP
WHERE FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;
