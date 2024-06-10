#include <bits/stdc++.h>

using namespace std;

int M, N;
vector<int> primes; // 소수를 저장할 벡터

bool isPrime(int num) {
    if (num <= 1) return false; // 1 이하는 소수가 아님
    for (int i = 2; i * i <= num; ++i) {
        if (num % i == 0) return false; // num이 i로 나누어 떨어지면 소수가 아님
    }
    return true;
}

void getPrimeNumbers(int m, int n) {
    for (int i = m; i <= n; ++i) {
        if (isPrime(i)) {
            primes.push_back(i); // 소수이면 벡터에 추가
        }
    }
}

int main() {
    cin >> M >> N;

    getPrimeNumbers(M, N);

    if (primes.empty()) {
        cout << -1 << endl; // 소수가 없으면 -1 출력
    } else {
        int sum = accumulate(primes.begin(), primes.end(), 0); // 소수 합 계산
        int minPrime = *min_element(primes.begin(), primes.end()); // 소수 중 최소값 찾기

        cout << sum << endl;
        cout << minPrime << endl;
    }

    return 0;
}
