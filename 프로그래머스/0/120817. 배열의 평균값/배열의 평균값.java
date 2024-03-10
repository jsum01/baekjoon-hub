class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        // numbers라는 배열의 평균 값을 return
        /*
            1. numbers 배열의 길이를 구합니다.
            2. numbers 배열의 원소들을 다 더합니다.
            3. numbers 배열의 원소들의 총 합을 배열의 길이로 나눕니다.
        */
        // 2. 배열 원소 총합 구하기
        int numbersTotal = 0;
        for(int i = 0; i < numbers.length; i++) {
            numbersTotal += numbers[i];
        }
        answer = (double) numbersTotal/numbers.length;
        
        return answer;
    }
}