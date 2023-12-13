-- 상품코드 별 매출액(판매가 * 판매량) 합계를 출력
-- 어떻게 출력? 매출액 내림차순 -> 상품코드 오름차순


-- GROUP BY 후 JOIN 하느냐,
-- JOIN 후 GROUP BY 하느냐 여기서 데이터 량과 분포에 따라 TRADE OFF이 발생함
-- 작성 코드는 위 2가지 오퍼레이션이 실행계획상 상호작용이 발생할 것으로 예측됨
SELECT P_CODE AS PRODUCT_CODE
     , SUM(TAKE_PRICE) AS SALES
FROM (
    SELECT P.PRODUCT_ID
        , P.PRODUCT_CODE AS P_CODE
        , P.PRICE * O.SALES_AMOUNT AS TAKE_PRICE
    FROM PRODUCT P, OFFLINE_SALE O
    WHERE P.PRODUCT_ID = O.PRODUCT_ID
)
GROUP BY P_CODE
ORDER BY SALES DESC, P_CODE ASC;

