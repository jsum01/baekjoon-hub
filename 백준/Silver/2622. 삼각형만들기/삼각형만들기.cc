#include <bits/stdc++.h>

using namespace std;
// declare
int n;
int cnt = 0;

void input() {
    cin >> n;
}

void output() {
    cout << cnt;
}

void solution() {
    
    for(int a = 0; a < n; a++) {
        for(int b = a; b < n; b++) {
            int c = n - (a+b);
            if(c < b) break;
            if(b+a>c) cnt++;
        }
    }
}

int main() {
    input();
    solution();
    output();
    return 0;
}