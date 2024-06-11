#include <bits/stdc++.h>

using namespace std;


int N, K;
queue<int> q;
vector<int> result;


int main() {

    cin >> N >> K;

    for (int i = 1; i <= N; i++) {
        q.push(i); // 데이터를 넣어줍니다.
    }

    while (!q.empty()) {
        for (int i = 0; i < K - 1; i++) {
            q.push(q.front());
            q.pop();
        }
        result.push_back(q.front());
        q.pop();
    }

    // 요세푸스 순열 출력
    cout << "<";
    for (size_t i = 0; i < result.size(); ++i) {
        cout << result[i];
        if (i < result.size() - 1) {
            cout << ", ";
        }
    }
    cout << ">" << endl;


    return 0;
}