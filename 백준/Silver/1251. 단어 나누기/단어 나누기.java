import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static String inputWord;
    static ArrayList<String> resultList = new ArrayList<>();

    public static void main(String[] args) {
        inputWord = sc.nextLine();

        // 길이가 2 이하일 경우 분리 불가능, 예외 처리
        if (inputWord.length() >= 3) sepWord(); // 분리 및 조합
        else System.exit(0);


        if (!resultList.isEmpty()) Collections.sort(resultList); // 사전 순 정렬
        else System.exit(0);

        System.out.println(resultList.get(0)); // 가장 앞선 단어 출력
        sc.close();
    }

    private static void sepWord() {
        int length = inputWord.length();
        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String part1 = new StringBuilder(inputWord.substring(0, i)).reverse().toString();
                String part2 = new StringBuilder(inputWord.substring(i, j)).reverse().toString();
                String part3 = new StringBuilder(inputWord.substring(j)).reverse().toString();

                // 빈 문자열이 아닌 경우에만 리스트에 추가
                if (!part1.isEmpty() && !part2.isEmpty() && !part3.isEmpty()) {
                    resultList.add(part1 + part2 + part3);
                }
            }
        }
    }
}
