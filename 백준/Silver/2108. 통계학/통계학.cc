#include <bits/stdc++.h>
/**
 * 문제
 * 문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
 */
#define LL long long
using namespace std;

int getMean(int arr[], int size) {
    LL total = 0;
    for (int i = 0; i < size; i++) {
        total += (LL) arr[i];
    }
    return round((double) total / size); // 반올림한 값을 출력
}

int getMedian(int arr[], int size) {
    int midIndex = round(size / 2);
    return arr[midIndex];
}

int getMode(int arr[], int size) {
    int frequency[8001] = {0}; // 빈도수를 저장할 배열 (인덱스 0~8000, 실제 값 -4000~4000)
    for (int i = 0; i < size; i++) {
        frequency[arr[i] + 4000]++; // 값의 범위가 -4000에서 4000이므로 +4000으로 변환
    }

    int maxFreq = 0; // 최빈값의 빈도수
    vector<int> modes; // 최빈값을 저장할 벡터

    for (int i = 0; i < 8001; i++) {
        if (frequency[i] > maxFreq) {
            maxFreq = frequency[i];
            modes.clear();
            modes.push_back(i - 4000);
        } else if (frequency[i] == maxFreq) {
            modes.push_back(i - 4000);
        }
    }

    // 최빈값이 여러 개일 경우 두 번째로 작은 값을 반환
    if (modes.size() > 1) {
        return modes[1];
    } else {
        return modes[0];
    }
}

int getRange(int arr[], int size) {
    if (size > 1)
        return arr[size - 1] - arr[0];
    else
        return 0;
}

int main() {
    int inputCapacity; // 입력 개수
    cin >> inputCapacity;
    if (inputCapacity % 2 == 1) {
        int nums[inputCapacity]; // number Store
        for (int i = 0; i < inputCapacity; i++) {
            cin >> nums[i]; // N개 만큼 입력
            if (abs(nums[i]) > 4000) {
                exit(0);
            }
        }
        sort(nums, nums + inputCapacity); // 파라미터로 전달하기 전, 정렬작업
        cout << getMean(nums, inputCapacity) << "\n";
        cout << getMedian(nums, inputCapacity) << "\n";
        cout << getMode(nums, inputCapacity) << "\n";
        cout << getRange(nums, inputCapacity) << "\n";
    } else
        cout << "홀수를 입력하셔야 합니다.";
}