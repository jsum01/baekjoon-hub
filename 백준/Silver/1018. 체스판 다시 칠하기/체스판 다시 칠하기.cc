#include <bits/stdc++.h>

using namespace std;

int countRepaints(const vector<string> &board, int x, int y, char startColor) {
    int repaints = 0;
    char expectedColor = startColor;

    for (int i = x; i < x + 8; ++i) {
        for (int j = y; j < y + 8; ++j) {
            if (board[i][j] != expectedColor) {
                repaints++;
            }
            // 다음 칸의 색상을 결정
            expectedColor = (expectedColor == 'W') ? 'B' : 'W';
        }
        // 다음 줄의 시작 색상은 이전 줄의 끝 색상과 달라야 함
        expectedColor = (expectedColor == 'W') ? 'B' : 'W';
    }
    return repaints;
}

int main() {
    int N, M;
    cin >> N >> M;

    vector<string> board(N);
    for (int i = 0; i < N; ++i) {
        cin >> board[i];
    }

    int minRepaints = 64; // 8x8 = 64, 최악의 경우 모든 칸을 다시 칠해야 함

    for (int i = 0; i <= N - 8; ++i) {
        for (int j = 0; j <= M - 8; ++j) {
            // 왼쪽 위 칸이 'W'인 경우와 'B'인 경우 각각을 체크
            int repaintsW = countRepaints(board, i, j, 'W');
            int repaintsB = countRepaints(board, i, j, 'B');

            // 최소 칠하기 수를 갱신
            int localMin = min(repaintsW, repaintsB);
            minRepaints = min(minRepaints, localMin);
        }
    }

    cout << minRepaints << endl;

    return 0;
}