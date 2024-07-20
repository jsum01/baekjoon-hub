import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N, M; // 책의 수와 신청서의 수
    static ArrayList<Integer>[] adj; // adj: 인접연산자 -> 책과 학생의 매칭을 나타내는 인접 리스트
    static int[] book; // 각 학생에게 할당된 책 번호를 저장하기 위함
    static boolean[] visited; // DFS 중 방문한 학생을 추적 위함

    public static void main(String[] args) {
        int testCases = sc.nextInt(); // 테스트 케이스 수 입력

        for (int t = 0; t < testCases; t++) {
            N = sc.nextInt(); // 책의 수 입력
            M = sc.nextInt(); // 신청서의 수 입력
            adj = new ArrayList[N + 1]; // 책의 인접 리스트 초기화
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>(); // 각 책의 연결 리스트 초기화
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt(); // 신청 범위의 시작 번호
                int b = sc.nextInt(); // 신청 범위의 끝 번호
                for (int j = a; j <= b; j++) {
                    adj[j].add(i + 1); // 책 번호 j에 대해 학생 i+1을 연결
                }
            }

            book = new int[M + 1]; // 학생의 책 할당 배열 초기화
            int matchCount = 0; // 최대 매칭 수 초기화

            for (int i = 1; i <= N; i++) {
                visited = new boolean[M + 1]; // 방문 배열 초기화
                if (dfs(i)) { // DFS를 통해 매칭을 찾으면
                    matchCount++; // 매칭 수 증가
                }
            }

            System.out.println(matchCount); // 최대 매칭 수 출력
        }
    }

    static boolean dfs(int x) {
        for (int student : adj[x]) { // 책 x에 연결된 학생들을 순회
            if (visited[student]) continue; // 이미 방문한 학생이면 건너뜀
            visited[student] = true; // 학생을 방문 표시

            if (book[student] == 0 || dfs(book[student])) { // 학생이 책을 할당받지 않았거나, 재귀적으로 할당 가능하면
                book[student] = x; // 학생에게 책 x를 할당
                return true; // 매칭 성공
            }
        }
        return false; // 매칭 실패
    }
}
