-- 입양 못 간 동물 중, 가장 보호소에 오래 있던 순으로 출력
-- 무엇을? 이름과 보호 시작일
-- 얼만큼? 3마리
-- 어떻게? 보호 시작일 순으로 조회(오름차순)
-- 요약: OUTS엔 없는데 INS에 있는 동물 중 보호 시작일이 가장 오래 된 3마리를 출력
SELECT INS.NAME
    , INS.DATETIME
FROM ANIMAL_INS INS, ANIMAL_OUTS OUTS
WHERE INS.ANIMAL_ID = OUTS.ANIMAL_ID(+)
AND OUTS.ANIMAL_ID IS NULL
ORDER BY INS.DATETIME ASC
FETCH FIRST 3 ROWS ONLY;