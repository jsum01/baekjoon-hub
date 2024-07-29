import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [ Precondition ]
 * - It can as shine as the height of the street light.
 * - is Integer
 * - height is equal
 *
 * [ Input ]
 * Line 1 - 굴다리 N (1~100,000)
 * Line 2 - 가로등 개수 M (1~N)
 * Line 3 - 설치할 수 있는 가로등 위치 X (오름차순으로 입력, 중복X, 정수)
 *
 * [ Output ]
 * 굴다리의 길이 N을 모두 비추기 위한 가로등의 최소 높이 출력
 */
public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0; // 최소 높이

        int N = Integer.parseInt(reader.readLine().trim()); // 굴다리 길이
        int M = Integer.parseInt(reader.readLine().trim()); // 가로등 개수
        int[] x = new int[M]; // 가로등의 좌표 x

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < M; i++) {
            int coordinate = Integer.parseInt(st.nextToken());
            x[i] = coordinate;
        }

        result = getMinimunLength(x, N);

        System.out.println(result);
    }

    private static int getMinimunLength(int[] x, int N) {
        int low = 1; // 최소 높이
        int high = N; // 최대 높이
        int res = 0; // 응답할 값(=찾은 최소 높이)

        while (low <=high) {
            int mid = (low+high)/2; // 중간값
            boolean flag = true; //

            // mid 높이로도 굴다리를 모두 비출 수 있는지 확인
            int lastIlluminated = 0; // 가로등 위치
            for(int i = 0; i < x.length; i++) {
                if(x[i] - mid <= lastIlluminated) { // i번째 가로등이 높이의 중간값
                    lastIlluminated = x[i] + mid; //
                } else {
                    flag = false; // 모두 비출 수 없음
                }
            }
            // 마지막 가로등부터 끝지점도 확인
            if (N - lastIlluminated > 0)
                flag = false; // 모두 비출 수 없음
            else flag = true;

            if (flag) { // 모두를 비출 수 있음
                res = mid; // 갱신
                high = mid - 1; // 다음 단계로
            } else { // 모두 비출 수 없음
                low = mid + 1; // 다음 단계로
            }
        }

        return res;
    }
}
