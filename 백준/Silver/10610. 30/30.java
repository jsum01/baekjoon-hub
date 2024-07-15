import java.util.*;

import static java.lang.System.exit;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String N;
    static List<Integer> intList = new ArrayList<>(5); // 5자리 수까지

    public static void main(String[] args) {
        input();
        String result = getResult();
        print(result);
    }

    private static void print(String content) {
        System.out.println(content);
        exit(0);
    }

    private static void input() {
        N = sc.nextLine(); // 입력
        if (N.startsWith("0")) {
            print("-1");
        }
    }

    /**
     * 1. 각 자리수를 개별적으로 리스트에 저장
     * 2. 30의 배수인지를 확인
     * 3. 숫자들을 큰 순서대로 정렬하여 가장 큰 수를 반환
     */
    private static String getResult() {
        boolean hasZero = false;
        int sum = 0;

        for (int i = 0; i < N.length(); i++) {
            int num = Integer.parseInt(N.substring(i, i + 1));
            if (num == 0) {
                hasZero = true;
            }
            sum += num;
            intList.add(num); // 각 자리수를 리스트에 저장
        }

        if (!hasZero || sum % 3 != 0) {
            return "-1"; // 0이 없거나, 숫자 합이 3의 배수가 아니면 30의 배수가 될 수 없음
        }

        // 큰 순서대로 정렬
        Collections.sort(intList, Collections.reverseOrder());

        // 리스트를 문자열로 변환하여 결과를 생성
        StringBuilder sb = new StringBuilder();
        for (int num : intList) {
            sb.append(num);
        }

        return sb.toString();
    }
}
