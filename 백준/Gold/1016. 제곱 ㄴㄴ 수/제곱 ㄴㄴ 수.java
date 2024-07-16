import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // 제곱 ㄴㄴ수: 어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수
    // 입력 Min, Max
    // 출력 Min ~ Max 사이의 제곱 ㄴㄴ수의 개수

    /**
     * 1. min, max 입력
     * 2. min ~ max 사이의 정수인 제곱수 9함(1 은 제외)
     * 3. 해당 제곱수로 나누어지지 않는 수의 개수 구함
     */
    static Scanner sc = new Scanner(System.in);
    static long min, max;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        init();
        getZegopNoNoSu();
        print();
    }

    /**
     * 1. 정수의 제곱수를 구한다.
     * 2. 제곱수를 리스트에 추가
     *
     * @return List<Long>
     */
    private static List<Long> getZegopsu() {
        List<Long> zegopsuList = new ArrayList<>();
        long sqrtMax = (long) Math.sqrt(max);
        for (long i = 2; i <= sqrtMax; i++) {
            long square = i * i;
            zegopsuList.add(square); // 제곱수 리스트에 추가
        }
        return zegopsuList;
    }

    /**
     * 1. min ~ max 사이의 총 정수의 개수를 구한다.
     * 2. 제곱수를 구하는 메소드에서 구한 제곱수 리스트의 원소들로 나누어 떨어질 때마다 1에서 차감한다.
     */
    private static void getZegopNoNoSu() {
        List<Long> zegopsulist = getZegopsu(); // 구한 제곱수 리스트로 초기화
        boolean[] isNotSquareFree = new boolean[(int) (max - min + 1)];

        zegopsulist.forEach(e -> {
            long start = (min % e == 0) ? min : (min / e + 1) * e;
            for (long i = start; i <= max; i += e) {
                isNotSquareFree[(int) (i - min)] = true;
            }
        });

        list.clear();
        for (int i = 0; i < isNotSquareFree.length; i++) {
            if (!isNotSquareFree[i]) {
                list.add(min + i);
            }
        }
    }

    private static void input() {
        min = sc.nextLong();
        max = sc.nextLong();
    }

    private static void init() {
        for (long i = min; i <= max; i++) {
            list.add(i);
        }
    }

    private static void print() {
        System.out.println(list.size());
    }
}
