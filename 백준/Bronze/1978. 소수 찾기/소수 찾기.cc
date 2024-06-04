#include <bits/stdc++.h>

using namespace std;

bool isPrime(int num) {
    if (num == 1) return false;
    if (num == 2) return true;
    if (num > 2) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    else return false;
}

int main() {
    int size;
    cin >> size;
    int nums[size];
    // size번 입력받음
    int cnt = 0;
    for (int i = 0; i < size; i++) {
        cin >> nums[i];
        if (isPrime(nums[i]))
            cnt++;
    }
    cout << cnt;

    return 0;
}