class Solution {
    public int[] solution(String[] strlist) {
        int arrLen = strlist.length;
        int[] answer = new int[arrLen];
        
        for(int i = 0; i < arrLen; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}