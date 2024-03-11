class Solution {
    public int solution(int n, int t) {
        /*
            n: 세균 마리 수
            t: 경과 시간
        */
        int answer = 0;
        int pow = (int) Math.pow(2, t);
        answer = n * pow;
        return answer;
    }
}