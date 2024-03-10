class Solution {
    /** 문제 설명
        
        전제: 피자 7등분
        n: 나눠 먹을 사람 수
        
        해결사항: 모든 사람(n)이 한 조각 이상 먹기 위해 필요한 피자 수
    */
    public int solution(int n) {
        int answer = 0;
        // n / 7 에서 반올림(round 메소드 사용)
        double modValue = (double) n / 7.0;
        answer = (int) Math.ceil(modValue);
        
        return answer;
    }
}