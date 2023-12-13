-- hint_1) JULY 테이블에 FIRST_HALF테이블에는 없는 SHIMENT_ID가 존재한다. 결과는 모든 아이스크림 맛의 총주문량을 포함해야 하므로 양 쪽 데이터가 모두 포함되어야 한다. :: FULL OUTER JOIN을 사용해야 함.
-- hint_2) 컬럼으로는 FLAVOR하나만 있으면 된다. 그러니 SELECT FLAVOR FROM (SUB_QUERY)의 형식으로 진행.
SELECT FLAVOR
FROM (
    SELECT F.FLAVOR, NVL(SUM(F.TOTAL_ORDER), 0) + NVL(SUM(J.TOTAL_ORDER), 0) AS TOTAL
    FROM FIRST_HALF F
    LEFT JOIN JULY J ON F.FLAVOR = J.FLAVOR
    GROUP BY F.FLAVOR
) CombinedOrders
ORDER BY TOTAL DESC
FETCH FIRST 3 ROWS ONLY;
