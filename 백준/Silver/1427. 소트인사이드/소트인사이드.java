import java.util.*;

/**
 * [문제]
 * 수가 주어지면, 각 자리수를 내림차순으로 정렬
 *
 * [입력]
 * LINE 1 : 정렬하려고 하는 수 N(N <= 1,000,000,000)
 *
 * [출력]
 * 첫째 줄에 자리수를 내림차순으로 정렬한 후 출력
 *
 * [설계]
 * 1. N의 조건에 따라 N은 int 자료형을 사용해야 하지만 각 자리수를 내림차순으로 정렬하기 위해선 각 자리수를 따로 저장
 * 2. N의 자료형은 String -> 각 자리수를 저장할 자료형은 ArrayList로 결정(length를 모르기 떄문)
 * 3. 각 자리수가 저장된 배열을 내림차순 정렬 후 출력
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> devidedN = new ArrayList<>();
        String N = sc.nextLine();
        for(int i = 0; i < N.length(); i++) {
            devidedN.add(Integer.parseInt(String.valueOf(N.charAt(i))));
        }
        devidedN.sort(Collections.reverseOrder());

        Iterator<Integer> it = devidedN.iterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
