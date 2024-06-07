#include <bits/stdc++.h>

using namespace std;

int main() {

    int n;
    cin >> n;

    vector<string> v(n);
    for (int i = 0; i < n; i++) {
        string input;
        cin >> input;
        v[i] = input;
        // Exception
        bool isSizeCheck_v = v[i].size() >= 2 && v[i].size() <= 50;
        if (!isSizeCheck_v)
            exit(0);
    }


    for (int i = 0; i < n; i++) {
        int PScount = 0;
        for (int j = 0; j < v[i].size(); j++) {
            if (v[i][j] == '(')
                PScount++;
            else if (v[i][j] == ')') {
                PScount--;
                if (PScount < 0) {
                    break;
                }
            }
        }

        if (PScount == 0)
            cout << "YES\n";
        else
            cout << "NO\n";
    }

    return 0;
}