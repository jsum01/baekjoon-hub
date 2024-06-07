#include <bits/stdc++.h>

using namespace std;

int main() {
    // n개 좌표
    // 좌표 정렬(x좌표가 증가하는 순, x좌표가 같으면 y좌표가 증가하는 순)

    int n;
    cin >> n;

    vector<pair<int, int>> vCoordinate(n);
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        vCoordinate[i] = {x, y};
    }
    sort(vCoordinate.begin(), vCoordinate.end());

    for (int i = 0; i < vCoordinate.size(); i++) {
        cout << vCoordinate[i].first << " " << vCoordinate[i].second << "\n";
    }
}