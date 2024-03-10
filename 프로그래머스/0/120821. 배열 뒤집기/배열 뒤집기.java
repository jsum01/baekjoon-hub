class Solution {
    public int[] solution(int[] num_list) {
        
        int len = num_list.length;
        
        int[] answer = new int[len]; // 배열의 크기를 초기화해주어야 합니다.
        
        
        for(int i = 0; i < len; i++) {
            answer[i] = num_list[(len - 1) - i];
        }
        return answer;
    }
}