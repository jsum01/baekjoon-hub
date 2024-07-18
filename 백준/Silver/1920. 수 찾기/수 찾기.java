import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 문제 설명
 * 1. 첫째 줄에 자연수 N 입력(1 <= N <= 100,000)
 * 2. 둘째 줄에 N개의 정수 입력.
 * 3. 셋째 줄에 자연수 M 입력(1 <= N <= 100,000)
 * 4. 넷째 줄에 M개의 정수 입력
 * 넷째 줄에 입력한 수들이 둘째 줄에 입력한 수 중 존재하는지 알아낸다.
 * 존재하면 1, 존재하지 않으면 0을 출력
 *
 * [조건]
 * 시간제한: 1초
 * 메모리 제한: 128MB
 * 정수 크기: 모든 정수의 크기는 +-32bit 여야 한다.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M;
    static List<Integer> Nlist = new ArrayList<>();
    static List<Integer> Mlist = new ArrayList<>();

    public static void main(String[] args) {
        input();

        Collections.sort(Nlist);

        for(int i = 0; i < Mlist.size(); i++) {
            int key = Mlist.get(i);
            if(binarySearch(Nlist, key)) { // 찾았을 경우
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static void input() {
        N = sc.nextInt();
        for (int i = 0; i < N; i++) { // N번 입력
            Nlist.add(sc.nextInt());
        }
        M = sc.nextInt();
        for (int i = 0; i < M; i++) { // M번 입력
            Mlist.add(sc.nextInt());
        }
    }

    private static boolean binarySearch(List<Integer> arr, int key) {
        int start = 0;
        int end = arr.size() - 1;
        boolean isFind = false;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(key > arr.get(mid)) { // 찾는 값이 중간 값보다 큰 경우
                start = mid + 1;
            } else if(key < arr.get(mid)) { // 찾는 값이 중간 값보다 작은 경우
                end = mid - 1;
            } else { // 찾았다!
                return true;
            }
        }
        return false;
    }
}
