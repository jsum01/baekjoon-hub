#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> v;

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }


    sort(v.begin(), v.end());
    if (n == 1) {
        int temp = v.front();
        cout << temp * temp;
        return 0;
    }
    cout << v[0] * v[n - 1];


}