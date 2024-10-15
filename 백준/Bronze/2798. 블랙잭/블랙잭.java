import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 카드 개수와 최대값 입력
        int cardAmount = sc.nextInt(); // 카드 개수 3~100
        int maximumNumber = sc.nextInt(); // 10~300,000

        // 카드 목록을 입력받음
        List<Integer> cardList = new ArrayList<>(cardAmount);
        for (int i = 0; i < cardAmount; i++) {
            cardList.add(sc.nextInt()); // 카드 개수만큼 숫자 입력
        }

        // 결과 출력
        System.out.println(getReachMaximumNumber(cardList, maximumNumber));
    }

    private static int getReachMaximumNumber(List<Integer> cardList, int maximumNumber) {
        int maxSum = 0;  // 최대 합을 저장할 변수
        int size = cardList.size();

        // 서로 다른 세 개의 카드를 선택하여 최대 합을 구하는 부분
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    int sum = cardList.get(i) + cardList.get(j) + cardList.get(k);
                    if (sum <= maximumNumber && sum > maxSum) { // 최대값과 같거나 작을 때만 선택
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;  // 최대 합을 반환
    }
}
