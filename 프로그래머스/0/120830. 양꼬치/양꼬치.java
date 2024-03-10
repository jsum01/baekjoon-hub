class Solution {
    public int solution(int n, int k) {
        
        // n: 인분(1인분 당 12,000), 10인분 당 음료수 1개 서비스
        // k: 음료수(1개 당 2,000)
        
        int answer = 0;

        int priceYang = n * 12000;
        int priceDrink = k * 2000;
        int priceService = n/10 * 2000;
        
        
        // 인분 * 12000 + 음료수 * 2000 - ( 인분 / 10 * 2000 )
        answer = priceYang + priceDrink - priceService;
        
        return answer;
    }
}