class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        // 카피한 문자열 이중 for문으로 역순배치
        for(int i = 0; i < my_string.length(); i++) {
            answer = answer + my_string.charAt((my_string.length() - 1) - i);
        }
        
        return answer;
    }
}