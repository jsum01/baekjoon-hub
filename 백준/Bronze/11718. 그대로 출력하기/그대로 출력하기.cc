#include <bits/stdc++.h>

using namespace std;

int main() {
    const int MAX_LINES = 100;
    const int MAX_LENGTH = 100;
    vector<std::string> lines;
    string input;

    for (int i = 0; i < MAX_LINES; ++i) {
        getline(std::cin, input);

        if (input.empty()) {
            break; // 입력이 빈 줄일 경우 루프를 종료
        }

        if (input.length() > MAX_LENGTH) {
            input = input.substr(0, MAX_LENGTH); // 입력이 100자를 넘으면 자름
        }

        lines.push_back(input);
    }

    for (const auto &line: lines) {
        cout << line << '\n';
    }

    return 0;
}