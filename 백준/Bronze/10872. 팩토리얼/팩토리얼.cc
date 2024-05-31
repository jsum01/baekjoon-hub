#include <bits/stdc++.h>

#define LL long long
using namespace std;
// 재귀 함수
//int factorial(int n) {
//    if (n <= 2) return n;
//    else return n * factorial(n - 1);
//}

int main() {
    int n;
    cin >> n;
    if (n <= 1) cout << 1;
    if (n >= 2 && n <= 12) {
//        cout << factorial(n); 재귀 코드
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        cout << result;
    };
}

