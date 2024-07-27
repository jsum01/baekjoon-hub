import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [ 입력 ]
 * 첫 줄 ( 빈 칸으로 구분 )
 * 1. 칭호의 개수 N ( 1~10^5 )
 * 2. 캐릭터들의 개수 M ( 1~10^5 )
 * <p>
 * 둘째 줄부터 N개의 줄에 입력
 * 3. 각 칭호의 이름을 나타내는 길이 1~11인 영어 대문자로 구성된 문자열
 * 4. 해당 칭호의 전투력 상한값을 나타내는 1,000,000,000(10^9) 이하의 음이 아닌 정수
 * (칭호는 전투력 상한값의 비내림차순으로 주어짐)
 * <p>
 * N + 2번째 줄부터 M개의 줄에 입력
 * 5. 캐릭터의 전투력을 나타내는 음이 아닌 정수
 * (해당하는 칭호가 없는 전투력은 입력으로 주어지지 않음)
 * <p>
 * [ 출력 ]
 * 6. M개의 줄에 걸쳐 캐릭터의 전투력에 맞는 칭호를 입력 순서대로 출력.
 * ( 어떤 캐릭터의 전투력으로 출력할 수 있는 칭호가 여러 개인 경우 가장 먼저 입력된 칭호 하나만 출력)
 */
public class Main {
    static List<CharacterAbility> caList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // first input
        String[] firstInput = br.readLine().split(" ");
        int titleAmt = Integer.parseInt(firstInput[0]); // 1
        int characterAmt = Integer.parseInt(firstInput[1]); // 2

        // second input ( power is undescending order )
        caList = new ArrayList<>(titleAmt);
        for (int i = 0; i < titleAmt; i++) {
            String[] titleInput = br.readLine().split(" ");
            caList.add(new CharacterAbility(titleInput[0], Integer.parseInt(titleInput[1]))); // 3, 4
        }

        // third input
        List<Integer> powerListOfCharacter = new ArrayList<>(characterAmt);
        for (int i = 0; i < characterAmt; i++) {
            powerListOfCharacter.add(Integer.parseInt(br.readLine().trim()));
        }

        // output
        for (int i = 0; i < powerListOfCharacter.size(); i++) {
            bw.write(searchMatchedTitleAboutPower(powerListOfCharacter.get(i)) + "\n");
        }
        bw.flush();
    }

    private static String searchMatchedTitleAboutPower(int target) {
        int start = 0;
        int end = caList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > caList.get(mid).power) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start < caList.size()) {
            return caList.get(start).title;
        } else {
            return null;
        }
    }

    static class CharacterAbility {
        private String title;
        private int power;

        public CharacterAbility(String title, int power) {
            this.title = title;
            this.power = power;
        }
    }
}