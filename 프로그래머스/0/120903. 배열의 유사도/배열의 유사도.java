class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        int s1_size = s1.length;
        int s2_size = s2.length;
        
        for(String str : s1) {
            for(String str2: s2) {
                if(str.equals(str2)) answer++;
            }
            
        }
        return answer;
    }
}