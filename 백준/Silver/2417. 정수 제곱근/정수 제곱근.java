import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * 정수가 주어지면, 그 수의 정수 제곱근을 구하는 프로그램
 *
 * [ 입력 ]
 * 정수 n ( 0 <= n <= 2^63) -> 8byte : long을 사용해야 함
 *
 * [ 출력 ]
 * q^2 >= n인 가장 작은 음이 아닌 정수 q를 출력
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine().trim());

        if (!isNormalRange(n)) throw new IllegalArgumentException();

        long result = findSquareRoot(n);

        bw.write(result + "\n");
        bw.flush();
    }

    private static boolean isNormalRange(long n) {
        return n >= 0 && n <= Math.pow(2, 63);
    }

    private static long findSquareRoot(long n) {
        long left = 0;
        long right = n;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if ((double) mid * mid >= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
