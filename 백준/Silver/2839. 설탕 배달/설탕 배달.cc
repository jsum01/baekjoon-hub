#include <bits/stdc++.h>

using namespace std;

int main() {
    // N kg 배달해야 함
    // 3kg 5kg 봉지로만 가능
    // 상근이는 귀찮아서 최대한 적은 봉지를 들고가고 싶음
    int n;
    cin >> n;
    int result = 0;
    while (n >= 0) {
        if (n % 5 == 0) {
            result += n / 5;
            cout << result << "\n";
            return 0;
        }
        n -= 3;
        result++;
    }
    cout << -1 << "\n";

    return 0;
}