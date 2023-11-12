#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    
    scanf("%d", &n); // input
    
    for (int i = 0; i <= n; i++ ) {
        int value = n - i; // create variable for storage of 1 ~ n
        if(value % 2 == 0) 
            answer += value; // 그리고 짝수라면 더함
    }
    
    return answer;
}